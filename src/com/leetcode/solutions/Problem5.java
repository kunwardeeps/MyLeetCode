package com.leetcode.solutions;

/**
 * For O(n), refer https://leetcode.com/articles/longest-palindromic-substring/
 */
class Problem5{
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad").equals("bab"));
        System.out.println(longestPalindrome("cbbd").equals("bb"));
        System.out.println(longestPalindrome("abc").equals("a"));
        System.out.println(longestPalindrome("abcbaabcdcba").equals("abcdcba"));
        System.out.println(longestPalindrome("a").equals("a"));
        System.out.println(longestPalindrome("bb").equals("bb"));
        System.out.println(longestPalindrome("ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy"));
    }

    public static String longestPalindrome(String s) {
        return dynamic(s);
    }

    /** 
     * O(n^2) solution
     * dp[i][j] = Substring from index i to j (inclusive)
     * dp[i][j] = true if dp[i+1][j-1] == true and s[i] == s[j]
     */
    private static String dynamic(String s){
        int l = s.length();
        boolean[][] dp = new boolean[l][l];
        int longest=0;
        String longestPalindrome = "";

        //Unit length strings are palindrome
        for (int i=0; i<l; i++){
            dp[i][i] = true;
            if (longest < 1){
                longest = 1;
                longestPalindrome = s.substring(0,1);
            }
        }

        //For strings of length=2
        for (int i=0; i<l-1; i++){
            if (s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                if (longest < 2){
                    longest = 2;
                    longestPalindrome = s.substring(i,i+2);
                }
            }
        }

        int k=0;
        for (int i=3; i<=l; i++){//i = length of palindrome
            for (int j=0; j+i<=l; j++){//js Start Index
                k=j+i-1;//k=End Index
                if (s.charAt(j) == s.charAt(k) && dp[j+1][k-1] == true){
                    dp[j][k] = true;
                    if (longest<i){
                        longest = i;
                        longestPalindrome = s.substring(j,k+1);
                    }
                }
            }
        }

        return longestPalindrome;
    }

    /** 
     * O(n^2) time and O(n) space
     * We observe that a palindrome mirrors around its center. Therefore, a palindrome 
     * can be expanded from its center, and there are only 2n - 12n−1 such centers.

        You might be asking why there are 2n -1 but not n centers? 
        The reason is the center of a palindrome can be in between two letters. 
        Such palindromes have even number of letters (such as "abba") and its center 
        are between the two 'b's.

     */
    public String longestPalindrome1(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    private static String bruteForce(String s){
        String longestPalindrome = "";
        int longest = 0;
        int l = s.length();
        for (int i=1; i<=l; i++){
            for (int j=0; j+i<=l; j++){
                String subst = s.substring(j, i+j);
                if (isPalindrome(subst) && i+1>longest){
                    longestPalindrome = subst;
                    longest = i+1;
                    break;
                }
            }
        }
        return longestPalindrome; 
    }

    private static boolean isPalindrome(String s){
        return s.equals(reverse(s));
    }

	private static String reverse(String s) {
        StringBuilder rev = new StringBuilder();
        for (int i = s.length()-1; i>=0; i--){
            rev.append(s.charAt(i));
        }
		return rev.toString();
	}
}