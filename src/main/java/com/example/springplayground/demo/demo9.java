package com.example.springplayground.demo;

public class demo9 {

    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 12; i++) {
            System.out.println(fibo(i));
        }
    }
}
