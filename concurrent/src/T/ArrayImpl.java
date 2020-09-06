package T;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: sherlock
 * @description:
 * @date: 2020/6/30 14:07
 */
public class ArrayImpl implements Array {

    public List<Integer> list = new ArrayList<>();

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public void delete(int index) {
        list.remove(index);
    }

    @Override
    public int get(int index) {
        return list.get(index-1);
    }

    @Override
    public int count() {
        return list.size();
    }
}
