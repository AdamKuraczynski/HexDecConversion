/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Conversion hex to dec and dec to hex
 * This class provides methods for converting hexadecimal to decimal and decimal to hexadecimal.
 * 
 * @author Adam Kuraczyński
 * @version 1.29
 */
public class Model {

    
    private final ArrayList<String> conversionHistory;
    
     /**
     * Constructs a new Model object.
     */
    public Model() {
        this.conversionHistory = new ArrayList<>();
    }
    
    /**
     * Converts hex to dec value.
     * 
     * @param userHexInput The user input expected to be in HEX.
     * @return The decimal number.
     * @throws model.ConversionException If an invalid number is encountered in the input text.
     */
    public int hexToDecimal(String userHexInput) throws ConversionException {
        if (userHexInput == null) {
            throw new ConversionException("Prosze podac liczbe");
        }
        if (userHexInput.length() < 1) {
            throw new ConversionException("Prosze wpisac liczbe");
        }
        String digits = "0123456789ABCDEF";
        userHexInput = userHexInput.toUpperCase();
        // Temporary supportive value declaration
        int finalValue = 0;
        // For loop for manual conversion
        for (int i = 0; i < userHexInput.length(); i++) {
            char oneChar = userHexInput.charAt(i);
            // Takes i iteration from hex_number and assigns it to one_char variable
            // Reads dec number of one_char variable
            int digitValue = digits.indexOf(oneChar);
            if (digitValue == -1) {
                throw new ConversionException("Bledny znak HEX");
            }
            HexFinalValueCount calculateHexFinal = (fv, dv) -> 16 * fv + dv;
            finalValue = calculateHexFinal.calculateHex(finalValue, digitValue);
        }         
        conversionHistory.add(String.valueOf(finalValue));
        return finalValue;
    }

    /**
     * Converts dec to hex value.
     * 
     * @param userDecimalValue The user input expected to be in DEC.
     * @return The hexadecimal number.
     * @throws model.ConversionException If an invalid number is encountered in the input text.
     */
    public String decimalToHex(String userDecimalValue) throws ConversionException {
        if (userDecimalValue == null) {
            throw new ConversionException("Prosze podac liczbe");
        }
        if (userDecimalValue.length() < 1) {
            throw new ConversionException("Prosze wpisac liczbe");
        }
        if (userDecimalValue.contains(".")) {
            throw new ConversionException("Wartosc dziesietna nie moze byc liczba zmiennoprzecinkowa");
        }
        int decimalValue = Integer.parseInt(userDecimalValue);
        if (decimalValue < 0) {
            throw new ConversionException("Wartosc dziesietna nie moze byc negatywna");
        }
        int restAmount;
        String hexValue = "";
        List<String> hexChars = createHexCharsSet();
        // While loop for manual conversion
        while (decimalValue > 0) {
            restAmount = decimalValue % 16;
            //
            hexValue = hexChars.get(restAmount) + hexValue;
            decimalValue = decimalValue / 16;
        }
        conversionHistory.add(hexValue);
        return hexValue;
    }

    /**
     * Collection with possible HEX digits.
     * 
     * @return A collection with possible HEX digits.
     */
    private List<String> createHexCharsSet() {
        List<String> hexChars = new ArrayList<>();
        hexChars.add("0");
        hexChars.add("1");
        hexChars.add("2");
        hexChars.add("3");
        hexChars.add("4");
        hexChars.add("5");
        hexChars.add("6");
        hexChars.add("7");
        hexChars.add("8");
        hexChars.add("9");
        hexChars.add("A");
        hexChars.add("B");
        hexChars.add("C");
        hexChars.add("D");
        hexChars.add("E");
        hexChars.add("F");
        return hexChars;
    }
    
    
     /**
     * Gets the history list
     *
     * @return List of converted values
     */
    public ArrayList<String> getConversionHistory() {
        return conversionHistory;
    }
    
    private static final int NUM_HEX_DIGITS = 16;

    /**
     * Collection with possible HEX digits using stream.
     * 
     * @return A collection with possible HEX digits using stream.
     */
    private List<String> createHexCharsSetUsingStream() {
        return IntStream.range(0, NUM_HEX_DIGITS)
                .mapToObj(i -> Integer.toHexString(i).toUpperCase())
                .collect(Collectors.toList());
    }
}