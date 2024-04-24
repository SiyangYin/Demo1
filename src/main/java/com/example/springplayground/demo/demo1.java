package com.example.springplayground.demo;

public class demo1 {

    public static void main(String[] args) {
//        System.out.println(calculateFactorial(5));
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("abccba"));
        System.out.println(isPalindrome("abcde"));
    }

    public static int calculateFactorial(int n) {
        if(n < 1) return 0;
        int result = 1;
        for(int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

}
