package jearias.katas.romancalculator;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */
/**
 * <p>
 * RomanCalculator
 * </p>
 * <p>
 * Kata of Roman Calculator http://codingdojo.org/cgi-bin/wiki.pl?KataRomanCalculator
 * </p>
 * 
 * @author jearias 23/08/2013 - Kinetica Mobile offices
 */
public class RomanCalculator implements Comparator<String> {

    /**
     * Roman symbols
     */
    private static String symbols = "IVXLCDM";

    /**
     * Different associations
     */
    private static String[][] fourSymbols = { { "IIII", "IV" }, { "XXXX", "XL" }, { "CCCC", "CD" } };
    private static String[][] fiveSymbols = { { "IIIII", "V" }, { "VV", "X" }, { "XXXXX", "L" }, { "LL", "C" }, { "CCCCC", "D" } };
    private static String[][] nineSymbols = { { "VIIII", "IX" }, { "LXXXX", "XC" }, { "DCCCC", "CM" } };

    /**
     * Add two numbers in Roman numerals
     * 
     * @param number1
     * @param number2
     * @return result
     */
    public static String add(String number1, String number2) {
        String result;

        number1 = expandNumber(number1);
        number2 = expandNumber(number2);

        result = concatenateNumbers(number1, number2);
        result = sortSymbols(result);
        result = regroupResult(result);

        return result;
    }

    /**
     * Method that performs a set of operations of grouping and expansion so that the number is perfectly represented
     * 
     * @param result
     * @return result
     */
    private static String regroupResult(String result) {
        // group symbols, i.e. IIIII to V
        result = replaceSymbols(result, fiveSymbols, 0);
        // group symbols, i.e. IIII to IV
        result = replaceSymbols(result, fourSymbols, 0);
        // expand symbols, i.e. IV to IIII
        result = replaceSymbols(result, fourSymbols, 1);
        // group symbols, i.e. VIIII to IX
        result = replaceSymbols(result, nineSymbols, 0);
        // group symbols, i.e. IIII to IV
        result = replaceSymbols(result, fourSymbols, 0);
        return result;
    }

    /**
     * Method that expand the number
     * 
     * @param number
     * @return number
     */
    private static String expandNumber(String number) {
        number = replaceSymbols(number, fourSymbols, 1);
        number = replaceSymbols(number, nineSymbols, 1);
        return number;
    }

    /**
     * Concatenate two numbers
     * 
     * @param number1
     * @param number2
     * @return result
     */
    private static String concatenateNumbers(String number1, String number2) {
        String result = number1 + number2;
        return result;
    }

    /**
     * Method that replace symbols given a particular association
     * 
     * @param number
     * @param group
     * @param inverse
     *            : indicates if the association is in one way or another
     * @return number
     */
    private static String replaceSymbols(String number, String[][] group, int inverse) {
        int index1 = inverse == 0 ? 0 : 1;
        int index2 = inverse == 0 ? 1 : 0;

        for (int i = 0; i < group.length; i++) {
            number = number.replace(group[i][index1], group[i][index2]);
        }
        return number;
    }

    /**
     * sorting the string of symbols depending on the weight of the symbols
     * 
     * @param string
     * @return
     */
    private static String sortSymbols(String string) {
        String[] resultArray = string.split("");
        Arrays.sort(resultArray, new RomanCalculator());

        StringBuilder builder = new StringBuilder();
        for (String s : resultArray) {
            builder.append(s);
        }
        string = builder.toString();
        return string;
    }

    /**
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    public int compare(String symbol1, String symbol2) {
        int comparation = 0;
        int index1 = symbols.indexOf(symbol1);
        int index2 = symbols.indexOf(symbol2);

        if (index1 > index2) {
            comparation = -1;
        } else if (index1 < index2) {
            comparation = 1;
        }
        return comparation;
    }

}
