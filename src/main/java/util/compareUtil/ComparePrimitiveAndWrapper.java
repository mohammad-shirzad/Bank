package util.compareUtil;

import java.util.Comparator;

public class ComparePrimitiveAndWrapper<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if (o1.equals(o2)) {
            return 0;
        }
        return 1;
    }
}
