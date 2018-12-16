package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScalyrTest2 {
    public static void main(String[] args) {
        System.out.println(photoAlbum(Arrays.asList(0,1,0), Arrays.asList(0,1,2)));
    }

    public static List<Integer> photoAlbum(List<Integer> index, List<Integer> identity) {
        // Write your code here
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i<index.size(); i++){
            if (index.get(i) == identity.get(i)){
                result.add(identity.get(i));
            }
            else {
                result.add(identity.get(i));
                //Shift elements
                for (int j=result.size()-1; j>index.get(i); j--){
                    result.set(j, result.get(j-1));
                }
                //Move required element to index(i)
                result.set(index.get(i), identity.get(i));
            }
        }
        return result;
    }

	
}