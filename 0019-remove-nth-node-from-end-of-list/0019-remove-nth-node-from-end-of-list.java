// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         int size = 1;
//         ListNode temp = head;

//         if(size == n && head.next == null) return null;

//         while(temp.next!=null){
//             size+=1;
//             temp = temp.next;
//         }

//         temp = head;
//         int newSize = size - n;
//         size=1;
//         while(size<=newSize){
//             if(size == newSize){
//                 temp.next = temp.next.next;
//             }
//             temp = temp.next;
//             size++;
//         }
//         return head;
//     }
// }


// This is 2 pass approach
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         int size = 0;
//         ListNode temp = head;

//         // 1. Get total size
//         while (temp != null) {
//             size++;
//             temp = temp.next;
//         }

//         // 2. Remove head
//         if (n == size) return head.next;

//         // 3. Find the node before the one to remove
//         temp = head;
//         for (int i = 1; i < size - n; i++) {
//             temp = temp.next;
//         }

//         // 4. Skip the nth node from end
//         temp.next = temp.next.next;

//         return head;
//     }
// }

// One pass
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;

        // Move fast ahead by n+1 steps
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both till fast reaches end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete nth node
        slow.next = slow.next.next;

        return dummy.next;
    }
}
