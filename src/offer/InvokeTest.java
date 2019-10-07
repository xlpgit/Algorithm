package offer;

import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeTest {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("Count");
            Object count = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("method", String.class);
            method.setAccessible(true);
            method.invoke(count, "fgsfgtdhtrjhryhreg");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
