package com.xlp.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ZiJie1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < 26; i++) {
            list1.add(sc.nextInt());
        }
        for (int i = 0; i < 26; i++) {
            list2.add(sc.nextInt());
        }

        stack.push(list1.get(0));
        int count1 = 0, count2 = 0;
        for (int i = 1; i < 26; i++) {
            stack.push(list2.get(i));
            while (!stack.isEmpty()) {
                while (list1.get(i).equals(stack.get(i))) {
                    stack.pop();
                    count1++;
                }
                while (list2.get(i).equals(stack.get(i))) {
                    stack.pop();
                    count2++;
                }
            }
        }
        if (count1 > count2) {
            System.out.println("Byte");
        } else {
            System.out.println("Draw");
        }
    }
}
