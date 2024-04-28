package com.example.springplayground.demo;

import java.util.HashMap;
import java.util.Map;

public class JZ525 {

    static class Location {
        double lat;
        double lng;

        public Location(double lat, double lng) {
            this.lat = lat;
            this.lng = lng;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "lat=" + lat +
                    ", lng=" + lng +
                    '}';
        }
    }

    static class Trip {
        int id;
        int did;
        int rid;
        Location location;

        public Trip(int did, int rid, Location location) {
            this.id = cnt++;
            this.did = did;
            this.rid = rid;
            this.location = location;
        }

        @Override
        public String toString() {
            return "Trip{" +
                    "id=" + id +
                    ", did=" + did +
                    ", rid=" + rid +
                    ", location=" + location +
                    '}';
        }
    }

    static int cnt = 0;
    static Map<Integer, Trip> d2t = new HashMap<>();
    static Map<Integer, Location> d2l = new HashMap<>();

    public static void main(String[] args) {
        run();
    }

    static void run() {
        report(1, 36, 77);
        report(2, 45, 76);
        request(2, 39, 76);
        report(1, 38, 75);
        report(2, 45, 76);
    }

    static double getDis(Location l1, Location l2) {
        return Math.sqrt(Math.pow(l1.lat - l2.lat, 2) + Math.pow(l1.lng - l2.lng, 2));
    }

    static void report(int did, double lat, double lng) {
        if (d2t.containsKey(did)) {
            System.out.println(d2t.get(did));
        } else {
            System.out.println("null");
            d2l.put(did, new Location(lat, lng));
        }
    }

    static void request(int rid, double lat, double lng) {
        Integer did = d2l.entrySet().stream()
                .min((i1, i2) -> (int) (getDis(i1.getValue(), new Location(lat, lng)) - getDis(i2.getValue(), new Location(lat, lng))))
//                .min((i1, i2) -> (int) (getDis(i2.getValue(), new Location(lat, lng)) - getDis(i1.getValue(), new Location(lat, lng))))
//                .max((i1, i2) -> (int) (getDis(i1.getValue(), new Location(lat, lng)) - getDis(i2.getValue(), new Location(lat, lng))))
//                .max((i1, i2) -> (int) (getDis(i2.getValue(), new Location(lat, lng)) - getDis(i1.getValue(), new Location(lat, lng))))
                .get().getKey();
        if (did != -1) {
            d2t.put(did, new Trip(did, rid, new Location(lat, lng)));
            d2l.remove(did);
            System.out.println(d2t.get(did));
        }
    }
}
