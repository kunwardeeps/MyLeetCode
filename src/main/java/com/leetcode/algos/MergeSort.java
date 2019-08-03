package com.leetcode.algos;

/*
Pseudo code:

mergesort(a,l,r):
    if (l<r):
        m = (l+r)/2
        mergesort(a,l,m)
        mergesort(a,m+1,r)
        merge(a,l,m,r)

merge(a,l,m,r):
    Init arr1[l,m], arr2[m+1,r], res[l,r]
    k = 0
    for i (0 to m-l), j (0 to r-m-1)
        if (arr1[i] > arr2[j]):
            res[k] = arr2[j]
            k++
            j++
        else
            res[k] = arr1[i]
            k++
            i++
    // copy remaining if any
    while (i<m-l)
        res[k] = arr1[i]
        k++
        i++
        
    while (j<r-m-1)
        res[k] = arr2[j]
        k++
        j++   
*/
public class MergeSort{

    /* 
     * a = input array
     * l = left index
     * r = right index
     */
    public static void sort(int[] a, int l, int r) {
        if (l<r){
            int pvtIdx = (l+r)/2;
            sort(a, l, pvtIdx);
            sort(a, pvtIdx+1, r);
            merge(a,l,pvtIdx,r);
        }
    }

    private static int[] merge(int[] a, int l, int m, int r) {
        //TODO
        return null;
    }

	private static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
	}

	public static void main(String[] args) {
        int[] a = new int[] {2,7,1,6};
        QuickSort.sort(a, 0, 3);
        for (int i: a){
            System.out.print(i+" ");
        }
    }

}