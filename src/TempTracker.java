/*
    Problem #7
    Temperature Tracker
    https://www.interviewcake.com/question/java/temperature-tracker

    Expected Output:
    5 5 5.0 5
    20 5 12.5 5
    20 5 15.0 20
*/

import java.util.Map;
import java.util.HashMap;

public class TempTracker {
    private static int n = 0;
    private static int min = 111;
    private static int max = -1;
    private static int sum = 0;
    private static Integer mode = null;
    private static int maxCount = 0;

    private static Map<Integer, Integer> temps = new HashMap<>();

    public static void insert(int temp) {
        n++;
        sum += temp;
        int newCount;

        if (temps.containsKey(temp)) {
            newCount = temps.get(temp) + 1;
        }
        else {
            newCount = 1;
        }

        temps.put(temp, newCount);

        if (newCount > maxCount) {
            maxCount = newCount;
            mode = temp;
        }

        if (temp > max) {
            max = temp;
        }
        if (temp < min) {
            min = temp;
        }
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

    public static void printAll() {
        System.out.println(getMax() + " " + getMin() + " " + getMean() + " " + getMode());
    }

    public static void main(String[] args) {
        insert(5);
        printAll();

        insert(20);
        printAll();

        insert(20);
        printAll();
    }
}