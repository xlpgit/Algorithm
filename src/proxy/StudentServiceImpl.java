package proxy;

public class StudentServiceImpl implements StudentService {
    @Override
    public String getName(int sno) {
        System.out.println("打印学号"+sno);
        return "twj";
    }
}
