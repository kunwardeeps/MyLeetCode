package com.leetcode.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Probability of maximum sum in array in all two int combinations
 */
public class GoldmanHackerRank {
    public static void main(String[] args) {
        List<Integer> teamGoals = Arrays.asList(new Integer[] {});
        System.out.println(findMaxGoalsProbability(teamGoals));
    }

    static int getSumCountForAllPairs(List<Integer> teamGoals, int sum){
        int n = teamGoals.size();
        HashMap<Integer, Integer> map = new HashMap<>();
  
        for (int i=0; i<n; i++){
            if(!map.containsKey(teamGoals.get(i))){
                map.put(teamGoals.get(i),0);
            }
            map.put(teamGoals.get(i), map.get(teamGoals.get(i))+1);
        } 
        int subseqCount = 0;
        for (int i=0; i<n; i++){
            if (map.get(sum-teamGoals.get(i)) != null){
                subseqCount += map.get(sum-teamGoals.get(i));
            }
            if (sum-teamGoals.get(i) == teamGoals.get(i)){
                subseqCount--;
            }
        }
        return subseqCount/2; 
    }

    static long getSum(long n){
        return n * (n+1)/2;
    }

	static String findMaxGoalsProbability(List<Integer> teamGoals) {
        if (teamGoals.isEmpty()){
            return "0.00";
        }
        int max1 = 0;
        int max2 = 0;
        for(int n:teamGoals){
            if(max1 <= n){
                max2 = max1;
                max1 = n;
            } else if(max2 < n){
                max2 = n;
            }
        }
        int n = teamGoals.size();
        int maxSum = max1 + max2;
        int maxPairs = getSumCountForAllPairs(teamGoals, maxSum);
        double result = (double) maxPairs/getSum(n-1);
        return String.format("%.2f", result);
    }

    static String findMaxGoalsProbabilityOpt(List<Integer> teamGoals) {
        int maxCount[][] = {{0, 0}, {0, 0}};

        for (Integer teamGoal : teamGoals) {
            if (teamGoal == maxCount[0][0] || teamGoal == maxCount[1][0]) {
                incrementMaxCount(maxCount, teamGoal);
            } else if (teamGoal > maxCount[0][0] || teamGoal > maxCount[1][0]) {
                updateMaxCount(maxCount, teamGoal);
            }
        }

        if (maxCount[0][1] > 1) {
            return getResult(getSum(maxCount[0][1] - 1), teamGoals.size());
        } else {
            return getResult(maxCount[1][1], teamGoals.size());
        }

    }

    private static String getResult(long sum, int size) {
        //TODO
        return null;
    }

    private static void updateMaxCount(int[][] maxCount, Integer teamGoal) {
        //TODO
    }

    private static void incrementMaxCount(int[][] maxCount, Integer teamGoal) {
        //TODO
    }

}