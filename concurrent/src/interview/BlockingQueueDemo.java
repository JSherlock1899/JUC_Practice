package interview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author: sherlock
 * @description:
 * @date: 2020/6/13 22:54
 */
public class BlockingQueueDemo {

    public static void main(String[] args){
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + " put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + " put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + " put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"producer").start();

        new Thread(()->{
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " get 1");
                blockingQueue.take();
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " get 2");
                blockingQueue.take();
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " get 3");
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"consumer").start();
    }
}
