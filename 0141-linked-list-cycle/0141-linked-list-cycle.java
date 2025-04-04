/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // List<ListNode> list = new ArrayList<>();
        // ListNode temp = head;
        // while(temp!=null){
        //     if(list.contains(temp)) return true;
        //     list.add(temp);
        //     temp = temp.next;
        // }
        // return false;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }
        return false;
    }
}