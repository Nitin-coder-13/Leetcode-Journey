package LinkedList;

public class SortList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    // same as merge sort of array

    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode mid = mid(head); // middle aa jayega
            ListNode headb = mid.next;
            mid.next = null;
            ListNode l1 = sortList(head);
            ListNode l2 = sortList(headb);
            return mergeTwoLists(l1, l2);

        }

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummyHead = new ListNode(0);
            ListNode temp = dummyHead;
            ListNode HeadA = list1;
            ListNode HeadB = list2;
            while (HeadA != null && HeadB != null) {
                if (HeadA.val < HeadB.val) {
                    dummyHead.next = HeadA;
                    dummyHead = dummyHead.next;
                    HeadA = HeadA.next;
                } else {
                    dummyHead.next = HeadB;
                    dummyHead = dummyHead.next;
                    HeadB = HeadB.next;
                }
            }
            if (HeadA == null) {
                dummyHead.next = HeadB;
            }
            if (HeadB == null) {
                dummyHead.next = HeadA;
            }
            return temp.next;

        }

        public ListNode mid(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) { // changes kyuki hume even waale part ka first mid chhahiye warna stack overflow ho rha, isliye usko ek step piche rokna hoga so fast.next.next!=null aur ye condition second position me aayega
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
