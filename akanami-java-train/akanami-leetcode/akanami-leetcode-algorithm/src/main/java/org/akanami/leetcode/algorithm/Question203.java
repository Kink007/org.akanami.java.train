package org.akanami.leetcode.algorithm;

public class Question203 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        System.out.println(l1);

        ListNode listNode = new Solution().removeElements(l1, 6);
        System.out.println(listNode);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if(head == null)
                return null;

            ListNode pre = head;
            ListNode next = head.next;

            while(next != null) {
                if(next.val == val) {
                    pre.next = next.next;
                    next = next.next;
                } else {
                    pre = next;
                    next = next.next;
                }
            }

            if(head.val == val)
                head = head.next;

            return head;
        }
    }
}
