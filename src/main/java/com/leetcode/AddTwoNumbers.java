package com.leetcode;

/**
 * @description: 2、
 * (2 - > 4 - > 3) + (5 -> 6 -> 4)   7 -> 0 -> 8
 * @author: zhuzz
 * @date: 2018/10/12 23:02
 */
public class AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int d1 = l1 == null ? 0 : l1.val;
                int d2 = l2 == null ? 0 : l2.val;
                int sum = d1 + d2 + carry;
                carry = sum >= 10 ? 1 : 0;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry == 1) {
                cur.next = new ListNode(1);
            }
            return dummy.next;
        }
    }

    class Solution2 {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode(0);
            recurse(l1, l2, res, 0);
            return res;
        }

        private void recurse(ListNode l1, ListNode l2, ListNode res, int carry) {
            if (l1 == null) {
                l1 = new ListNode(0);
            }

            if (l2 == null) {
                l2 = new ListNode(0);
            }

            res.val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;

            if (l1.next == null && l2.next == null && carry == 0) {
                return;
            }

            res.next = new ListNode(0);
            recurse(l1.next, l2.next, res.next, carry);
        }
    }

}
