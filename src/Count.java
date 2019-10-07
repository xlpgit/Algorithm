import java.util.HashMap;

/**
 * 字符串统计每个字符次数
 */
 public  class Count {
    public static void main(String[] args) {

        Count count = new Count();
        count.method("fsefsrfgsg");


    }

    private String method(String s) {
        char[] ch = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int value;
        for (int i = 0; i < ch.length; i++) {
            if (map.containsKey(ch[i])) {
                value = map.get(ch[i]);
                value++;
                map.put(ch[i], value);
            } else {
                map.put(ch[i], 1);
            }
        }
        System.out.println(map.toString());
        return map.toString();
    }


}
