//package interview;
//
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.concurrent.atomic.AtomicStampedReference;
//
///**
// * @author: sherlock
// * @description:
// * @date: 2020/6/11 14:42
// */
//public class VolatileDemo {
//
//    static class MyData {
//        static volatile int number = 0;
//        static AtomicInteger atomicInteger = new AtomicInteger(0);
//        static  void add() {
//            number++;
//        }
//
//        static void atomicAdd() {
//            atomicInteger.getAndIncrement();
//        }
//    }
//    public static void main(String[] args) {
////        new Thread(()->{
////            System.out.println(Thread.currentThread().getName() +  "/t come in");
////            try {
////                Thread.sleep(3);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////            MyData.number = 60;
////            System.out.println(Thread.currentThread().getName() +  "/t number = " + MyData.number);
////        }).start();
//
////        while (MyData.number == 0) {
////
////        }
////        System.out.println(MyData.number);
//
//        for (int i = 0; i < 50; i++) {
//            new Thread(()->{
//                for (int j = 0; j < 2000; j++) {
//                    MyData.add();
//                    MyData.atomicAdd();
//                }
//            },String.valueOf(i)).start();
//        }
//
//        while (Thread.activeCount() > 2) {
//            Thread.yield();
//        }
//
//
//        System.out.println(Thread.currentThread().getName() + " finally " + MyData.number);
//        System.out.println(Thread.currentThread().getName() + " finally " + MyData.atomicInteger);
////        MyData.atomicInteger.compareAndSet()
//
//    }
//
//}
