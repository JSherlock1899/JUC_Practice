package interview;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: sherlock
 * @description:
 * @date: 2020/6/14 19:40
 */
public class CyclicBarrierDemo {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(7,new Thread(()->{
        System.out.println("召唤神龙！");
    }));
    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            final int temp = i;
            new Thread(()->{
                System.out.println("收集到第" + temp + "颗龙珠");
                try {
                    System.out.println(cyclicBarrier.getNumberWaiting());
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
