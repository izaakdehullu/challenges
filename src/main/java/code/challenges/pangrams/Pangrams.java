package main.java.code.challenges.pangrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * A pangram is a sentence that contains all 26 letters of the English alphabet.
 * One of the most well-known examples of a pangram is, “The quick brown fox
 * jumps over the lazy dog.” Create a pangram checker that returns a Boolean
 * TRUE if an input string is a pangram and FALSE if it isn’t.
 * 
 * For an added pangram challenge, create a perfect pangram checker. A perfect
 * pangram is a sentence that uses each letter of the alphabet only once, such
 * as, “Mr. Jock, TV quiz Ph.D., bags few lynx.”
 * 
 * https://www.codecademy.com/resources/blog/java-code-challenges-for-beginners/
 * 
 */
public class Pangrams {

    private final static String SENTENCE = "The quick brown fox jumps over the lazy dog";
    private final static String ALPHABETE = "abcdefghijklmnopqrstuvwxyz";
    private final static String SENTENCE2 = "Mr. Jock, TV quiz Ph.D., bags few lynx.z";
    private final static String SENTENCE3 = "Mr. Jock, TV quiz Ph.D., bags few lynx.";

    public static void main(String[] args) {

        validate(false, SENTENCE);
        validate(true, SENTENCE2);
        validate(true, SENTENCE3);

    }

    private static void validate(boolean unique, String sentence) {

        System.out.print("ZIN: "+ sentence + ", ");
        System.out.println("UNIEK: " + unique);

        sentence = replace(sentence);

        if (unique && !allCharactersUnique(sentence)) {
            System.out.println("all characters unique: FALSE");
            return;
        }

        String result = sortSingleLettersWord(sentence);


        if (result.equals(ALPHABETE)) {
            System.out.println("contains whole alphabate: TRUE");
        } else {
            System.out.println("contains whole alphabate: FALSE");
        }
    }

    private static String replace(String sentence) {
        return sentence.toLowerCase()
                .replaceAll("\\s", "")
                .replaceAll("\\.", "")
                .replaceAll("\\,", "");
    }

    private static boolean allCharactersUnique(String sentence) {

        char[] tempArray = sentence.toCharArray();
        Arrays.sort(tempArray);
        String str = String.valueOf(tempArray);

        int idx = 0;
        while (idx < str.length()-1) {
        if (str.charAt(idx) == str.charAt(idx + 1)) {
                return false;
        }
        idx++;
        }
        return true;
    }

    private static String sortSingleLettersWord(String word) {
        char[] tempArray = word.toCharArray();
        Arrays.sort(tempArray);
        int i = 0;
        char[] result = new char[26];
        int idx = 0;
        while (i < tempArray.length - 1) {
            if (tempArray[i] != tempArray[i + 1]) {
                result[idx++] = tempArray[i];
            }
            i++;
        }
        // last character
        result[25] = tempArray[tempArray.length - 1];

        // if (tempArray[tempArray.length - 2] != tempArray[tempArray.length - 1]) {
        //     result[25] = tempArray[tempArray.length - 1];
        // } 
        return new String(result);
    }

}
