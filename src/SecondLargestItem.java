/*
    Problem #10
    2nd Largest Item in a Binary Search Tree
    https://www.interviewcake.com/question/java/second-largest-item-in-bst

    Expected Output:
    10
*/

public class SecondLargestItem {
    public static class BinaryTreeNode {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }

    public static class LargestResult {
        public BinaryTreeNode largest;
        public BinaryTreeNode parent;

        public LargestResult(BinaryTreeNode largest, BinaryTreeNode parent) {
            this.largest = largest;
            this.parent = parent;
        }
    }

    public static LargestResult findLargest(BinaryTreeNode root) {
        BinaryTreeNode curr = root;
        BinaryTreeNode parent = null;

        while (curr.right != null) {
            parent = curr;
            curr = curr.right;
        }

        return new LargestResult(curr, parent);
    }

    public static int findSecondLargest(BinaryTreeNode root) {
        if (root == null || root.right == null && root.left == null) {
            throw new IllegalArgumentException("Bad input");
        }

        LargestResult largest = findLargest(root);
        BinaryTreeNode largestNode = largest.largest;

        BinaryTreeNode secondLargest;
        if (largestNode.left != null) {
            secondLargest = findLargest(root.left).largest;
        }
        else {
            secondLargest = largest.parent;
        }

        return secondLargest.value;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTreeNode second = root.insertRight(10);
        BinaryTreeNode third = second.insertRight(15);

        System.out.println(" " + findSecondLargest(root));
    }
}