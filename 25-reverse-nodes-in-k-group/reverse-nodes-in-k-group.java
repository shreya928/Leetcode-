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
    private ListNode findKnode(ListNode curr, int k){
        while(curr!=null && k>1){
            curr = curr.next;
            k--;
        }
        return curr;
    }
    private ListNode reverse(ListNode curr){
        ListNode prev = null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null){
            ListNode kNode = findKnode(temp,k);
            if(kNode==null){
                if(prev!=null){
                    prev.next = temp;
                    break;
                }
            }
            ListNode nextNode = kNode.next;
            kNode.next = null;
            reverse(temp);
            if(temp==head){
                head = kNode;
            }else{
                prev.next = kNode;
            }
            prev = temp;
            temp = nextNode;
        }
        return head;
    }
}