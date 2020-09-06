import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

/**
 * @author: sherlock
 * @description:
 * @date: 2020/5/6 22:57
 */
public class Test {

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);

    }
    public static void main(String[] args) {
        String x = "string";
        String y = "string";
        String z = new String("string");
        Integer a = new Integer(122);
        Integer b = new Integer(122);
        System.out.println(x==y);
        System.out.println(x==z);
        System.out.println(x.equals(y));
        System.out.println(x.equals(z));
        System.out.println(a == b);

    }
}
