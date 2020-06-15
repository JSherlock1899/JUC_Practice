//package interview;
//
//import java.util.*;
//import java.util.concurrent.CopyOnWriteArrayList;
//import java.util.function.Consumer;
//
///**
// * @author: sherlock
// * @description:
// * @date: 2020/6/12 20:13
// */
//public class ContainerNotSafeDemo {
//
//    public static void main(String[] args) {
//        List<String> list = new CopyOnWriteArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            new Thread(() -> {
//                list.add(UUID.randomUUID().toString().substring(0, 8));
////                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(list);
//            }, String.valueOf(i)).start();
//        }
//    }
//}
