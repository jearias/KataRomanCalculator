package jearias.katas.romancalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanCalculatorTest {

    @Test
    public void testOnePlusOne() throws Exception {
        assertEquals("II", RomanCalculator.add("I", "I"));
    }

    @Test
    public void testOnePlusTwo() {
        assertEquals("III", RomanCalculator.add("II", "I"));
    }

    @Test
    public void testTwoPlusTwo() {
        assertEquals("IV", RomanCalculator.add("II", "II"));
    }

    @Test
    public void testTwoPlusThree() {
        assertEquals("V", RomanCalculator.add("II", "III"));
    }

    @Test
    public void testEightPlusTwo() {
        assertEquals("X", RomanCalculator.add("VIII", "II"));
    }

    @Test
    public void testTwoPlusEight() {
        assertEquals("X", RomanCalculator.add("II", "VIII"));
    }

    @Test
    public void testFivePlusFour() {
        assertEquals("IX", RomanCalculator.add("V", "IV"));
    }

    @Test
    public void testNinePlusNine() {
        assertEquals("XVIII", RomanCalculator.add("IX", "IX"));
    }

    @Test
    public void test19Plus2() {
        assertEquals("XXI", RomanCalculator.add("XIX", "II"));
    }

    @Test
    public void test199Plus234() {
        assertEquals("CDXXXIII", RomanCalculator.add("CXCIX", "CCXXXIV"));
    }

}