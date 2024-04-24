package com.example.springplayground.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class demo18 {

    static class FoodRatings {

        class Food {
            String name;
            int rate;

            public Food(String name, int rate) {
                this.name = name;
                this.rate = rate;
            }
        }

        Map<String, PriorityQueue<Food>> c2f = new HashMap<>();
        Map<String, Integer> f2r = new HashMap<>();
        Map<String, String> f2c = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                f2r.put(foods[i], ratings[i]);
                f2c.put(foods[i], cuisines[i]);
                PriorityQueue<Food> maxHeap = c2f.getOrDefault(cuisines[i], new PriorityQueue<>((i1, i2) -> i1.rate != i2.rate ? i2.rate - i1.rate : i1.name.compareTo(i2.name)));
                maxHeap.offer(new Food(foods[i], ratings[i]));
                c2f.putIfAbsent(cuisines[i], maxHeap);
            }
            System.out.println("null");
        }

        public void changeRating(String food, int newRating) {
            System.out.println("null");
            f2r.put(food, newRating);
            c2f.get(f2c.get(food)).offer(new Food(food, newRating));
        }

        public String highestRated(String cuisine) {
            PriorityQueue<Food> maxHeap = c2f.get(cuisine);
            while (maxHeap.peek().rate != f2r.get(maxHeap.peek().name)) {
                maxHeap.poll();
            }
            System.out.println(maxHeap.peek());
            return maxHeap.peek().name;
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
