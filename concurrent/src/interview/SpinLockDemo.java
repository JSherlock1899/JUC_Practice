package interview;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: sherlock
 * @description:
 * @date: 2020/6/14 17:27
 */
public class SpinLockDemo {

    //原子引用线程
    static AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public static void mylock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " come in");
        while (!atomicReference.compareAndSet(null, thread)) {
            System.out.println(thread.getName() + " terrible");
        }
    }

    public static void unlock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " unlock");
        atomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            mylock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            unlock();
        },"A").start();

        Thread.sleep(500);
        new Thread(()->{
            mylock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            unlock();
        },"B").start();
    }
}
