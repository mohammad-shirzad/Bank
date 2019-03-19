package util;

import java.lang.reflect.Type;

public class NameTypeValue {
    public String name;
    public Type type;
    public Object value;

    public NameTypeValue(String name, Type type, Object value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }
}
