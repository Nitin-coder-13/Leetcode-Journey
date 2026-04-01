package LinkedList;

public class MergeTwoSortedList {
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

    class Solution {
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
    }
}
