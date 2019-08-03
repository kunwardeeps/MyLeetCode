package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 */
class Problem14{

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"flow", "flo"}).equals("flo"));
        System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}).equals("fl"));
        System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}).equals(""));
        System.out.println(longestCommonPrefix(new String[] {"aaaa"}).equals("aaaa"));
        System.out.println(longestCommonPrefix(new String[] {"ab","abab","abab"}).equals("ab"));
        System.out.println(longestCommonPrefix(new String[] {"dac","bac","gac"}).equals(""));
        System.out.println(longestCommonPrefix(new String[] {}).equals(""));
    }

    public static String longestCommonPrefix(String[] strs) {
        boolean stop = false;
        int i=0, j=0;
        if (strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        int l = getMinLengthString(strs);
        for (i=0; i<l; i++){
            for (j=0; j<strs.length-1; j++){
                if (strs[j].charAt(i) == strs[j+1].charAt(i)){
                    continue;
                }
                else {
                    stop = true;
                    break;
                }
            }
            if (stop) break;
        }
        return strs[0].substring(0,i);
    }

	private static int getMinLengthString(String[] strs) {
        int min = Integer.MAX_VALUE;
        for (String s: strs){
            min = Integer.min(s.length(), min);
        }
		return min;
	}

    

}