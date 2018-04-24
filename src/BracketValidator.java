/*
    Problem #29
    Bracket Validator
    https://www.interviewcake.com/question/java/bracket-validator

    Expected Output:
    true
*/

import java.util.Stack;

public class BracketValidator {
    public static boolean validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Bad input");
        }

        Stack<Character> openers = new Stack<>();

        for (int i=0; i<input.length(); i++) {
            char curr = input.charAt(i);
            if (curr == '(' || curr == '{' || curr == '[') {
                openers.push(curr);
            }
            else if (curr == ')') {
                if (openers.peek() != '(') {
                    return false;
                }
                else {
                    openers.pop();
                }
            }
            else if (curr == '}') {
                if (openers.peek() != '{') {
                    return false;
                }
                else {
                    openers.pop();
                }
            }
            else if (curr == ']') {
                if (openers.peek() != '[') {
                    return false;
                }
                else {
                    openers.pop();
                }
            }
        }

        return openers.size() == 0;
    }
    
    public static void main(String[] args) {
        String testInput = "{ [ ]}";
        System.out.println(String.valueOf(validate(testInput)));
    }
}