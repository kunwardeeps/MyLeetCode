package com.twitter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ProblemBuyTickets
 * Better solution at https://stackoverflow.com/questions/43950000/hackerrank-buying-show-tickets-optimization
 */
public class ProblemBuyTickets {

    public static void main(String[] args) {
        System.out.println(waitingTime(Arrays.asList(2,6,3,4,5), 2));
    }

    public static long waitingTime(List<Integer> tickets, int p) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addAll(tickets);

        long time = 0;
        int count = tickets.get(p);
        int head = 0;

        while (count != 0) {
            while (p >= 0) {
                head = list.remove(0);
                head--;
                if (head != 0) {
                    list.add(head);
                }
                p--;
                time++;
            }
            count--;
            p = list.size() - 1;
        }
        return time;
    }
}