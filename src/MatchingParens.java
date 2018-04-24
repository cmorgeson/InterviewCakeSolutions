/*
    Problem #28
    Parenthesis Matching
    https://www.interviewcake.com/question/java/matching-parens?

    Expected Output:
    79
*/
public class MatchingParens {
    public static int findClose(String input, int openIndex) {
        if (input == null || openIndex < 0 ||
                openIndex >= input.length() || input.charAt(openIndex) != '(') {
            throw new IllegalArgumentException("Bad input");
        }

        int openParentheses = 0;

        for (int i = openIndex+1; i < input.length(); i++) {
            if (input.charAt(i) =='(') {
                openParentheses++;
            }
            else if (input.charAt(i) == ')') {
                if (openParentheses == 0) {
                    return i;
                }
                else {
                    openParentheses--;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String testInput = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
        System.out.println(String.valueOf(findClose(testInput, 10)));
    }
}