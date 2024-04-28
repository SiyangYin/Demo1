package com.example.springplayground.demo;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

public class JZ501 {

    static class Node {
        Timestamp time;
        String text;

        public Node(Timestamp time, String text) {
            this.time = time;
            this.text = text;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "time=" + time +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

    static Map<Integer, List> u2t = new HashMap<>();
    static Map<Integer, Set> u2u = new HashMap<>();
    static int cap = 10;

    public static void main(String[] args) {
        run();
    }

    static void run() {
        post(1, "good");
        System.out.println(getNewsFeed(1));
        System.out.println(getTimeLine(1));
        follow(2, 1);
        post(1, "best");
        System.out.println(getNewsFeed(2));
        unfollow(2, 1);
        System.out.println(getNewsFeed(2));
    }

    static void post(int id, String text) {
        Node node = new Node(Timestamp.from(Instant.now()), text);
        List<Node> list = u2t.getOrDefault(id, new ArrayList());
        list.add(node);
        u2t.putIfAbsent(id, list);
    }

    static List<Node> getTimeLine(int id) {
        return u2t.getOrDefault(id, new ArrayList<>());
    }

    static List<Node> getNewsFeed(int id) {
        Set<Integer> set = u2u.getOrDefault(id, new HashSet<>());
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((i1, i2) ->
                getTimeLine(i2[0]).get(i2[1]).time.compareTo(getTimeLine(i1[0]).get(i1[1]).time));
        if (!getTimeLine(id).isEmpty()) {
            maxHeap.offer(new int[]{id, getTimeLine(id).size() - 1});
        }
        for (int i : set) {
            maxHeap.offer(new int[]{i, getTimeLine(i).size() - 1});
        }
        List<Node> list = new ArrayList<>();
        int cnt = 0;
        while (cnt < cap && !maxHeap.isEmpty()) {
            int[] i = maxHeap.poll();
            list.add(getTimeLine(i[0]).get(i[1]));
            cnt++;
            if (i[1] > 0) {
                maxHeap.offer(new int[]{i[0], i[1] - 1});
            }
        }
        return list;
    }

    static void follow(int id1, int id2) {
        Set<Integer> set = u2u.getOrDefault(id1, new HashSet());
        set.add(id2);
        u2u.putIfAbsent(id1, set);
    }

    static void unfollow(int id1, int id2) {
        Set<Integer> set = u2u.getOrDefault(id1, new HashSet<>());
        set.remove(id2);
        u2u.putIfAbsent(id1, set);
    }
}
