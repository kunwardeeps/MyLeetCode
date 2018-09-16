package com.leetcode.solutions;

import java.util.Arrays;

public class Google2{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {3,5}, new int[] {2,4,7})));
    }

	public static int[] solution(int[] stores, int[] houses) {
        Arrays.sort(stores);
        int[] result = new int[houses.length];

        for (int i=0; i<houses.length; i++) {
            result[i] = binarySearch(stores, houses[i]);
        }
        return result;
    }

    public static int binarySearch(int stores[], int loc) { 
        int n = stores.length; 
  
        if (loc <= stores[0]) {
            return stores[0]; 
        }
        if (loc >= stores[n-1]) {
            return stores[n-1]; 
        }
  
        int x=0, y=n, m=0; 
        while (x<y) { 
            m = (x+y)/2; 
  
            if (stores[m] == loc) {
                return stores[m]; 
            }
  
            if (loc < stores[m]) {
                if (m > 0 && loc > stores[m-1]) {
                    return findNearestNum(stores[m-1], stores[m], loc); 
                }
                y = m;               
            } 
  
            else { 
                if (m < n-1 && loc < stores[m+1]) {
                    return findNearestNum(stores[m], stores[m+1], loc);
                }              
                x = m+1;
            } 
        } 
        return stores[m]; 
    } 

    public static int findNearestNum(int x, int y, int num) { 
        if (num - x > y - num) {
            return y;  
        }       
        else {
            return x;
        }
    } 
}