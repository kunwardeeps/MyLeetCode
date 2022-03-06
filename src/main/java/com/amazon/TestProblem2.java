package com.amazon;

import java.util.List;
import java.util.Stack;

/**
 * SubstringProblem
 */
public class TestProblem2 {

    public static void main(String[] args) {

    }
    

    public int sumSubarrayMins(List<Integer> weight) {

        Stack<int[]> ple = new Stack<>();
        Stack<int[]> nle = new Stack<>();

        int[] left = new int[weight.size()];
        int[] right = new int[weight.size()];

        for (int i = 0; i < weight.size(); i++) {
            while (!ple.isEmpty() && ple.peek()[0] >= weight.get(i)) {
                ple.pop();
            }
            if (ple.isEmpty()) {
                left[i] = i + 1;
            } else {
                left[i] = i - ple.peek()[1];
            }
            int[] temp = new int[] {weight.get(i), i};
            ple.push(temp);
        }

        for (int i = weight.size() - 1; i >= 0; i--) {
            while (!nle.isEmpty() && nle.peek()[0] > weight.get(i)) {
                nle.pop();
            }
            if (nle.isEmpty()) {
                right[i] = weight.size() - i;
            } else {
                right[i] = nle.peek()[1] - i;
            }
            int[] temp = new int[] {weight.get(i), i};
            nle.push(temp);
        }

        int ans = 0;
        int mod = 1000000007;
        for (int i = 0; i < weight.size(); i++) {
            ans = (ans + weight.get(i) * left[i] * right[i]) % mod;
        }
        return ans;
    }
}