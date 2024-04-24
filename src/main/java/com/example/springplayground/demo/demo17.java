package com.example.springplayground.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class demo17 {

    static class FoodRatings {

        Map<String, PriorityQueue<String>> c2f = new HashMap<>();
        Map<String, Integer> f2r = new HashMap<>();
        Map<String, String> f2c = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                f2r.put(foods[i], ratings[i]);
                f2c.put(foods[i], cuisines[i]);
                PriorityQueue<String> maxHeap = c2f.getOrDefault(cuisines[i], new PriorityQueue<>((i1, i2) -> f2r.get(i1).equals(f2r.get(i2)) ? i1.compareTo(i2) : f2r.get(i2).compareTo(f2r.get(i1))));
                maxHeap.offer(foods[i]);
                c2f.putIfAbsent(cuisines[i], maxHeap);
            }
            System.out.println("null");
        }

        public void changeRating(String food, int newRating) {
            System.out.println("null");
            f2r.put(food, newRating);
            c2f.get(f2c.get(food)).remove(food);
            c2f.get(f2c.get(food)).offer(food);
        }

        public String highestRated(String cuisine) {
            PriorityQueue<String> maxHeap = c2f.get(cuisine);
            System.out.println(maxHeap.peek());
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        run2();
    }

    static void run1() {
        FoodRatings ratings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"}, new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7});
//        {"FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"}
        ratings.highestRated("korean");
        ratings.highestRated("japanese");
        ratings.changeRating("sushi", 16);
        ratings.highestRated("japanese");
        ratings.changeRating("ramen", 16);
        ratings.highestRated("japanese");
    }

    static void run2() {
        FoodRatings ratings = new FoodRatings(new String[]{"mpsaowuxj", "vpjohob", "fn", "clvugdxsaf", "rujps", "conjq", "rpqdawz"}, new String[]{"shrkuo", "shrkuo", "shrkuo", "shrkuo", "shrkuo", "shrkuo", "shrkuo"}, new int[]{3, 7, 1, 8, 4, 16, 11});
//        ["FoodRatings","highestRated","highestRated","changeRating","highestRated","highestRated","changeRating","highestRated","highestRated","changeRating","highestRated","highestRated"]
        ratings.highestRated("shrkuo");
        ratings.highestRated("shrkuo");
        ratings.changeRating("rpqdawz", 13);
        ratings.highestRated("shrkuo");
        ratings.highestRated("shrkuo");
        ratings.changeRating("conjq", 15);
        ratings.highestRated("shrkuo");
        ratings.highestRated("shrkuo");
        ratings.changeRating("rujps", 17);
        ratings.highestRated("shrkuo");
        ratings.highestRated("shrkuo");
    }
}
