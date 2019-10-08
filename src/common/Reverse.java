package common;


import java.util.List;

/**
 * 字符串与链表倒序输出
 */
public class Reverse {
    public static void main(String[] args) {
        String s="abcdefgh";
        reverseString(s);
        System.out.println();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        ListNode result=reverseNode(head);
        while(result!=null){
            System.out.print(result.data);
            result=result.next;
        }

    }

    /**
     * 倒序输出字符串
     */
    private static void reverseString(String s) {
        char[] chars=s.toCharArray();
        for(int i=chars.length-1;i>=0;i--){
            System.out.print(chars[i]);
        }
    }

    /**
     * 倒序输出链表，指的是单链表
     */
    private static ListNode reverseNode(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode p1=head;
        ListNode p2=head.next;
        ListNode p3=null;
        while (p2!=null){
            p3=p2.next;
            p2.next=p1;
            p1=p2;
            p2=p3;
        }
        head.next=null;
        head=p1;
        return head;
    }

    static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

}
