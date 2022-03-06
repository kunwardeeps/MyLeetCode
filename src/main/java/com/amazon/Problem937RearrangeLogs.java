package com.amazon;

import java.util.Arrays;

/**
 * Problem937RearrangeLogs
 */
public class Problem937RearrangeLogs {

    public static void main(String[] args) {
        
    }

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            // split each log into two parts: <identifier, content>
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            // case 1). both logs are letter-logs
            if (!isDigit1 && !isDigit2) {
                // first compare the content
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0)
                    return cmp;
                // logs of same content, compare the identifiers
                return split1[0].compareTo(split2[0]);
            }

            // case 2). one of logs is digit-log
            if (!isDigit1 && isDigit2)
                // the letter-log comes before digit-logs
                return -1;
            else if (isDigit1 && !isDigit2)
                return 1;
            else
                // case 3). both logs are digit-log
                return 0;
        });
        return logs;
    }
}