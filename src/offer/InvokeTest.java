package offer;

import java.lang.reflect.Method;

public class InvokeTest {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("Count");
            Object count = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("method", String.class);
            method.setAccessible(true);
            Object res = method.invoke(count, "fgsfgtdhtrjhryhreg");
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getInvoke(String clazz) {
        return "";

    }
}
