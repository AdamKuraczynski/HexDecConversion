/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

/**
 * Test class for {@link Model} - Conversion hex to dec and dec to hex.
 *
 * @author Adam Kuraczyński
 * @version 1.19
 */
public class ModelTest {

    private Model model;

    /**
     * Set up the test environment before each test case. Initializes a new
     * instance of the Model class for testing purposes.
     */
    @BeforeEach
    public void setUp() {
        model = new Model();
    }

    /**
     * Test for hexToDecimal method with null input.
     *
     * @param userHexInput The user input in HEX.
     */
    @ParameterizedTest
    @NullSource
    public void testHexToDecimalNullInput(String userHexInput) {
        ConversionException exception = assertThrows(
                ConversionException.class,
                () -> model.hexToDecimal(userHexInput),
                "Expected ConversionException, but it was not thrown."
        );
        assertEquals("Prosze podac liczbe", exception.getMessage(), "Test did not report the expected exception (null)");
    }

    /**
     * Test for hexToDecimal method with length below 1 input.
     *
     * @param userHexInput The user input in HEX.
     */
    @ParameterizedTest
    @CsvSource({"''"})
    public void testHexToDecimalLenghtInput(String userHexInput) {
        ConversionException exception = assertThrows(
                ConversionException.class,
                () -> model.hexToDecimal(userHexInput),
                "Expected ConversionException, but it was not thrown."
        );
        assertEquals("Prosze wpisac liczbe", exception.getMessage(), "Test did not report the expected exception (length below 1)");
    }

    /**
     * Test for hexToDecimal method with not a HEX value input.
     *
     * @param userHexInput The user input in HEX.
     */
    @ParameterizedTest
    @CsvSource({"X"})
    public void testhexToDecimalNotAHexValue(String userHexInput) {
        ConversionException exception = assertThrows(
                ConversionException.class,
                () -> model.hexToDecimal(userHexInput),
                "Expected ConversionException, but it was not thrown."
        );
        assertEquals("Bledny znak HEX", exception.getMessage(), "Test did not report the expected exception (Not a Hex Value)");
    }

    /**
     * Test for hexToDecimal method with correct values input.
     *
     * @param userHexInput1 The first user input in HEX.
     * @param userHexInput2 The second user input in HEX.
     * @param userHexInput3 The third user input in HEX.
     */
    @ParameterizedTest
    @CsvSource({"10, A1, CD"})
    public void testHexToDecCorrectValues(String userHexInput1, String userHexInput2, String userHexInput3) {
        try {
            model.hexToDecimal(userHexInput1);
        } catch (ConversionException e) {
            assertEquals(16, userHexInput1, "This should be the value before conversion -> 10");
        }
        try {
            model.hexToDecimal(userHexInput2);
        } catch (ConversionException e) {
            assertEquals(161, userHexInput1, "This should be the value before conversion -> A1");
        }
        try {
            model.hexToDecimal(userHexInput3);
        } catch (ConversionException e) {
            assertEquals(205, userHexInput1, "This should be the value before conversion -> CD");
        }
    }

    /**
     * Test for hexToDecimal method with edge values input.
     *
     * @param userHexInput1 The first user input in HEX.
     * @param userHexInput2 The second user input in HEX.
     * @param userHexInput3 The third user input in HEX.
     */
    @ParameterizedTest
    @CsvSource({"FF, 00, 9A"})
    public void testHexToDecEdgeValues(String userHexInput1, String userHexInput2, String userHexInput3) {
        try {
            model.hexToDecimal(userHexInput1);
        } catch (ConversionException e) {
            assertEquals(255, userHexInput1, "This should be the value before conversion -> FF");
        }
        try {
            model.hexToDecimal(userHexInput2);
        } catch (ConversionException e) {
            assertEquals(0, userHexInput1, "This should be the value before conversion -> 00");
        }
        try {
            model.hexToDecimal(userHexInput3);
        } catch (ConversionException e) {
            assertEquals(154, userHexInput1, "This should be the value before conversion -> 9A");
        }
    }

    /**
     * Test for decimalToHex method with null input.
     *
     * @param userDecInput The user input in DEC.
     */
    @ParameterizedTest
    @NullSource
    public void testDecToHexNullInput(String userDecInput) {
        ConversionException exception = assertThrows(
                ConversionException.class,
                () -> model.decimalToHex(userDecInput),
                "Expected ConversionException, but it was not thrown."
        );
        assertEquals("Prosze podac liczbe", exception.getMessage(), "Test did not report the expected exception (null)");
    }

    /**
     * Test for decimalToHex method with length below 1 input.
     *
     * @param userDecInput The user input in DEC.
     */
    @ParameterizedTest
    @CsvSource({"''"})
    public void testDecToHexLenghtInput(String userDecInput) {
        ConversionException exception = assertThrows(
                ConversionException.class,
                () -> model.decimalToHex(userDecInput),
                "Expected ConversionException, but it was not thrown."
        );
        assertEquals("Prosze wpisac liczbe", exception.getMessage(), "Test did not report the expected exception (length below 1)");
    }

    /**
     * Test for decimalToHex method with not an integer value input.
     *
     * @param userDecInput The user input in DEC.
     */
    @ParameterizedTest
    @CsvSource({"."})
    public void testDecToHexNotIntInput(String userDecInput) {
        ConversionException exception = assertThrows(
                ConversionException.class,
                () -> model.decimalToHex(userDecInput),
                "Expected ConversionException, but it was not thrown."
        );
        assertEquals("Wartosc dziesietna nie moze byc liczba zmiennoprzecinkowa", exception.getMessage(), "Test did not report the expected exception (value different than integer)");
    }

    /**
     * Test for decimalToHex method with negative value input.
     *
     * @param userDecInput The user input in DEC.
     */
    @ParameterizedTest
    @CsvSource({"-1"})
    public void testDecToHexNegativeValue(String userDecInput) {
        ConversionException exception = assertThrows(
                ConversionException.class,
                () -> model.decimalToHex(userDecInput),
                "Expected ConversionException, but it was not thrown."
        );
        assertEquals("Wartosc dziesietna nie moze byc negatywna", exception.getMessage(), "Test did not report the expected exception (value is negative (-))");
    }

    /**
     * Test for decimalToHex method with correct values input.
     *
     * @param userDecInput1 The first user input in DEC.
     * @param userDecInput2 The second user input in DEC.
     * @param userDecInput3 The third user input in DEC.
     */
    @ParameterizedTest
    @CsvSource({"100, 789056, 666"})
    public void testDecToHexCorrectValues(String userDecInput1, String userDecInput2, String userDecInput3) {
        try {
            model.decimalToHex(userDecInput1);
        } catch (ConversionException e) {
            assertEquals("64", userDecInput1, "This should be the value before conversion -> 100");
        }
        try {
            model.decimalToHex(userDecInput2);
        } catch (ConversionException e) {
            assertEquals("C0A40", userDecInput2, "This should be the value before conversion -> 789056");
        }
        try {
            model.decimalToHex(userDecInput3);
        } catch (ConversionException e) {
            assertEquals("29A", userDecInput3, "This should be the value before conversion -> 666");
        }
    }

    /**
     * Test for decimalToHex method with edge values input.
     *
     * @param userDecInput1 The first user input in DEC.
     * @param userDecInput2 The second user input in DEC.
     * @param userDecInput3 The third user input in DEC.
     */
    @ParameterizedTest
    @CsvSource({"0, 00123, 255"})
    public void testDecToHexEdgeValues(String userDecInput1, String userDecInput2, String userDecInput3) {
        try {
            model.decimalToHex(userDecInput1);
        } catch (ConversionException e) {
            assertEquals("0", userDecInput1, "This should be the value before conversion -> 0");
        }
        try {
            model.decimalToHex(userDecInput2);
        } catch (ConversionException e) {
            assertEquals("7B", userDecInput2, "This should be the value before conversion -> 00123");
        }
        try {
            model.decimalToHex(userDecInput3);
        } catch (ConversionException e) {
            assertEquals("FF", userDecInput3, "This should be the value before conversion -> 255");
        }

    }

}
