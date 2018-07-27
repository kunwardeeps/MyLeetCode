package com.leetcode.solutions;

/**https://leetcode.com/problems/container-with-most-water/description/ */
class Problem11{

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}) == 49);
        System.out.println(maxArea(new int[]{8,8,0,0,0}) == 8);
        System.out.println(maxArea(new int[]{0,0,0,0}) == 0);
        System.out.println(maxArea(new int[]{1,1,1,1,1}) == 4);
        System.out.println(maxArea(new int[]{1,1,8,1,1,1,8}) == 32);
    }

    /**
     * Optimized
     */
    public static int maxArea(int[] height) {
        int area=0, n=height.length;
        int l=0, r=n-1;

        while(l<r){
            area = Integer.max(area, (r-l)*Integer.min(height[l], height[r]));
            if (height[l] < height[r]){
                l++;
            }
            else {
                r--;
            }
        }

        return area;
    }

    /**
     * Brute Force
     */
    public static int maxArea1(int[] height) {
        int area=0, n=height.length;

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                area = Integer.max(area, (j-i)*Integer.min(height[i], height[j]));
            }
        }

        return area;
    }

}