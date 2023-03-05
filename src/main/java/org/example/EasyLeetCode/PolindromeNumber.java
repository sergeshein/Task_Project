package org.example.EasyLeetCode;

public class PolindromeNumber {

        public boolean isPalindrome(int x) {
            if(x < 0){
                return false;
            }

            if(x % 10 == 0 && x != 0){
                return false;
            }

            int invertedNumber = 0;
            int copyOfx = x;

            while(copyOfx != 0){
                invertedNumber = invertedNumber * 10 + copyOfx % 10;
                copyOfx = copyOfx / 10;

            }
            return invertedNumber == x;

    }
}
