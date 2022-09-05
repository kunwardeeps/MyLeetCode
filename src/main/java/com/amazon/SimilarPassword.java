package com.amazon;

/* https://leetcode.com/discuss/interview-question/2439597/Amazon-OA-2023 */
public class SimilarPassword {
    public static void main(String[] args) {
        System.out.println(checkPasswords("baacbab", "abdbc") == true);
        System.out.println(checkPasswords("baacbab", "ach") == false);
        System.out.println(checkPasswords("baacbab", "abb") == true);
        
    }

    public static boolean checkPasswords(String newPassword, String oldPassword) {
        if (newPassword.length() < oldPassword.length()) {
            return false;
        }

        int i = 0, matches = 0;

        for (char c : oldPassword.toCharArray()) {
            boolean matchFound = false;
            for (int k = i; k < newPassword.length(); k++) {
                char cNew = newPassword.charAt(k);
                matchFound = isMatching(cNew, c);
                if (matchFound) {
                    matches++;
                    i = k + 1;
                    break;
                } 
            }
            if (!matchFound) return false;
        }
        if (matches != oldPassword.length()) return false;
        return true;
    }

    private static boolean isMatching(char cNew, char c) {
        if (cNew == c || cNew + 1 == c || (cNew == 'z' && c == 'a')) return true;
        return false;
    }
}
