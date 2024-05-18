package com.algos;

import java.util.Arrays;

/*
Pseudo code:

quicksort(a):
    q = partition(a,p,r) // q is pivot index in correct place
    quicksort(a,p,q-1)
    quicksort(a,q+1,r)

partition(a,l,r):
    pivot = a[r]
    i=l-1
    for (j = l to r-1):
        if (a[j] > pivot):
            i++
            swap(a[i],a[j])
    swap(a[i+1],pivot)
    return i+1        
*/
public class QuickSort {

    /*
     * a = input array
     * l = left index
     * r = right index
     */
    public static void sort(int[] a, int l, int r) {
    }


    public static void main(String[] args) {
        int[] a = new int[] { 2, 7, 1, 6 };
        sort(a, 0, a.length - 1);
        System.out.println("Test case 1: {2,7,1,6} " + Arrays.equals(a, new int[] { 1, 2, 6, 7 }));
        a = new int[] { 4, 3, 2, 1 };
        sort(a, 0, a.length - 1);
        System.out.println("Test case 2: {4,3,2,1} " + Arrays.equals(a, new int[] { 1, 2, 3, 4 }));
        a = new int[] { 1, 2, 3, 4 };
        sort(a, 0, a.length - 1);
        System.out.println("Test case 3: {1,2,3,4} " + Arrays.equals(a, new int[] { 1, 2, 3, 4 }));
    }
}