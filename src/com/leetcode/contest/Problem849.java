package com.leetcode.contest;

class Problem849{
    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{1,0,1})==1);
        System.out.println(maxDistToClosest(new int[]{1,0,0,0,1,0,1})==2);
        System.out.println(maxDistToClosest(new int[]{0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,1})==3);
        System.out.println(maxDistToClosest(new int[]{0,1,1,1,0,0,1,0,0})==2);
        System.out.println(maxDistToClosest(new int[]{0,0,0,1})==3);
        System.out.println(maxDistToClosest(new int[]{1,0,0,0})==3);
    }

    public static int maxDistToClosest(int[] seats) {
        int length=0, maxLength=0, i=0, l=seats.length;
        for (i=0; i<l; i++){
            if (seats[i] == 0){
                length++;
            }
            else {
                if (i-length==0){
                    maxLength = length;
                }
                else if (length>2*maxLength){
                    maxLength = length/2;
                    if (length%2!=0){
                        maxLength++;
                    }
                }
                length = 0;
            }
            if (i==l-1 && length>=maxLength){
                maxLength = length;
            }
        }
        return maxLength;
    }
}