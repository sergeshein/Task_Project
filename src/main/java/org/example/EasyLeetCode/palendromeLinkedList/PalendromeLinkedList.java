package org.example.EasyLeetCode.palendromeLinkedList;

public class PalendromeLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

        public boolean isPalindrome(ListNode head) {
            if(head == null){
                return true;
            }
            ListNode secondHalf = middle(head);
            ListNode secondHead = reverse(secondHalf);

            ListNode l = head;
            ListNode r = secondHead;

            while(r != null){
                if(l.val != r.val){
                    reverse(secondHead);
                    return false;
                }

                l = l.next;
                r = r.next;
            }
            reverse(secondHead);
            return true;


        }

        private ListNode reverse (ListNode mid){
            ListNode prev = null;  //в последствии это конец второго списка
            ListNode curr = mid;
            while(curr != null){
                ListNode tmp = curr.next;
                curr.next = prev;

                prev = curr; //меняем направление курсора
                curr = tmp;


            }
            return prev;
        }

        private ListNode middle (ListNode head){
            ListNode slow = head;
            ListNode fast = head.next; // два курсора
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.next;
        }
    }

