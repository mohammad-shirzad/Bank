package util;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Evaluator<T1, T2> {
    T1 t1;
    T2 t2;

    public Evaluator(T1 t1, T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public void compare() {
        show(getFieldsProp(t1));
        System.out.println("------------------------");
        show(getFieldsProp(t2));
        System.out.println("--------------------------");
        showDiferences(getFieldsProp(t1), getFieldsProp(t2));
    }

    public void showDiferences(List<NameTypeValue> o1, List<NameTypeValue> o2) {
        for (int i = 0; i < o1.size(); i++) {
            if (!o1.get(i).value.equals(o2.get(i).value)) {
                System.out.println("Object 1: " + o1.get(i).name + " " + o1.get(i).value);
                System.out.println("Object 2: " + o2.get(i).name + " " + o2.get(i).value);
            }
        }


    }

    public List<NameTypeValue> getFieldsProp(Object o) {
        List<NameTypeValue> fieldProp = new ArrayList();
        try {
            Field[] fields = o.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Type fieldType = field.getGenericType();
                Object fieldValue = field.get(o);
//                fieldProp.add(new NameTypeValue(fieldName, fieldType.getTypeName(), fieldValue));
            }
            return fieldProp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void show(List<NameTypeValue> data) {
        try {
            for (NameTypeValue fieldProp : data
                    ) {
                System.out.println(fieldProp.name + " " + fieldProp.type + " " + fieldProp.value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

