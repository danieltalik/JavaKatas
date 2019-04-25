package romanNumerals;

import java.util.ArrayList;
import java.util.List;

public class RomanNumerals {

    String[] romanNumerals = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I", ""};
    Integer[] arabicNumerals = new Integer[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1, 0};
    List<String> romanNums = new ArrayList<String>();
    List<String> doubleRoman = new ArrayList<String>();
    List<String> singleRoman = new ArrayList<String>();
    List<Integer> doubleArabic = new ArrayList<Integer>();
    List<Integer> singleArabic = new ArrayList<Integer>();

    //I COULD have just made everything a list. But I wanted to practice loop iteration
    public RomanNumerals() {
        //Adds congruent lists of Arabic and Roman numbers in separate lists with the same indices

        //Add single character numerals which start at index 0 and iterate every other array item
        for (int i = 0; i < romanNumerals.length - 1; i += 2) {
            singleRoman.add(romanNumerals[i]);
            singleArabic.add(arabicNumerals[i]);
        }
        //Start at index 1 and add every other one for double character numerals
        for (int i = 1; i < romanNumerals.length - 1; i += 2) {
            doubleRoman.add(romanNumerals[i]);
            doubleArabic.add(arabicNumerals[i]);
        }
    }

    public int numeralToNumbers(String numeral) {

        int number = 0;
        String append;
        List<Character> numList = new ArrayList<Character>();
        //Takes the string, converts to a char array, and populates a list to manipulate
        for (char c : numeral.toCharArray()) {
            numList.add(c);
        }

        //Checks if the numerals list contains the numeral and returns the corresponding number from the number array
        if (romanNums.contains(numeral)) {
            int i = romanNums.indexOf(numeral);
            number = arabicNumerals[i];
        }
        //If it is not in the list, it contains more than one numeral
        else {
            /*Iterates backwards and removes the char sets from the char list
              and adds the corresponding values to the number
             */
            for (int i = numeral.length(); i > 1; i--) {

                if (doubleRoman.contains(numeral.substring(i - 2, i))) {
                    int j = doubleRoman.indexOf(numeral.substring(i - 2, i));
                    number += doubleArabic.get(j);
                    //Removes the double char set from the list
                    numList.remove(i - 1);
                    numList.remove(i - 2);
                }
            }
            //append is the char list with the pairs removed and converted to a string
            append = numList.toString();

            //Looks for and adds the remaining single char numerals and adds its matching value
            for (int i = 0; i < append.length(); i++) {
                if (singleRoman.contains(append.substring(i, i + 1))) {
                    int j = singleRoman.indexOf(append.substring(i, i + 1));
                    number += singleArabic.get(j);
                }
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
