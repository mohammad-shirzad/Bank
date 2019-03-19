package util;

import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;

public interface CompareTool<T> {
    List<FieldValues> compare(T t);
}
