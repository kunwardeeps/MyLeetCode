package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem23{
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode[] generateList(int[][] arr){
        int i=0,j=0;
        ListNode node = null;
        ListNode[] lists = new ListNode[arr.length];
        for (i=0; i<arr.length; i++){
            for (j=0; j<arr[i].length; j++){
                if (lists[i] == null){
                    lists[i] = new ListNode(arr[i][j]);
                    node = lists[i];
                }
                else {
                    node.next = new ListNode(arr[i][j]);
                    node = node.next;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Problem23 p = new Problem23();
        printList(p.mergeKLists(p.generateList(new int[][]{{}})));
        printList(p.mergeKLists(p.generateList(new int[][]{{-2,-1,-1,-1},{}})));
        printList(p.mergeKLists(p.generateList(new int[][]{{1,4,5},{1,3,4},{2,6}})));
        
        
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<>((i,j) -> i.val - j.val);

        for (ListNode node: lists) {
            if (node!=null) {
                heap.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while (!heap.isEmpty()){
            node.next = heap.poll();
            node = node.next;
            
            if (node.next != null) {
                heap.add(node.next);
            }
        }
        return dummy.next;

    }

    public ListNode mergeKListsBruteForce(ListNode[] lists) {
        List<ListNode> listArr = new LinkedList<ListNode>(Arrays.asList(lists));
        ListNode min = null;
        boolean isHeadSet = false;
        ListNode result = null, head = null;
        while (!listArr.isEmpty()){
            min = getMinimum(listArr);
            if (min.val == Integer.MAX_VALUE){
                return head;
            }
            if (!isHeadSet){
                head = min;
                result = head;
                isHeadSet = true;
            }
            else {
                result.next = min;
                result = result.next;
            }
        }

        return head;
    }

    private ListNode getMinimum(List<ListNode> listArr) {
        ListNode min = new ListNode(Integer.MAX_VALUE);
        ListNode node = null;
        int minIdx = 0;
        for (int i=0; i<listArr.size(); i++){
            node = listArr.get(i);
            if (node != null && node.val < min.val){
                min = node;
                minIdx = i;
            }
        }

        if (min.next == null){
            listArr.remove(minIdx);
        }
        else {
            listArr.set(minIdx, min.next);
        }
		return min;
	}

	private static void printList(ListNode node) {
        List<Integer> result = new ArrayList<>();
        while(node!=null){
            result.add(node.val);
            node = node.next;
        }
        System.out.println(result);
    }
    
    public ListNode mergeKListsRecursive(ListNode[] lists) {
        return partion(lists, 0, lists.length-1);
    }
    public static ListNode partion(ListNode[] lists, int start, int end) {
        if (start == end)
            return lists[start];
        if (start < end) {
            int mid = (start + end)/2;
            ListNode l1 = partion(lists, start, mid);
            ListNode l2 = partion(lists, mid+1, end);
            return merge(l1,l2);
        }
        else 
            return null;
    }
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if(l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}