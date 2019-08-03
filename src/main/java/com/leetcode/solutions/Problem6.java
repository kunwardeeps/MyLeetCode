package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/zigzag-conversion/description/
 */
class Problem6{
    public static void main(String[] args) {
        System.out.println(solution1("PAYPALISHIRING", 2).equals("PYAIHRNAPLSIIG"));
        System.out.println(solution1("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
        System.out.println(solution1("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"));
    }

    private static String solution1(String s, int numRows){
        StringBuilder str = new StringBuilder();
        int x=0;
        if (numRows==1){
            return s;
        }
        if (numRows==2){
            for (int i=0; i<s.length(); i++){
                if (i%2==0){
                    str.append(s.charAt(i));
                }
            }
            for (int i=0; i<s.length(); i++){
                if (i%2!=0){
                    str.append(s.charAt(i));
                }
            }
            return str.toString();
        }
        for (int r=0; r<numRows; r++){
            for (int i=r; i<s.length(); i+=2*numRows-2){
                str.append(s.charAt(i));
                x = i+2*(numRows-r-1);
                if (r!=0 && r!=numRows-1 && x<s.length()){
                    str.append(s.charAt(x));
                }
            }
        }
        return str.toString();
    }
}