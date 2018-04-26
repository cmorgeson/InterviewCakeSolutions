/*
    Problem #32
    Top Scores
    https://www.interviewcake.com/question/java/top-scores

    Expected Output:
    37
    37
    41
    53
    65
    89
    91
*/

public class TopScores {
    public static int[] sortScores(int[] scores, int highestScore) {
        int[] countArray = new int[highestScore+1];

        for (int currScore : scores) {
            countArray[currScore]++;
        }

        int[] sorted = new int[scores.length];
        int sortedIndex = 0;
        for (int i=0; i<highestScore+1; i++) {
            if (countArray[i] != 0) {
                for (int j=0; j<countArray[i]; j++) {
                    sorted[sortedIndex] = i;
                    sortedIndex++;
                }
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        int[] unsortedScores = {37, 89, 41, 65, 37, 91, 53};
        final int HIGHEST_POSSIBLE_SCORE = 100;

        int[] sortedScores = sortScores(unsortedScores, HIGHEST_POSSIBLE_SCORE);
        for (int i : sortedScores) {
            System.out.println(i);
        }
    }
}