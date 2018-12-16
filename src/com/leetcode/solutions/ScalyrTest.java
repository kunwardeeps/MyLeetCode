package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScalyrTest {
    public static void main(String[] args) {
        System.out.println(formatDate("1st Mar 1984"));
        System.out.println(formatDate("2nd Feb 2013"));
        System.out.println(formatDate("4th Apr 1900"));
        
    }

    public List<String> reformatDate(List<String> dates) {
        // Write your code here
        List<String> result = new ArrayList<>();
        for (String date: dates){
            result.add(formatDate(date));
        }
        return result;
    }

    public static String formatDate(String date){
        //1st Mar 1984 - 1984-03-01
        String[] arr = date.split(" ");
        Map<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");
        int dayLength = arr[0].length();
        String day = "";
        if (dayLength == 3){
            day = "0";
        }
        day = day + arr[0].substring(0, dayLength-2);

        return arr[2] +"-"+ monthMap.get(arr[1]) +"-"+ day;
        
    }

	
}