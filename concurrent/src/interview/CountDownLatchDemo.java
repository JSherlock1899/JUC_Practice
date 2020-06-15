package interview;


import java.util.concurrent.CountDownLatch;

/**
 * @author: sherlock
 * @description:
 * @date: 2020/6/14 19:17
 */
public class CountDownLatchDemo {

    static CountDownLatch countDownLatch = new CountDownLatch(6);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 6; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final int temp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国被灭！");
                countDownLatch.countDown();
            }, CountryEnum.foreach(temp).getRetMsg()).start();
        }
        countDownLatch.await();
        System.out.println("秦一统华夏！");
    }

    public enum CountryEnum{
        ONE(1,"韩"),TWO(2,"赵"),THREE(3,"魏"),FOUR(4,"楚"),FIVE(5,"燕"),SIX(6,"齐");

        private Integer retCode;
        private String retMsg;

        CountryEnum(Integer retCode, String retMsg) {
            this.retCode = retCode;
            this.retMsg = retMsg;
        }

        public Integer getRetCode() {
            return retCode;
        }

        public String getRetMsg() {
            return retMsg;
        }

        public static CountryEnum foreach(int index) {
            CountryEnum[] countryEnums = CountryEnum.values();
            for (CountryEnum countryEnum : countryEnums) {
                if (countryEnum.getRetCode() == index) {
                    return countryEnum;
                }
            }
            return null;
        }
    }

}
