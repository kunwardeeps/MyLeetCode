package com.galatea;

/**
 * Problem1die
 */
public class Problem1die {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {}));
        System.out.println(solution(new int[] {1,2,3}));
    }

    public static int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int minCount = Integer.MAX_VALUE;
        for (int fixedDie: A) {
            minCount = Math.min(minCount, getTotalRotations(A, fixedDie));    
        }
        return minCount;
    }

    private static int getTotalRotations(int[] A, int fixedDie) {
        int rotations = 0;
        for (int die: A) {
            if (die == 7 - fixedDie) {
                rotations += 2;
            } else if (die != fixedDie) {
                rotations += 1;
            }
        }
        return rotations;
    }
}