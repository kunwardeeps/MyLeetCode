package com.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * SubstringProblem
 */
public class TestProblem3 {

    public static void main(String[] args) {
        List<Integer> packets = new ArrayList<>();
        packets.add(1); packets.add(2); packets.add(3); packets.add(4); packets.add(5);
        // I/P - 1,2,3,4,5, channels - 2 ---> O/P - 7
        // I/P - 2,2,1,5,3, channels - 2 ---> O/P - 7
        int channels = 3;
        
        long result = maximumQuality(packets, channels);
        System.out.println(result);
    }
    
    // TC - O(nlogn) as we are sorting
    // SC - O(1) - no data structure needed
    
    private static long maximumQuality(List<Integer> packets, int channels) {
        if (packets == null || packets.size() == 0) return 0L;
        if (packets.size() == 1) return (long) packets.get(0);
        
        Collections.sort(packets);
        int n = channels - 1;
        int median = 0;
        while (n > 0) {
            n--;
            int val = packets.get(packets.size()-1);
            median += val;
            packets.remove(packets.size()-1);
        }
        Long result = getMed(packets, median);
        return result;
    }
    
    private static long getMed(List<Integer> list, long median) {
        long val = 0;
        if (list.size() % 2 == 0) {
            val = (long) (list.get(list.size()/2) + list.get(list.size()/2 - 1))/2;
        } else {
            val = (long) list.get(list.size()/2);
        }
        return (long) (val + median);
    }
    
}