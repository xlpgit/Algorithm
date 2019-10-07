package example;

import java.util.HashMap;
import java.util.Stack;


/**
 * 括号匹配
 */
public class Bracket {
    public static void main(String[] args) {
        String s = "(2[1+3)]";
        System.out.println(match(s));

    }

    public static boolean match(String s) {
        Stack<String> stack = new Stack<>();
        HashMap<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");
        char[] ch = s.toCharArray();
        for (char c : ch) {
            String temp = c + "";
            //只把字符串中与左括号相关的存到栈中，其他的字母数字都不往栈里边存
            if (map.containsValue(temp)) {
                stack.push(temp);
            }
            //若为右括号，并且栈顶元素正好是左括号，则把栈顶元素弹出
            else if (map.containsKey(temp)) {
                if (stack.isEmpty()) {
                    return false;
                }
                //可以通过键匹配到值，因为键是唯一的，但是不能通过值匹配到键。现在想通过右括号得到左括号，所以右括号做键
                //stack.peek()与stack.pop()都是获得栈顶元素，但是peek方法不删除栈顶元素到值，pop方法会删除栈顶元素的值。
                if (stack.peek().equals(map.get(temp))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
