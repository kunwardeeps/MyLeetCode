package com.leetcode.greedy;

/**
 * Problem860LemonadeChange
 */
public class Problem860LemonadeChange {

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[] {5,5,5,10,20}) == true);
        System.out.println(lemonadeChange(new int[] {10}) == false);
        System.out.println(lemonadeChange(new int[] {5,10}) == true);
        System.out.println(lemonadeChange(new int[] {5,20}) == false);
        System.out.println(lemonadeChange(new int[] {5,10,20}) == false);
    }

    public static boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        for (int bill: bills) {
            switch (bill) {
                case 5:
                    fives++;
                    break;
                
                case 10:
                    if (fives < 1) {
                        return false;
                    }
                    else {
                        fives--;
                        tens++;
                    }
                    break;

                case 20:
                    if (tens >= 1 && fives >= 1) {
                        tens--;
                        fives--;
                    }
                    else if (fives >= 3) {
                        fives -= 3;
                    }
                    else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}