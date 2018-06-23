package com.leetcode.contest;

class Problem848{
    public static void main(String[] args) {
        System.out.println(shiftingLetters("abc", new int[]{3,5,9}).equals("rpl"));
        System.out.println(shiftingLetters("z", new int[]{2}).equals("b"));
        System.out.println(shiftingLetters("zz", new int[]{2,1}).equals("ca"));
    }

    public static String shiftingLetters(String S, int[] shifts) {
        StringBuilder sb = new StringBuilder(S);
        for (int i=0; i<shifts.length; i++){
            for (int j=0; j<=i; j++){
                sb.setCharAt(j, shift(sb.charAt(j), shifts[i]));
            }
        }
        return sb.toString();
    }

    public static char shift(char x, int t){
        return (char)(((int) x + t - (int)'a') % 26 + (int)'a');
    }
}