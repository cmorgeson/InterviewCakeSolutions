/*
    Problem #30
    Permutation Palindrome
    https://www.interviewcake.com/question/java/permutation-palindrome

    Expected Output:
    true
*/

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class PermutationPalindrome {
    public static boolean alternateSolution(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Bad input");
        }

        Set<Character> unmatchedLetters = new HashSet<>();

        char current;
        for (int i = 0; i<input.length(); i++) {
            current = input.charAt(i);
            if (unmatchedLetters.contains(current)) {
                unmatchedLetters.remove(current);
            }
            else {
                unmatchedLetters.add(current);
            }
        }

        return unmatchedLetters.size() <= 1;
    }

    public static boolean couldBePalindrome(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Bad input");
        }

        Map<Character, Integer> counts = new HashMap<>();

        char current;
        for (int i = 0; i<input.length(); i++) {
            current = input.charAt(i);
            if (counts.containsKey(current)) {
                counts.put(current, counts.get(current) + 1);
            }
            else {
                counts.put(current, 1);
            }
        }

        // If string has even number of characters, all characters should have a pair
        boolean shouldHaveLoneChar = (input.length()%2) == 1;
        boolean hasLoneChar = false;

        for (Character c : counts.keySet()) {
            if (counts.get(c)%2 == 1) {
                if (!shouldHaveLoneChar || hasLoneChar) {
                    // Palindrome will never have more than one lone character
                    return false;
                }
                hasLoneChar = true;
            }
        }

        return hasLoneChar == shouldHaveLoneChar;
    }

    public static void main(String[] args) {
        String testInput = "ivicc";
        System.out.println(String.valueOf(alternateSolution(testInput)));
    }
}