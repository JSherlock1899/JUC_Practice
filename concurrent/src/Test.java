import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
        HashMap hashMap = new HashMap();
//        ReentrantLock
        Map map = Collections.unmodifiableMap(hashMap);
        map.put("1", 1);
    }
}
