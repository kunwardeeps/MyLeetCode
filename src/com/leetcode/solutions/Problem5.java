package com.leetcode.solutions;

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
        return bruteForce(s);
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