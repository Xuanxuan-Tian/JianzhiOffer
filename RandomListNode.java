/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        //主函数：依次执行下面三个函数。
        cloneNode(pHead);
        connectRandomNodes(pHead);
        return reconnectNodes(pHead);
    }
    
    //第一步：复制原始链表的任意结点N并创建新结点N'，再把N'链接到N的后面
    void cloneNode(RandomListNode pHead){
        RandomListNode pNode = pHead;//指向头结点
        while(pNode != null){
            RandomListNode pCloned = new RandomListNode(pNode.label);//生成复制后的结点，必须局部每次都new，因为要复制的结点是多个
            //pCloned.label= pNode.label;//复制原结点值
            pCloned.next = pNode.next;//复制结点指向原结点的下一结点
            pCloned.random = null;//特殊指针目前指向空
            
            pNode.next = pCloned;//将原结点指向复制的结点，实现链接
            
            pNode = pCloned.next;//原结点变为复制结点指向的结点，以进行下一个结点的操作
        }
    }
    
    //第二步：设置复制出来的结点的random
    void connectRandomNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;//生成结点指向链表的头结点
        while(pNode != null){
            RandomListNode pCloned = pNode.next;//指向复制的结点
            if(pNode.random != null){
                pCloned.random = pNode.random.next;//复制结点的random指向原结点的random指向的下一个结点
            }
            pNode = pCloned.next;//进行下一个结点的操作
        }
    }
    
    //第三步：把第二步得到的链表拆分成两个链表，奇数位置上的结点组成原始的链表，偶数位置山的结点组成复制出来的链表
    RandomListNode reconnectNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode pClonedHead = null;
        RandomListNode pClonedNode = null;
        
        if(pNode != null){
            pClonedHead = pClonedNode = pNode.next;//复制链表的头指针和当前指针都指向第一个复制结点,例如指向A'
            pNode.next = pClonedNode.next;
            pNode = pNode.next;//使得pNode指向下一个原始结点，例如B
        }
        
        while(pNode != null){
            pClonedNode.next = pNode.next;//例如：A'指向B'
            pClonedNode = pClonedNode.next;//pClonedNode指向下一个复制结点，例如指向B'
            pNode.next = pClonedNode.next;
            pNode = pNode.next;//pNode指向下一个原结点，例如：C
        }
        
        return pClonedHead;//将链表返回
    }
    
    
}
