/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 * Interface for calculating the final hex value.
 * Used to demonstrate lambda expressions.
 * 
 * @author Adam Kuraczyński
 * @version 1.2
 */
public interface HexFinalValueCount {

    /**
     * Calculates the final hex value based on the provided parameters.
     * 
     * @param finalValue The current final hex value.
     * @param digitValue The digit value to be considered.
     * @return The updated final hex value after the calculation.
     */
    int calculateHex(int finalValue, int digitValue);
}
