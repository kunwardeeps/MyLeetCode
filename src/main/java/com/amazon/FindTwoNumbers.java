package com.amazon;

/**
 * Determine the minimum value of the expression ∑i=1nmin(abs(a[i]−x),abs(a[i]−y)) if the chosen numbers are x and y.
Example1:
N = 4
A = [2, 3, 6, 7]

Sort the array
find the index i where (num[i + 1] - num[i]) is largest
Divide the array into 2 parts: [0, i] and [i + 1, array.length - 1]
Return the median of both parts
https://leetcode.com/discuss/interview-question/2399532/Amazon-OA 
 * 
 */
public class FindTwoNumbers {
    
}
