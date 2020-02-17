package Q206_ReverseLinkedList_Easy;

/**
 * @author Howie Lu
 * @version Updated at 2020-02-06
 * @Description
 */

// Definition for singly-linked list.
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        if(head == null) { return null; }
        // 使用头插法，先准备一个头节点,并插入第一个节点
        ListNode virtualHead = new ListNode(0);
        ListNode newHead = new ListNode(head.val);
        virtualHead.next = newHead;

        while(head.next != null){
            // curr用来接收新节点，并插入到头节点后面
            ListNode curr = new ListNode(head.next.val);
            curr.next = newHead;
            virtualHead.next = curr;

            // newHead始终指向头节点的下一个，即始终位于应插入位置的后方
            newHead = curr;
            head = head.next;
        }
        return virtualHead.next;
    }
}
