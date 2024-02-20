/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Custom exception class representing the scenario when no provided value can
 * be converted by any means
 * 
 * @author Adam Kuraczyński
 * @version 1.1
 */

public class ConversionException extends Exception {

    /**
     * Constructs ConversionException with message
     * @param message - returns message with Error Information Specified
     */
    public ConversionException(String message) {
        super(message);
    }
    
}
