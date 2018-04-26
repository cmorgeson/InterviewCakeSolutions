import java.util.Set;
import java.util.HashSet;

public class RecursivePermutations {
    public static Set<String> countPerms(String input) {
        Set<String> permutations = new HashSet<>();

        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException("Bad input");
        }

        if (input.length() == 1) {
            permutations.add(input);
            return permutations;
        }

        char first = input.charAt(0);
        Set<String> substrPerms = countPerms(input.substring(1));

        for (String s : substrPerms) {
            for (int i=0; i<=s.length(); i++) {
                permutations.add(s.substring(0, i) + first + s.substring(i));
            }
        }

        return permutations;
    }

    public static void main(String[] args) {
        String testInput = "cats";
        Set<String> result = countPerms(testInput);
        for (String s : result) {
            System.out.println(s);
        }
    }
}