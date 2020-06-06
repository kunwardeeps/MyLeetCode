package com.leetcode.binarysearch;

/**
 * BinarySearch
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 5, 7};
        System.out.println(binarySearchFloor(arr, 6) == 2);
        System.out.println(binarySearchFloor(arr, 0) == 0);
        System.out.println(binarySearchFloor(arr, 4) == 1);
        System.out.println(binarySearchFloor(arr, 2) == 0);

        System.out.println(binarySearchCeil(arr, 0) == 0);
        System.out.println(binarySearchCeil(arr, 6) == 3);
        System.out.println(binarySearchCeil(arr, 2) == 1);
    }

    // When l == r, arr[m] < target, so we need to return m + 1
    // l = m + 1 will execute, so we return l;
    public static int binarySearchCeil(int arr[], int x) { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
            if (arr[m] == x) {
                return m; 
            }
            if (arr[m] < x) {
                l = m + 1; 
            } else {
                r = m - 1; 
            }
        } 
        return l; 
    } 

    // When l == r, arr[m] > target, so we need to return m - 1
    // r = m - 1 will execute, so we return r;
    // To avoid negative index when target < arr[0], we use Math.max(0, r)
    public static int binarySearchFloor(int arr[], int x) { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
            if (arr[m] == x) {
                return m; 
            }
            if (arr[m] < x) {
                l = m + 1; 
            } else {
                r = m - 1; 
            }
        } 
        return Math.max(0, r); 
    } 

    public static int binarySearchIterative(int arr[], int x) { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 

            if (arr[m] == x) {
                return m; 
            }
            if (arr[m] < x) {
                l = m + 1; 
            } else {
                r = m - 1; 
            }
        } 
        return -1; 
    } 

    /**
     * Recursive
     */
    public int binarySearch(int arr[], int l, int r, int x) { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 

            if (arr[mid] == x) {
                return mid; 
            }
            if (arr[mid] > x) {
                return binarySearch(arr, l, mid - 1, x); 
            }
            return binarySearch(arr, mid + 1, r, x); 
        } 
        return -1; 
    } 
}