package com.example.springplayground.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class demo15 {

    @Data
    public static class Animal {
        String name;
        Integer legs;
        Boolean fly;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Dog extends Animal {
        Boolean canBark;
        public String bark() {
            return "Wo wo";
        }
    }

    @Data
    public static class Bird extends Animal {
        Boolean canSing;
        public String sing() {
            return "do do";
        }
    }

    public static void main(String[] args) {

    }
}
