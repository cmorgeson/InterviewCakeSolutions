/*
    Problem #24
    Reverse a Linked List
    https://www.interviewcake.com/question/java/reverse-linked-list

    Expected Output:
    5
*/

public class ReverseLinkedList {

    public static class LinkedListNode {
        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode reverse(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedListNode prev = null;
        LinkedListNode curr = head;
        LinkedListNode temp;

        while (curr.next != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return curr;
    }
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode second = new LinkedListNode(2);
        LinkedListNode third = new LinkedListNode(3);
        LinkedListNode fourth = new LinkedListNode(4);
        LinkedListNode fifth = new LinkedListNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

        System.out.println(String.valueOf(reverse(head).value));
    }
}