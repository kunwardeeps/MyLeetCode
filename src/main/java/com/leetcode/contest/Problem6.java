package com.leetcode.contest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

public class Problem6 {

    public static void main(String[] args) {
        System.out.println();
    }

    public static List<String> computeParameterValue(List<List<String>> sources) {
        // Write your code here
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        for (List<String> list: sources) {
            for (String str: list) {
                String[] arr = str.split(":");
                map.put(arr[0], arr[1]);
            }
        }
        return new ArrayList(map.values());
        
    }

    


}