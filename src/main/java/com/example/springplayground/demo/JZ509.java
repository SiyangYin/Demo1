package com.example.springplayground.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JZ509 {

    static class Location {
        double lat;
        double lng;

        public Location(double lat, double lng) {
            this.lat = lat;
            this.lng = lng;
        }

        @Override
        public String toString() {
            return "Location{" + "lat=" + lat + ", lng=" + lng + '}';
        }
    }

    static class Restaurant {
        int id;
        String name;
        Location location;

        public Restaurant(String name, Location location) {
            this.id = cnt++;
            this.name = name;
            this.location = location;
        }

        @Override
        public String toString() {
            return "Restaurant{" + "id=" + id + ", name='" + name + '\'' + ", location=" + location + '}';
        }
    }

    static int cnt = 1;
    static Map<Integer, Restaurant> i2r = new HashMap<>();

    public static void main(String[] args) {
        run();
    }

    static void run() {
        add("L", 10.5, 11.6);
        add("C", 10.5, 11.6);
        getNb(10.5, 11.6, 6.7);
        remove(1);
        getNb(10.5, 11.6, 6.7);
    }

    static double getDis(Location l1, Location l2) {
        return Math.sqrt(Math.pow(l1.lat - l2.lat, 2) + Math.pow(l1.lng - l2.lng, 2));
    }

    static void add(String name, double lat, double lng) {
        Restaurant restaurant = new Restaurant(name, new Location(lat, lng));
        i2r.put(restaurant.id, restaurant);
        System.out.println(restaurant.id);
    }

    static void remove(int id) {
        i2r.remove(id);
    }

    static void getNb(double lat, double lng, double k) {
        List<String> collect = i2r.entrySet().stream()
                .filter(i -> getDis(i.getValue().location, new Location(lat, lng)) < k)
                .map(i -> i.getValue().name).collect(Collectors.toList());
        System.out.println(collect);
    }
}
