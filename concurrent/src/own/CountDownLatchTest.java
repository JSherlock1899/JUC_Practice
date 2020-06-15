package own;

import java.util.concurrent.CountDownLatch;

/**
 * @author: sherlock
 * @description:
 * @date: 2020/5/6 21:28
 */
public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(100);

    private static class Student implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "跑路了！");
            countDownLatch.countDown();
        }
    }

    private static class Teacher implements Runnable {
        @Override
        public void run() {
            try {
                countDownLatch.await();
                System.out.println("锁门！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Student(), String.valueOf(i)).start();
        }
        new Thread(new Teacher()).start();

    }
}
