package com.example.springplayground.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class demo13 {

    @Data
    @AllArgsConstructor
    static class Employee {
        public int employeeId;
        public String employeeName;
    }

    public static void convert(List<Employee> list) {
//        Map<Integer, String> map = list.stream().collect(Collectors.groupingBy(Employee::getEmployeeId).toMap(Employee::getEmployeeId, Employee::getEmployeeName));
        Map<Integer, List<Employee>> map1 = list.stream().collect(Collectors.groupingBy(Employee::getEmployeeId));
//        Map<Integer, String> map = (Map<Integer, String>) map1;
    }

    public static void findDup(List<Integer> list) {
        Set<Integer> items = new HashSet<>();
//        Set<Integer> set = list.stream().collect(Collectors.toSet());
//        Stream<Integer> dup = list.stream().filter(i -> !set.contains(i)).collect(Collectors.toList();
        List<Integer> dup = list.stream().filter(i -> !items.add(i)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Employee> l1 = new ArrayList<>();
        l1.add(new Employee(1, "A"));
    }
}
