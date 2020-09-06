package T;

/**
 * @author: sherlock
 * @description:
 * @date: 2020/6/30 14:30
 */
public class Test {



    public static void main(String[] args) {
        Array array = new ArrayManagerImpl().create();
        array.add(1);
        System.out.println(array.get(1));
//        array.delete(0);
        System.out.println(array.count());
        System.out.println(new ArrayManagerImpl().totalCount());
    }
}
