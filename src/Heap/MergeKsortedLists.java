package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKsortedLists {
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
        public ListNode mergeKLists(ListNode[] lists) {
            // comparator use kr rhe hai kyuki heap construction me comparison hota hai value ka aur yaha toh nodes hai so nodes ko kaise compare krenge tbhi comparator use kiye
            // check Heap class for understanding what i said
            PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val; // since already it's min heap, so we need to do opposite from sorting
                }
            });
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    pq.add(lists[i]);
                }
            }
            ListNode dummy = new ListNode(0); // dummy node
            ListNode temp = dummy;
            while (!pq.isEmpty()) {
                ListNode rv = pq.poll();
                dummy.next = rv;
                dummy = dummy.next;
                if (rv.next != null) {
                    pq.add(rv.next);
                }
            }
            return temp.next;
        }
    }

}
