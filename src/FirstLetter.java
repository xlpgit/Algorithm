import java.util.HashMap;

public class FirstLetter {
    public static void main(String[] args) {
        String str = "abbaccdeff";
        printFirstLetter(str);
    }

    /**
     * hashmap的设置，关键字key：字符，值value：字符出现的次数。
     *
     * @param str
     */
    public static void printFirstLetter(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            //如果字符在hashmap中已经出现过了，利用get方法，通过关键字字符来得到该字符对应的次数，并进行加一。
            //其中str.charAt(i)返回字符串对应下标为i的字符。
            if (map.containsKey(str.charAt(i))) {
                int value = map.get(str.charAt(i));
                map.put(str.charAt(i), value + 1);
            } else {
                //字符第一次出现时，value设为1。
                map.put(str.charAt(i), 1);
            }
        }
        System.out.println();
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                System.out.println(str.charAt(i));
                break;
            }
        }
    }
}
