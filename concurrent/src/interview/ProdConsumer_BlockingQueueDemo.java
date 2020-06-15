package interview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: sherlock
 * @description:
 * @date: 2020/6/15 16:53
 */
public class ProdConsumer_BlockingQueueDemo {

    static class MyResource{
        private volatile boolean flag = true;
        private AtomicInteger atomicInteger = new AtomicInteger();
        private BlockingQueue<String> blockingQueue = null;

        public  MyResource(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
            System.out.println(blockingQueue.getClass().getName());
        }

        public void prod()throws Exception {
            String data;
            boolean retValue;
            while (flag) {
                data = atomicInteger.incrementAndGet() + "";
                retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
                if (retValue) {
                    System.out.println(Thread.currentThread().getName() + " 插入队列 " + data + "成功");
                    Thread.sleep(1000);
                }else {
                    System.out.println(Thread.currentThread().getName() + " 插入队列 " + data + "失败");
                }
            }
            System.out.println("生产结束！");
        }

        public void consumer()throws Exception {
            String data;
            while (flag) {
                data = blockingQueue.poll(2L, TimeUnit.SECONDS);
                if (data != null || "".equals(data)) {
                    System.out.println(Thread.currentThread().getName() + " 消费队列 " + data + "成功");
                } else {
                    System.out.println(Thread.currentThread().getName() + "超过两秒钟 " + " 消费队列 " + data + "失败");
                    flag = false;
                }
            }
            System.out.println("消费结束！");
        }

        public void stop() {
            this.flag = false;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "生产线程启动");
            try {
                myResource.prod();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "消费线程启动");
            try {
                myResource.consumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Consumer").start();

        Thread.sleep(5000);
        System.out.println("睡五秒");
        myResource.stop();
        System.out.println("GG");
    }


    }



