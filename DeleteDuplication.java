在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5。

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null)
            return null;
        ListNode head = new ListNode(-1);//增加一个头结点，方便头部的删除处理
        head.next = pHead;//新增的头部指向原来的头部
        ListNode p = head;
        ListNode q = pHead;
        while(q != null){
            while(q.next != null && q.val == q.next.val)
                q = q.next;
            if( q == p.next){//说明没有重复的结点，p和q都依次指向下一个结点
                q = q.next;
                p = p.next;
            }else{
                p.next = q.next;//当有重复的结点时，p连接到q的下一个结点，因为在上一步的while中，q已经下移，
                                //所以相当于将重复的结点全部删除了,
                q = q.next;//q指向q的下一个结点
            }
        }
        return head.next;//返回头结点

    }
}
