package T;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: sherlock
 * @description:
 * @date: 2020/6/30 14:10
 */
public class CollectionUtils {

    public static boolean compare(List list1, List list2) {
        if (list1.isEmpty() || list2.isEmpty()) {
            return false;
        }
        Collections.sort(list1);
        Collections.sort(list2);
        if (list1.toString().equals(list2.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        List list1 = Arrays.asList(1, 1, 3, 1, 4);
        List list2 = Arrays.asList(3, 4, 1, 1, 1);
        List list3 = Arrays.asList(1,1,3,1,5);
        boolean compare1 = compare(list1, list2);
        boolean compare2 = compare(list1, list3);
        System.out.println(compare1);
        System.out.println(compare2);
    }
}
