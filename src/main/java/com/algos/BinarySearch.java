package com.algos;

import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int arr[], int x) { 
        return -1; 
    } 

    public static int binarySearchCeil(int arr[], int x) { 
        return -1;
    } 

    public static int binarySearchFloor(int arr[], int x) { 
        return -1;
    } 

    /**
     * Recursive
     */
    public int binarySearchRecursive(int arr[], int l, int r, int x) { 
        return -1; 
    } 

    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 5, 7};
        System.out.println(Arrays.toString(arr));
        System.out.println("floor 6:" + (binarySearchFloor(arr, 6) == 2));
        System.out.println("floor 0:" + (binarySearchFloor(arr, 0) == -1));
        System.out.println("floor 4:" + (binarySearchFloor(arr, 4) == 1));
        System.out.println("floor 2:" + (binarySearchFloor(arr, 2) == 0));

        System.out.println("ceil 0:" + (binarySearchCeil(arr, 0) == 0));
        System.out.println("ceil 6:" + (binarySearchCeil(arr, 6) == 3));
        System.out.println("ceil 2:" + (binarySearchCeil(arr, 2) == 1));
        System.out.println("ceil 8:" + (binarySearchCeil(arr, 8) == -1));

        System.out.println("Binary 1:" + (binarySearch(arr, 1) == 0));
        System.out.println("Binary 3:" + (binarySearch(arr, 3) == 1));
        System.out.println("Binary 5:" + (binarySearch(arr, 5) == 2));
        System.out.println("Binary 7:" + (binarySearch(arr, 7) == 3));
        System.out.println("Binary 2:" + (binarySearch(arr, 2) == -1));
    }
}