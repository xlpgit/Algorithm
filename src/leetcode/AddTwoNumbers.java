package leetcode;

import java.util.List;

/**
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    /**
     * 最后返回的链表是当前两个逆序链表之和。若遍历中，有一个链表为空，
     * 则赋值为0。n1+n2+carry（进位），链表处的值为余数：(n1+n2+carry)%10，
     * 新的进位值为商：(n1+n2+carry)/10
     *
     * @param node1
     * @param node2
     * @return
     */
    public ListNode add(ListNode node1, ListNode node2) {
        //新生成的链表
        ListNode head = null, tail = null;
        //进位
        int carry = 0;
        while (node1 != null || node2 != null) {
            //node1不为空时，使用当前值，为空时，使用0。
            int n1 = node1 != null ? node1.val : 0;
            int n2 = node1 != null ? node2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                //链表中添加第一元素时，头尾指向一个元素
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            //对链表进行遍历
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }
        //若遍历结束，进位>0，则需另外附加一个结点
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

