/*
    Problem #36
    Single Riffle Check
    https://www.interviewcake.com/question/java/single-riffle-check

    Expected Output:
    true
*/

public class IsRiffle {
    public static boolean isSingleRiffle(int[] shuffled, int[] h1, int[] h2) {
        if (shuffled == null || h1 == null || h2 == null) {
            throw new IllegalArgumentException("Bad input");
        }

        if (shuffled.length != h1.length + h2.length) {
            return false;
        }

        int h1index = 0;
        int h2index = 0;

        for (int i=0; i<shuffled.length; i++) {
            if (h1index <= h1.length-1 && shuffled[i] == h1[h1index]) {
                h1index++;
            }
            else if (h2index <= h2.length-1 && shuffled[i] == h2[h2index]) {
                h2index++;
            }
            else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] shuffledDeck = {3,5,13,7,42};
        int[] half1 = {3,7,42};
        int[] half2 = {5,13};

        System.out.println(String.valueOf(isSingleRiffle(shuffledDeck, half1, half2)));
    }
}