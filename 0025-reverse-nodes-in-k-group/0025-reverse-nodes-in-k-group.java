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
    public ListNode getKthNode(ListNode head, int k){
        k-=1;
        ListNode temp = head;
        while(temp!=null && k>0){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverseLinkedList(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur!=null){
            ListNode tempNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNode;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null){
            ListNode kthNode = getKthNode(temp,k);
            if(kthNode==null){
                if(prev!=null) prev.next = temp;
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseLinkedList(temp);
            if(temp==head) head = kthNode;
            else{
                prev.next = kthNode;
            }
            prev = temp;
            temp = nextNode;

        }
        return head;
    }
}