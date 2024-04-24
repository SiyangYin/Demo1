package com.example.springplayground.demo;

public class Test {
    public static void main(String... args) {
        Object o = new Object() {
            public boolean equals(Object t) {
                return t.equals("hi");
            }
        };
        System.out.println(o.equals("hi"));
    }
}