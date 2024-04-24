package com.example.springplayground.demo;

public class demo5 {

    public static int[] solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        int min = arr[0];
        int max = arr[1];
        int diff = max - min;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 1] < min) {
                min = arr[i - 1];
            }
            int val = arr[i] - min;
            if (val > diff) {
                diff = val;
                max = arr[i];
            }

        }
        return new int[]{max - diff, max};
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{8, 5, 12, 9, 19, 1};
        int[] arr2 = new int[]{21, 12, 11, 9, 6, 3};
        int[] answer1 = solution(arr1);
        int[] answer2 = solution(arr2);
        System.out.println(answer1[0] + " " + answer1[1]);
        System.out.println(answer2[0] + " " + answer2[1]);
//        System.out.println();
    }
}
