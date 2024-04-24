package com.example.springplayground.demo;

public class demo4 {
//    public static void main(String[] args) {
//        int x=3, y=5, z=10;
//        System.out.println(++z + y - y + z + x++);
//    }

    public static synchronized void main(String[] args) throws InterruptedException {
        Thread f = new Thread();
        f.start();
        System.out.print("A");
        f.wait(1000);
        System.out.print("B");
    }
}

