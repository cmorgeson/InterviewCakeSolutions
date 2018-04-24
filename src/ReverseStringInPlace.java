/*
    Problem #26
    Reverse a String In Place
    https://www.interviewcake.com/question/java/reverse-string-in-place

    Expected Output:
    tseT
*/

public class ReverseStringInPlace {
    public static void reverse(char[] input) {
        for (int i=0; i<input.length/2; i++) {
            char temp = input[i];
            input [i] = input[input.length-1-i];
            input[input.length-1-i] = temp;
        }
    }
    public static void main(String[] args) {
        char[] inputString = {'T', 'e', 's', 't'};

        reverse(inputString);

        System.out.println(inputString);
    }
}