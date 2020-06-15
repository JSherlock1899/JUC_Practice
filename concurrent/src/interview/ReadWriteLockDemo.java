package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: sherlock
 * @description:
 * @date: 2020/6/14 17:51
 */
public class ReadWriteLockDemo {

    static class MyCache{
        private volatile Map<String, Integer> map = new HashMap<>();
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        public void put(String key,Integer value) throws InterruptedException {
            try {
                lock.writeLock().lock();
                System.out.println(Thread.currentThread().getName() + " 正在写入 " + key);
                Thread.sleep(1000);
                map.put(key, value);
                System.out.println(Thread.currentThread().getName() + " 写入完成 ");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.writeLock().unlock();
            }

        }

        public void get(String key) throws InterruptedException {
            try {
                lock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + " 正在读取： ");
                Thread.sleep(1000);
                Integer result = map.get(key);
                System.out.println(Thread.currentThread().getName() + " 读取完成：" + result);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.readLock().lock();
            }
        }
    }


    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->{
                try {
                    myCache.put(temp + "",temp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->{
                try {
                    myCache.get(temp + "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }
}
