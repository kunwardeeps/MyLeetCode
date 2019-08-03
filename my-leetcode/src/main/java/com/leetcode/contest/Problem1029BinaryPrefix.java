package com.leetcode.contest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem1029BinaryPrefix
 */
public class Problem1029BinaryPrefix {

    public static void main(String[] args) {
        System.out.println(prefixesDivBy5(new int[] {1,0,1,1,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,0,1,1,1,0,0,1,0}));
        
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        BigInteger current = new BigInteger("0");
        BigInteger two = new BigInteger("2");
        BigInteger zero = new BigInteger("0");
        BigInteger one = new BigInteger("1");
        BigInteger five = new BigInteger("5");

        for (int n: A) {
            if (n == 0) {
                current = current.multiply(two);
            }
            else {
                current = current.multiply(two).add(one);
            }

            System.out.println(current);

            if (current.mod(five).equals(zero)) {
                result.add(true);
            }
            else {
                result.add(false);
            }
        }

        return result;
    }
}