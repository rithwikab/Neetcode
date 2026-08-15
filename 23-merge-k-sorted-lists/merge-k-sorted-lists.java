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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });
        for(ListNode k:lists){
            if(k!=null)
            pq.offer(k);
        }
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while(!pq.isEmpty()){
            ListNode cur = pq.poll();
            head.next = cur;
            if(cur.next!=null){
                pq.offer(cur.next);
            }
            head = cur;
        }
        head.next = null;
        return dummy.next;
    }
}