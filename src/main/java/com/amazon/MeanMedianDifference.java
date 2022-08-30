package com.amazon;

import java.util.Arrays;

public class MeanMedianDifference {
    public int getMin(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int median = arr[i];
            int l = 0, r = n - 1, minDiff = Integer.MAX_VALUE;
            while (l < r && l < i && r > i) {
                int mean = (arr[l] + arr[i] + arr[r]);
                int diff = Math.abs(mean - 3 * median);
                if (diff < minDiff)
                    minDiff = diff;
                else
                    break;
                if (minDiff == 0)
                    break;
                if (mean > median)
                    r--;
                else
                    l++;
            }
            ans = Math.min(ans, minDiff);
        }
        return ans;
    }
}
