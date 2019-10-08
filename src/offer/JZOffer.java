package offer;

import apple.laf.JRSUIUtils;

import java.io.Console;
import java.util.*;

/**
 * 剑指 offer
 */
public class JZOffer {



    /**
     * 题目描述
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * 解析：先找最左下角的数字，往后变大，往上变小
     *
     * @param target
     * @param array
     * @return
     */
    public boolean find(int target, int[][] array) {
        //二维数组的行；
        int row = array.length - 1;
        //二维数组的列；
        int column = array[0].length - 1;
        int i = row, j = 0;
        while (i >= 0 && j <= column) {
            if (target < array[i][j]) {
                i--;
            } else if (target > array[i][j]) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * 解析：输入的字符串设置为StringBuffer类型的，再设置一个StringBuffer类型的为替换空格之后的字符串，
     * 通过StringBuffer的charAt(i)方法得到当前位置的字母，若为空格，直接替换；否则，还是原来的值。
     * 最后把StringBuffer通过toString方法转换为string即可。
     */
    public String repalceSpace(StringBuffer str) {

        //str.toString().replaceAll("\\s+","%20" );
        //替换之后的sb
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }




    /**
     * 题目描述
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     *解析：法一：借助栈先进后出的特点，转移到链表中；法二：
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }

    static class ListNode{
        int val;
        ListNode next=null;
        ListNode(int val){
            this.val=val;
        }
    }


    /**
     * 题目描述
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in){
        TreeNode tree=solve(pre,0,pre.length-1,in,0,in.length-1);
        return tree;
    }
    public static TreeNode solve(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){

        if(startPre>endPre || startIn>endIn){
            return null;
        }
        TreeNode root=new TreeNode(pre[startPre]);
        for(int i=0;i<in.length;i++){
            if(in[i]==pre[startPre]){
                root.left=solve(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=solve(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return root;
    }

    //非递归实现
    /*public static TreeNode solve2(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){

    }*/

    /**
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (stack2.isEmpty()){
            if(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * 题目描述
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * 解析：可以直接进行遍历，找最小值。以最小值为界
     */
    /*public int minNumberInRotateArray(int[] array) {
        if(array.length==0){
            return 0;
        }
        int min=0;
        for(int i=0;i<array.length;i++){
            if(min>array[i]){
                min=array[i];
            }
        }
        return min;
    }*/

    //思路：比如：3，4，5，1，2；设最大值为2，若有一个数超过最大值，
    // 则发生了反转，即找到了最小值。
    public int minNumberInRotateArray(int[] array) {
        if(array.length==0){
            return 0;
        }
        int max=array[array.length-1];
        for(int i=array.length-2;i>=0;i--){
            if(max<array[i]){
                return array[i+1];
            }
        }
        return array[0];
    }

    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     */
    public class Solution {
        public int Fibonacci(int n) {
            if(n==0) {
                return 0;
            }
            if(n==1) {
                return 1;
            }
            return Fibonacci(n-1)+Fibonacci(n-2);

        }
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     */
        public int JumpFloor(int target) {
            if(target==1){
                return 1;
            }
            if(target==2){
                return 2;
            }
            return JumpFloor(target-1)+JumpFloor(target-2);
        }

    /**
     *一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     */
        public int JumpFloorII(int target) {
            if(target==1){
                return 1;
            }
            if(target==2){
                return 2;
            }
            return 2*JumpFloorII(target-1);
        }

    /**
     *题目描述
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     */
        public int RectCover(int target) {
            if(target<1){
                return 0;
            }
            if(target==1){
                return 1;
            }
            if(target==2){
                return 2;
            }
            return RectCover(target-1)+RectCover(target-2);
        }

    /**
     * 二进制中1的个数：
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * 补充：正整数的原码、反码、补码都相等（符号位+数值位，其中0代表正数，1代表负数）
     * 负整数，原码：符号位为1，数值位表示数值的绝对值；
     * 反码：符号位为1，其余各位对原码取反；补码：反码加1。
     * 如果一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，
     * 原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。其余所有位将不会受到影响。
     * 举个例子：一个二进制数1100，从右边数起第三位是处于最右边的一个1。减去1后，第三位变成0，它后面的两位0变成了1，而前面的1保持不变，因此得到的结果是1011.
     * 我们发现减1的结果是把最右边的一个1开始的所有位都取反了。这个时候如果我们再把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。
     * 如1100&1011=1000.也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
     * 每次都是把最右的1计算并清除，这样就只剩下其他的1，并且没有新加1。所以和是不是负数没有关系，只要是二进制，都可以用这个解法
     */
    public static int NumberOf1(int n) {
        int count=0;
        while(n!=0){
            ++count;
            n=n&(n-1);
            System.out.println(n);
        }
        return count;
    }

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     *
     * 保证base和exponent不同时为0（不能使用库函数）
     */
    /*public double Power(double base, int exponent) {
        return Math.pow(base,exponent);
    }*/
    public double Power(double base, int exponent) throws Exception {
        double result=1;
        if(base==0 && exponent>=0){
            return 0;
        }else if(base==0 && exponent<0){
            throw new Exception("0的负数次幂没有意义");
        }
        if(base!=0 && exponent==0){
            return 1;
        }else if(base!=0 && exponent<0){
            return 1/Cal(base,-exponent);
        }else if(base!=0 && exponent>0){
            return Cal(base,exponent);
        }
        return -1;
    }
    public double Cal(double base, int exponent){
        double result=1;
        for(int i=0;i<exponent;i++){
            result*=base;
        }
        return result;
    }

    /**
     * 题目描述
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
   /* public static void reOrderArray(int [] array) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        for(int arr:array){
            if(arr%2==1){
                list1.add(arr);
            }else{
                list2.add(arr);
            }
        }
        list1.addAll(list2);
        for(int i=0;i<list1.size();i++){
            array[i]=list1.get(i);
        }
    }*/

    public static void reOrderArray(int [] array) {
        int i=0;
        int j=array.length-1;
        int temp;
        while(i<=j){
            if(array[i]%2==1){
                i++;
            }else{
                temp=array[i];
                int m=i;
                while(m<array.length-1){
                    array[m]=array[m+1];
                    m++;
                }
                j--;
                array[array.length-1]=temp;
            }
        }
        for(int arr:array){
            System.out.print(arr);
        }
    }

    /**
     * 题目描述
     * 输入一个链表，输出该链表中倒数第k个结点。
     * 思路：给定两个指针p1，p2都指向头节点，先让p2走k步；然后p1，p2同时走；
     * 当p2指向为空时，此时p1指向正好是倒数第k个结点。
     * 需要考虑：k大于node的个数(此时k为正，但是p2早为空)
     *
     */
    public static ListNode FindKthToTail(ListNode head,int k) {
        ListNode p1=head,p2=head;
        while (k>0 && p2!=null){
            p2=p2.next;
            k--;
        }
        if(k>0 && p2==null){
            return null;
        }
        while(p2!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;

    }


    /**
     * 题目描述
     * 输入一个链表，反转链表后，输出新链表的表头。
     * 思路：首先判断链表是否为空，不为空时再进行操作。设三个指针p1，p2，p3，分别指向头结点、第二个结点、第三个结点。
     * 以p2为视角，把p2结点原本指向p3的指针倒转，指向p1，以此类推。
     */
    public static ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode p1=head;
        ListNode p2=head.next;
        ListNode p3=null;
        while(p2!=null){
            p3=p2.next;
            p2.next=p1;
            p1=p2;
            p2=p3;
        }
        head.next=null;
        head=p1;
        return head;
    }

    /**
     *题目描述：合并两个排序的链表
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     */
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode mergeHead=null;
        ListNode current=null;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                if(mergeHead==null){
                    mergeHead=current=list1;
                }else {
                    current.next = list1;
                    current=current.next;
                }
                list1=list1.next;
            }
            else{
                    if(mergeHead==null){
                        mergeHead=current=list2;
                    }else {
                        current.next = list2;
                        current=current.next;
                    }
                    list2=list2.next;
                }
        }
        if(list1!=null && list2==null){
            current.next=list1;
        }
        if(list2!=null && list1==null){
            current.next=list2;
        }
        return mergeHead;

    }

    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     */
    public boolean HasSubTree(TreeNode root1, TreeNode root2){
        boolean flag=false;

        if(root1!=null && root2!=null){
            if(root1.val==root2.val){
                //以根结点为起点是否包含tree2
                flag=containsTree2(root1,root2);
            }
            //以左孩子当起点进行判断
            if(!flag){
                flag=containsTree2(root1.left,root2);
            }
            //以右孩子当起点进行判断
            if(!flag){
                flag= containsTree2(root1.right,root2);
            }
        }
        return flag;
    }

    private boolean containsTree2(TreeNode root1, TreeNode root2) {
        //树2遍历结束
        if(root2==null){
            return true;
        }
        //树2没有遍历完，树1遍历结束
        if(root1==null){
            return false;
        }
        //其中有一个结点没有匹配上，返回false
        if(root1.val!=root2.val){
            return false;
        }
        //根结点匹配之后分别去匹配左右子树
        return containsTree2(root1.left,root2.left) && containsTree2(root1.right,root2.right);
    }


    public static void main(String[] args) {
        int[] pre={1,2,3,4,5,6,7};
        //int[] in={3,2,4,1,6,5,7};
       // reConstructBinaryTree(pre,in);
        /*String string="abc";
        StringBuffer stringBuffer=new StringBuffer("abc");
        StringBuilder stringBuilder=new StringBuilder("abc");*/
        //stringBuffer.append(1)
        //NumberOf1(9);
        //reOrderArray(pre);

        //初始化链表
        /*ListNode head=new ListNode(3);
        head.next=new ListNode(5);
        ListNode temp=head.next;
        temp.next=new ListNode(1);
        temp=temp.next;
        temp.next=new ListNode(4);
        temp=temp.next;
        temp.next=new ListNode(9);*/
        //逆序前输出链表
        //temp=head;
        /*while (temp!=null){
            System.out.print(temp.val);
            temp=temp.next;
        }
        System.out.println();
        //逆序链表
        ListNode node=ReverseList(head);
        //逆序后输出链表
        temp=node;
        while (temp!=null){
            System.out.print(temp.val);
            temp=temp.next;
        }*/
        ListNode head2=new ListNode(1);
        head2.next=new ListNode(2);
        ListNode temp2=head2.next;
        temp2.next=new ListNode(3);
        temp2=head2;

        ListNode head3=new ListNode(2);
        head3.next=new ListNode(3);
        ListNode temp3=head3.next;
        temp3.next=new ListNode(4);
        temp3=head3;
        //输出listnode的值
        ListNode result=Merge(temp2,temp3);
        while(result!=null){
            System.out.println("val:"+result.val);
            result=result.next;
        }

    }
}



