package com.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem929UniqueEmail
 */
public class Problem929UniqueEmail {

    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
        System.out.println(numUniqueEmails(new String[] {""}));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        String localPart = null;
        String domain = null;
        String[] split = null;
        int plusIndex = 0;
        for (String email: emails) {
            if ("".equals(email)) {
                continue;
            }
            split = email.split("@");
            localPart = split[0];
            domain = split[1];
            plusIndex = email.indexOf('+');
            if (plusIndex != -1) {
                localPart = localPart.substring(0, plusIndex);
            }
            localPart = localPart.replaceAll(".", "");
            set.add(localPart + "@" + domain);
        }
        return set.size();
    }
}