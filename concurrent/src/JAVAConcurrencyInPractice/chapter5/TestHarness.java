package JAVAConcurrencyInPractice.chapter5;

import tools.SleepTools;

import java.util.concurrent.CountDownLatch;

/**
 * @author: sherlock
 * @description:
 * @date: 2020/5/6 22:01
 */
public class TestHarness {

    public static long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            System.out.println(startGate.getCount());

            new Thread(() -> {
                try {
                    startGate.await();
                    System.out.println("!!!");

                    try {
                        task.run();
                    } finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;

    }

    public static void main(String[] args) throws InterruptedException {
        long result = timeTasks(10,new Thread(()->{
            System.out.println("???");
        }));


        System.out.println(result);
    }
}
