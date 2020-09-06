package T;

/**
 * @author: sherlock
 * @description:
 * @date: 2020/6/30 14:08
 */
public class ArrayManagerImpl implements ArrayManager {

    public Array arr = new ArrayImpl();

    @Override
    public Array create() {
        return arr;
    }

    @Override
    public int totalCount() {
        return arr.count();
    }
}
