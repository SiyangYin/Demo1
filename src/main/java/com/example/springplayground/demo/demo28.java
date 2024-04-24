package com.example.springplayground.demo;

import java.util.HashMap;
import java.util.Map;

public class demo28 {

     static class ListNode {
         int key;
         int val;
         ListNode prev;
         ListNode next;

         public ListNode(int key, int val) {
             this.key = key;
             this.val = val;
         }
     }

    static int cap = 10;
    static Map<Integer, ListNode> map = new HashMap<>();
    static ListNode head = null;
    static ListNode tail = null;

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        for (int i = 0; i < a.length; i++) {
            put(i, a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(get(i));
        }
    }

    static Integer get(int i) {
        ListNode node = map.get(i);
        if (node == null) return null;
        if (node != head) {
            remove(node);
            insert(node);
        }
        return node.val;
    }

    static void put(int i, int v) {
        remove(i);
        if (map.size() >= cap && tail != null) {
            remove(tail.key);
        }
        ListNode node = new ListNode(i, v);
        insert(node);
        map.put(i, node);
    }

    static void remove(int i) {
        ListNode node = map.get(i);
        remove(node);
        map.remove(i);
    }

    static void remove(ListNode node) {
        if (node == null) return;
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
        if (node == tail) tail = node.prev;
        if (node == head) head = node.next;
    }

    static void insert(ListNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }
}
