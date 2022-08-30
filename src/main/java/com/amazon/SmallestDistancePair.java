package com.amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SmallestDistancePair {
    public int smallestDistancePair(int[] nums, int k) {
        // nlog(n)
        Arrays.sort(nums);
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        // nlog(n)
        for(int i = 0; i < nums.length - 1; i++) {
            heap.offer(new Pair(i, i+1, nums[i+1] - nums[i]));
        }
        int cnt = 0;
        Pair pair = null;
        // klog(n)
        while(cnt < k && !heap.isEmpty()) {
            pair = heap.poll();
            if (pair.end < nums.length - 1) {
                heap.offer(new Pair(pair.start, pair.end + 1, nums[pair.end + 1] - nums[pair.start]));
            }
            cnt++;
        }
        if (pair != null) {
            return pair.dist;
        }
        return -1;
    }
    
    private static class Pair implements Comparable<Pair> {
        int start;
        int end;
        int dist;
        public Pair(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
        public int compareTo(Pair that) {
            return this.dist - that.dist;
        }
    }
}
