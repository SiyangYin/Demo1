package com.example.springplayground.demo;

import java.util.ArrayList;
import java.util.List;

public class JZ714 {

//    Assuming that all class variables are private and all class methods are public,
//    and all setters, getters are provided just to avoid boilerplate code for time saving purpose.

    static class Card {
        int value;

        public Card(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "value=" + value +
                    "}";
        }
    }

    static class Hand {
        List<Card> cards;

        public Hand() {
            cards = new ArrayList<>();
        }

        void insertCard(Card card) {
            cards.add(card);
        }

        List<Integer> getPossibleValues() {
            List<Integer> res = new ArrayList<>();

            int aceCnt = 0;
            int resWithoutAce = 0;
            for (Card card : cards) {
                if (card.value == 1) {
                    aceCnt++;
                } else if (card.value >= 11 && card.value <= 13) {
                    resWithoutAce += 10;
                } else {
                    resWithoutAce += card.value;
                }
            }
            for (int i = 0; i <= aceCnt; i++) {
                int one = i;
                int ele = aceCnt - i;
                res.add(resWithoutAce + one + ele * 11);
            }
            return res;
        }

        int getBestValue() {
            return getPossibleValues().stream().filter(i -> i <= 21).max(Integer::compareTo).get();
        }

        @Override
        public String toString() {
            return "Hand{" +
                    "cards=" + cards +
                    ", best=" + getBestValue() +
                    "}";
        }
    }

    static class Dealer {
        Game game;
        Hand hand;
        int totalBets;

        void joinGame(Game game) {
            this.game = game;
            game.dealer = this;
            hand = new Hand();
        }

        void insertCard(Card card) {
            hand.insertCard(card);
        }

        boolean greaterThan(Player player) {
            return this.hand.getBestValue() >= player.hand.getBestValue();
        }

        void winOver(Player player) {
            this.updateBets(player.bets);
            player.lose();
        }

        void loseTo(Player player) {
            this.updateBets(-player.bets);
            player.win();
        }

        void updateBets(int amount) {
            this.totalBets += amount;
        }

        @Override
        public String toString() {
            return "Dealer{" +
                    "hand=" + hand +
                    ", totalBets=" + totalBets +
                    "}";
        }
    }

    static class Player {
        Game game;
        Hand hand;
        int bets;
        int totalBets;

        void joinGame(Game game) {
            this.game = game;
            game.players.add(this);
            hand = new Hand();
        }

        void placeBets(int amount) {
            this.bets = amount;
        }

        void insertCard(Card card) {
            hand.insertCard(card);
        }

        void win() {
            this.updateBets(this.bets);
        }

        void lose() {
            this.updateBets(-this.bets);
        }

        void updateBets(int amount) {
            this.totalBets += amount;
            this.bets = 0;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "hand=" + hand +
                    ", bets=" + bets +
                    ", totalBets=" + totalBets +
                    "}";
        }
    }

    static class Game {
        Dealer dealer;
        List<Player> players;
        List<Card> cards;

        public Game() {
            dealer = new Dealer();
            dealer.joinGame(this);
            players = new ArrayList<>();
            cards = new ArrayList<>();
        }

        void dealCards() {
            if (cards.size() < 2 * (players.size() + 1)) return;
            for (int i = 0; i < 2; i++) {
                for (Player player : players) {
                    player.insertCard(cards.remove(0));
                }
                dealer.insertCard(cards.remove(0));
            }
        }

        void checkResult() {
            StringBuilder sb = new StringBuilder();
            for (Player player : players) {
                if (dealer.greaterThan(player)) {
                    dealer.winOver(player);
                } else {
                    dealer.loseTo(player);
                }
                sb.append(player);
                sb.append('\n');
            }
            sb.append(dealer);
            sb.append('\n');
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        run();
    }

    static void run() {
        Game game = new Game();
        List<Player> players = new ArrayList<>();
        int[] bets = {10, 100, 500};
        for (int i = 0; i < bets.length; i++) {
            Player player = new Player();
            player.totalBets = 1000;
            player.placeBets(bets[i]);
            player.joinGame(game);
        }
        int[] cards = {1, 4, 2, 3, 1, 4, 2, 3, 9, 10};
        for (int i = 0; i < cards.length; i++) {
            game.cards.add(new Card(cards[i]));
        }
        game.dealer.totalBets = 10000;
        game.dealCards();
        game.checkResult();
    }
}
