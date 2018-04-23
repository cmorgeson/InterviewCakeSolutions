/*
    Problem #13
    Find Rotation Point
    https://www.interviewcake.com/question/java/find-rotation-point

    Expected Output:
    6
*/

public class RotationPoint {
    public static int findRotationIndex(String[] strings) {
        int low = 0;
        int high = strings.length-1;

        while (low < high) {
            int mid = (high-low)/2 + low;

            if (strings[mid].compareToIgnoreCase(strings[mid-1]) < 0) {
                // If the current string is lexigraphically less than it's predecessor, it is the pivot.
                return mid;
            }
            else if (strings[mid].compareToIgnoreCase(strings[0]) < 0) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        String[] words = new String[]{
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "zebra",
                "asymptote",  // <-- rotates here! 6th spot
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
        };
        System.out.println(findRotationIndex(words));
    }
}