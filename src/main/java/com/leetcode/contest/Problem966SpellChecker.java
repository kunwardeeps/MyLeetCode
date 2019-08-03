package com.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem966SpellChecker
 */
public class Problem966SpellChecker {

    public static void main(String[] args) {
        
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        List<String> result = new ArrayList<>();
        boolean checkVowel = true;
        boolean checkCase = true;
        for (String query: queries) {
            checkVowel = true;
            checkCase = true;
            for (String word: wordlist) {
                if (word.equals(query)){
                    result.add(word);
                    checkVowel = false;
                    checkCase = false;
                    break;
                }
            }
            //check case
            if (checkCase) {
                for (String word: wordlist) {
                    if (word.toLowerCase().equals(query.toLowerCase())){
                        result.add(word);
                        checkVowel = false;
                        break;
                    }
                }
            }
            if (checkVowel) {
                for (String word: wordlist) {
                    if (word.toLowerCase().replaceAll("[aeiouAEIOU]", "").equals(query.toLowerCase().replaceAll("[aeiouAEIOU]", ""))){
                        result.add(word);
                        break;
                    }
                }
            }
        }
        return result.stream().toArray(String[]::new);
    }
}