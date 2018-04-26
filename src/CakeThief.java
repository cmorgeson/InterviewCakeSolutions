/*
    Problem #16
    The Cake Thief
    https://www.interviewcake.com/question/java/cake-thief

    Expected Output:
    555
*/

public class CakeThief {
    static class CakeType {
        int weight;
        int value;

        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value  = value;
        }
    }

    public static int findMaxValue(CakeType[] cakes, int capacity) {
        if (capacity < 0 || cakes == null) {
            throw new IllegalArgumentException("Bad input");
        }

        int[] maxValues = new int[capacity+1];
        maxValues[0] = 0; // If we can carry zero items, our max weight is zero
        int max = Integer.MIN_VALUE;
        int diff;

        for (int i = 1; i<=capacity; i++) {
            for (CakeType cake : cakes) {
                diff = i-cake.weight;
                if (diff == i) {
                    max = Math.max(max, cake.value);
                }
                else if (diff >= 0) {
                    max = Math.max(max, maxValues[diff] + cake.value);
                }
            }

            maxValues[i] = max;
        }

        return maxValues[capacity];
    }

    public static void main(String[] args) {
        CakeType[] cakeTypes = new CakeType[] {
                new CakeType(7, 160),
                new CakeType(3, 90),
                new CakeType(2, 15),
        };

        int capacity = 20;
        System.out.println(String.valueOf(findMaxValue(cakeTypes, capacity)));
    }
}