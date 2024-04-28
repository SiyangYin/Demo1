package com.example.springplayground.demo;

import java.util.*;
import java.util.stream.Collectors;

public class JZ502 {

    static Map<String, NavigableMap<Integer, String>> table = new HashMap<>();

    static class Column {
        int key;
        String value;

        public Column(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Column{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        run();
    }

    static void run() {
        insert("g", 1, "h");
        insert("l", 1, "g");
        insert("g", 2, "h");
        query("g", 0, 1);
        query("g", 0, 2);
        query("go", 0, 1);
        query("l", 0, 10);
    }

    static void insert(String rk, int ck, String val) {
        NavigableMap<Integer, String> row = table.getOrDefault(rk, new TreeMap<>());
        row.put(ck, val);
        table.putIfAbsent(rk, row);
    }

    static void query(String rk, int cs, int ce) {
        List<Column> collect = table.getOrDefault(rk, new TreeMap<>())
                .subMap(cs, true, ce, true).entrySet()
                .stream().map(i -> new Column(i.getKey(), i.getValue())).collect(Collectors.toList());
        System.out.println(collect);
    }
}
