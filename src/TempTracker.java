/*
    Problem #7
    Temperature Tracker
    https://www.interviewcake.com/question/java/temperature-tracker

    Expected Output:
    5 5 5.0 5
    12 5 8.5 5
    12 5 9.666666666666666 12
*/

public class TempTracker {
    static int sum = 0;
    static int n = 0;
    static int[] temps = new int[111];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int mode;

    public static void insert(int i) {
        min = Math.min(min, i);
        max = Math.max(max, i);

        temps[i]++;

        if (n == 0 || temps[mode] < temps[i]) {
            mode = i;
        }

        sum += i;
        n++;
    }

    public static int getMax() {
        return max;
    }

    public static int getMin() {
        return min;
    }

    public static double getMean() {
        return (double)sum/n;
    }

    public static int getMode() {
        return mode;
    }

    public static void printData() {
        System.out.println(getMax() + " " + getMin() + " " + getMean() + " " + getMode());
    }

    public static void main(String[] args) {
        insert(5);
        printData();
        insert(12);
        printData();
        insert(12);
        printData();
    }
}