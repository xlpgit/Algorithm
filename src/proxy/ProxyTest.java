package proxy;

public class ProxyTest {
    public static void main(String[] args) {
        StudentProxyHandler handler = new StudentProxyHandler();

        StudentServiceImpl proy = new StudentServiceImpl();
        proy.getName(6543);

        //调用对象变了
        StudentService proxy = (StudentService) handler.newProxyInstance(new StudentServiceImpl());
        proxy.getName(12);

    }
}
