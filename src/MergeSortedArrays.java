/*
    Problem #43
    Merge Sorted Arrays
    https://www.interviewcake.com/question/java/merge-sorted-arrays

    Expected Output:
    [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19, 22, 100]
*/

import java.util.Arrays;

public class MergeSortedArrays {
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int arr1Index = 0;
        int arr2Index = 0;
        int[] result = new int[arr1.length+arr2.length];

        for (int i=0; i < result.length; i++) {
            if (arr1Index == arr1.length) {
                result[i] = arr2[arr2Index];
                arr2Index++;
            }
            else if (arr2Index == arr2.length) {
                result[i] = arr1[arr1Index];
                arr1Index++;
            }
            else if (arr1[arr1Index] < arr2[arr2Index]) {
                result[i] = arr1[arr1Index];
                arr1Index++;
            }
            else {
                result[i] = arr2[arr2Index];
                arr2Index++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
        int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19, 22, 100};

        System.out.println(Arrays.toString(mergeArrays(myArray, alicesArray)));
    }
}