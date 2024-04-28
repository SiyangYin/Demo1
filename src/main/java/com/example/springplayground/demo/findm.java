package com.example.springplayground.demo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class findm {

    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) {
        add(1);
        add(2);
        System.out.println(findm());
        add(3);
        System.out.println(findm());
    }

    static void add(int i) {
        if (minHeap.isEmpty()) {
            minHeap.offer(i);
        } else if (i >= minHeap.peek()) {
            minHeap.offer(i);
            while (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            }
        } else {
            maxHeap.offer(i);
            while (maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
        }
    }

    static double findm() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}
