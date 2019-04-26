package romanNumerals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomanNumerals {


    //Set up 2 string arrays for single and double char numeral groupings and 2 int arrays for their corresponding values
    String[] doubleRoman = new String[]{"CM", "CD", "XC", "XL", "IX", "IV",};
    String[] singleRoman = new String[]{"M", "D", "C", "L", "X", "V", "I", ""};
    int[] doubleArabic = new int[]{900, 400, 90, 40, 9, 4};
    int[] singleArabic = new int[]{1000, 500, 100, 50, 10, 5, 1, 0};


    public int numeralToNumbers(String numeral) {

        int number = 0;
        String append;
        List<Character> numList = new ArrayList<Character>();

        //Takes the string, converts to a char array, and populates a list for manipulation
        for (char c : numeral.toCharArray()) {
            numList.add(c);
        }
        //Loops through the double char numerals array
        for (int i = numeral.length(); i > 1; i--) {

            //TODO: Refine to match in array form vs converting to a list
            if (Arrays.asList(doubleRoman).contains(numeral.substring(i - 2, i))) {
                int j = Arrays.asList(doubleRoman).indexOf(numeral.substring(i - 2, i));
                number += doubleArabic[j];
                //Removes the double char set from the list
                numList.remove(i - 1);
                numList.remove(i - 2);
            }
        }
        //append is the char list with the pairs removed and converted to a string
        append = numList.toString();

        //Looks for and adds the remaining single char numerals and adds its matching value
        for (int i = 0; i < append.length(); i++) {
            //TODO: Refine to match in array form vs converting to a list
            if (Arrays.asList(singleRoman).contains(append.substring(i, i + 1))) {
                int j = Arrays.asList(singleRoman).indexOf(append.substring(i, i + 1));
                number += singleArabic[j];
            }
        }
        return number;
    }

    public String numberToNumeral(int num) {

        String numeral = "";
        /*While loop runs while number has value. Each statement subtracts the number
          by the value each numeral represents if it is greater than or equal to the numeral's value.
          It then concatenates the string for each numeral for return
         */
        if (num < 0) {
            return numeral;
        } else {
            while (num != 0) {
                if (num >= 1000) {
                    num -= 1000;
                    numeral += "M";
                } else if (num >= 900) {
                    num -= 900;
                    numeral += "CM";
                } else if (num >= 500) {
                    num -= 500;
                    numeral += "D";
                } else if (num >= 400) {
                    num -= 400;
                    numeral += "CD";
                } else if (num >= 100) {
                    num -= 100;
                    numeral += "C";
                } else if (num >= 90) {
                    num -= 90;
                    numeral += "XC";
                } else if (num >= 50) {
                    num -= 50;
                    numeral += "L";
                } else if (num >= 40) {
                    num -= 40;
                    numeral += "XL";
                } else if (num >= 10) {
                    num -= 10;
                    numeral += "X";
                } else if (num >= 9) {
                    num -= 9;
                    numeral += "IX";
                } else if (num >= 5) {
                    num -= 5;
                    numeral += "V";
                } else if (num >= 4) {
                    num -= 4;
                    numeral += "IV";
                } else if (num >= 1) {
                    num -= 1;
                    numeral += "I";
                }
            }
        }
        return numeral;
    }

}
