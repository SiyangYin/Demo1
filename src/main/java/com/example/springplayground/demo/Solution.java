package com.example.springplayground.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Solution {

// Input: "Alex,25 Doyle,48 John,14"
// Output: "John,14 Alex,25 Doyle,48"


    public static void main(String[] args) {
        String input = "Alex,25 Doyle,48 John,14";
        System.out.println(solution(input));
        System.out.println(solution2(input));
    }

    public static String solution(String input) {
        List<List> res = new ArrayList<>();
        String[] strArr1 = input.split(" ");
        for (String str : strArr1) {
            String[] strArr2 = str.split(",");
            List list = new ArrayList<>();
            list.add(strArr2[0]);
            list.add(Integer.parseInt(strArr2[1]));
            res.add(list);
        }
        res.sort((l1, l2) -> (int)l1.get(1) - (int)l2.get(1));
        StringBuilder sb = new StringBuilder();
        for (List list : res) {
            sb.append(list.get(0));
            sb.append(",");
            sb.append(list.get(1));
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String solution2(String input) {
//        return Arrays.stream(input.split(" ")).map(i -> i.split(",")).sorted((a1, a2) -> Integer.parseInt(a1[1]) - Integer.parseInt(a2[1])).map(i -> i[0].join(",", i[1])).collect(Collectors.joining(" "));
        return Arrays.stream(input.split(" ")).map(i -> i.split(",")).sorted((i1, i2) -> Integer.parseInt(i1[1]) - Integer.parseInt(i2[1])).map(i -> Arrays.stream(i).collect(Collectors.joining(","))).collect(Collectors.joining(" "));
//        return Arrays.stream(input.split(" ")).map(i -> i.split(",")).sorted().map(i -> Arrays.stream(i).collect(Collectors.joining(","))).collect(Collectors.joining(" "));
//        return Arrays.stream(input.split(" ")).map(i -> i.split(",")).sorted((i1, i2) -> Integer.parseInt(i1[1]) - Integer.parseInt(i2[1])).map(i -> i[0] + "," + i[1]).collect(Collectors.joining(" "));
//        return (String) Arrays.stream(input.split(" ")).map(i -> i.split(",")).sorted((a1, a2) -> Integer.parseInt(a1[1]) - Integer.parseInt(a2[1])).map(i -> joining(",", i[0], i[1])).collect(joining(" "));
    }
}
