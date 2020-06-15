package interview;

/**
 * @author: sherlock
 * @description:
 * @date: 2020/6/14 16:49
 */
class Phone{
    public synchronized void sendSMS()throws Exception {
        System.out.println(Thread.currentThread().getId() + " invoke sendSMS");
        sendEmail();
    }

    public synchronized void sendEmail()throws Exception {
        System.out.println(Thread.currentThread().getId() + " ####### invoke sendEmail");
    }
}
public class ReenterLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();
        
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();
    }

}
