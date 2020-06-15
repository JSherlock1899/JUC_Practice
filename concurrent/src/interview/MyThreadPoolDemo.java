package interview;

import java.util.concurrent.*;

/**
 * @author: sherlock
 * @description:
 * @date: 2020/6/15 18:35
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
//        ExecutorService pool = Executors.newFixedThreadPool(5);//一池五线程
//        ExecutorService pool = Executors.newSingleThreadExecutor();//一池一线程
//        ExecutorService pool = Executors.newCachedThreadPool();//一池N线程
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService pool = new ThreadPoolExecutor(2,
                                                    5,
                                                        1L,
                                                        TimeUnit.SECONDS,
                                                    new LinkedBlockingQueue<>(3),
                                                            Executors.defaultThreadFactory(),
                                                        new ThreadPoolExecutor.DiscardPolicy());
        //模拟用户
        try {
            for (int i = 1; i <= 80; i++) {
                pool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "办理业务");
//                    System.out.println(((ThreadPoolExecutor) pool).getActiveCount());
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            pool.shutdown();
        }
    }
}
