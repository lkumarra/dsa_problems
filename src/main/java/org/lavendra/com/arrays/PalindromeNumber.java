package org.lavendra.com.arrays;

public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber number = new PalindromeNumber();
        System.out.println(number.isPalindromeNumber(121));
    }

    public boolean isPalindromeNumber(int input) {
        int reversedNumber = 0;
        int number = input;
        while (number != 0) {
            int reminder = number % 10;
            reversedNumber = reversedNumber * 10 + reminder;
            number /= 10;
        }
        return reversedNumber == input;
    }
}
