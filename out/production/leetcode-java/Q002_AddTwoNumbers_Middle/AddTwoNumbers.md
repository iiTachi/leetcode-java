# 两数相加

## 题目描述

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

```c
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
```

来源：[两数相加](https://leetcode-cn.com/problems/add-two-numbers)



## 解题思路

想象一下正常的两个数相加，从最低位开始相加，若大于10则进位1。

即最终每一位的数字为：两个位的数字和再加上进位：x + y + carry

现用单链表的代码来模拟这个过程

```java
public class AddTwoNumbers {

    //Definition for singly-linked list.
    //public static class ListNode {
    //    int val;
    //    ListNode next;
    //
    //   ListNode(int x) {
    //       val = x;
    //    }
    //}

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 设置一个虚拟节点，仅用作始终指向头结点
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            // 将 x 设为结点 p 的值。如果 p 已经到达 l1 的末尾，则将其值设置为 0
            int x = (p != null) ? p.val : 0;
            // 将 y 设为结点 p 的值。如果 p 已经到达 l2 的末尾，则将其值设置为 0
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            // 更新进位的值
            carry = sum / 10;
            // 创建一个数值为 (sum mod 10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            // p和q向后推进
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        // 最高位相加若大于10，则产生一个进位，即一个额外的结点
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
```

