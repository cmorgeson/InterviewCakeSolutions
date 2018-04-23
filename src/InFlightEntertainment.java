/*
    Problem #14
    In-Flight Entertainment
    https://www.interviewcake.com/question/java/inflight-entertainment

    Expected Output:
    true
*/

import java.util.Set;
import java.util.HashSet;

public class InFlightEntertainment {
    public static boolean hasPair(int[] movieLengths, int flightLength) {
        Set<Integer> lengthsSeen = new HashSet<>();

        for (int length : movieLengths) {
            if (lengthsSeen.contains(flightLength-length)) {
                return true;
            }
            else {
                lengthsSeen.add(length);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] movieTimes = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("" + hasPair(movieTimes, 3));
    }
}