一个链表中包含环，请找出该链表的环的入口结点。

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
/*解法参考自剑指offer第139页
 *第一步确定一个链表中是否包含环，采用一个快指针（每次走两步），一个慢指针（每次走一步），
 *如果两个指针能相遇，则链表存在环。
 *
 *第二步求环中结点的数目，从第一步返回的结点（结点一定在环中）出发，当再次回到该结点时，所记录的结点数就是环的大小n
 *
 *第三步求环的入口，同样采用两个指针，快指针先从链表开头走由第二步得到的环的大小的步数，然后再同时挪动快指针和慢指针，
 *二者相遇的结点就是环的入口
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode meetingNode = meetingNode(pHead);//调用环判断函数，返回相遇结点
        if(meetingNode == null)
            return null;
        
        //得到你环中几点的数目，即环的大小
        int nodesInLoop = 1;
        ListNode pNode1 = meetingNode;//声明一个结点从环中出发，meetingNode是上一步返回的结点，一定在环中
        while(pNode1.next != meetingNode){
            pNode1 = pNode1.next;
            nodesInLoop++;
        }
        
        //求环入口，先移动快结点pNode1,移动步数是环的大小
        pNode1 = pHead;
        for(int i = 0;i < nodesInLoop;i++)
            pNode1 = pNode1.next;
        
        //再移动pNode1和pNode2
        ListNode pNode2 = pHead;
        while(pNode1 != pNode2){
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;
    }
    
    ListNode meetingNode(ListNode pHead){
        if(pHead == null)
            return null;
        ListNode pSlow = pHead.next;//声明慢指针，先走一步
        if(pSlow == null)
            return null;
        
        ListNode pFast = pSlow.next;//声明快指针，指向pSlow的下个结点，相当于先走两步
        while(pFast != null && pSlow != null){
            if(pSlow == pFast)//如果pSlow == pFast,即快指针追上了慢指针，则链表存在环
                return pFast;//返回快慢指针相遇的位置
            
            pSlow = pSlow.next;//慢指针每次走一步
            
            pFast = pFast.next;
            if(pFast != null)
                pFast = pFast.next;//快指针每次走两步，但是走完一步要先判断一下是否到最后结点
        }
        return null;//最终走完没有相遇的话，返回null
    }
}
