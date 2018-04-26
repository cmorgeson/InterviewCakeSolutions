/*
    Problem #15
    Compute nth Fibonacci number
    https://www.interviewcake.com/question/java/nth-fibonacci

    Expected Output:
    144
*/

public class NthFib {

    public static int nthFib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Bad input");
        }
        else if (n < 2) {
            return n;
        }

        int prevPrev = 0;
        int prev = 1;
        int curr = 1;

        for (int i = 2; i<=n; i++) {
            curr = prev+prevPrev;
            prevPrev = prev;
            prev = curr;
        }

        return curr;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(String.valueOf(nthFib(n)));
    }
}