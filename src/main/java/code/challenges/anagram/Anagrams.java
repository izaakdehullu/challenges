package main.java.code.challenges.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 
 * Two words are anagrams if they contain the same letters but in a different
 * order. Here are a few examples of anagram pairs:
 * 
 * “listen” and “silent”
 * “binary” and “brainy”
 * “Paris” and “pairs”
 * For a given input of two strings, return a Boolean TRUE if the two strings
 * are anagrams.
 * 
 * As an added challenge, for a given array of strings, return separate lists
 * that group anagrams together. For example, the input {“tar,” “rat,” “art,”
 * “meats,” “steam”}, the output should look something like {[“tar,” “rat,”
 * “art”], [“meats,” “steam”]}.
 */
public class Anagrams {

    private static final List<String> WORDS = Arrays.asList(new String[] { "tar", "rat", "art", "meats", "steam" });

    public static void main(String[] args) {

        List<List<String>> results = new ArrayList<>();
        for (int i = 0; i < WORDS.size(); i++) {
            String sortedWord = sortLettersWord(WORDS.get(i));
            for (int j = 0; j < WORDS.size(); j++) {
                String sortedInnerWord = sortLettersWord(WORDS.get(j));
                if (i != j && sortedWord.equals(sortedInnerWord)) {
                    boolean found = false;
                    for (List<String> result : results) {
                        if (!result.isEmpty() && (sortLettersWord(result.get(0)).equals(sortedInnerWord))) {
                            if (!result.contains(WORDS.get(j))) {
                                result.add(WORDS.get(j));
                            }
                            found = true;
                        }
                    }
                    if (!found) {
                        List<String> result = new ArrayList<>();
                        result.add(WORDS.get(i));
                        result.add(WORDS.get(j));
                        results.add(result);
                    }
                }
            }
        }
        System.out.println(results); // [[tar, rat, art], [meats, steam]]
    }

    private static String sortLettersWord(String word) {
        char tempArray[] = word.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

}
