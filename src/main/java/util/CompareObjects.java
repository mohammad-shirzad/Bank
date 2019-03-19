package util;

import org.springframework.util.ClassUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public abstract class CompareObjects<T> implements CompareTool<T>, Comparator<T> {
    private T t;
    protected List<NameTypeValue> t1FieldsInfo = new ArrayList<>();
    protected List<NameTypeValue> t2FieldsInfo = new ArrayList<>();

    private String fieldName = "";
    private Type fieldType;
    private Object fieldValue;
    protected List<FieldValues> differences = new ArrayList<>();

    public List<FieldValues> getDifferences(T t1, T t2) {
        return null;
    }

    private void refreshfieldProp() {
        fieldName = "";
        fieldType = null;
        fieldValue = null;
    }

    private Field[] getFields(T t) {
        return t.getClass().getDeclaredFields();
    }

    public List<NameTypeValue> getFieldsInfo(Object o) {

        List<NameTypeValue> oFieldsInfo = new ArrayList<>();
        try {
            for (Field field : getFields(t)
                    ) {
                field.setAccessible(true);
                Type type = field.getGenericType();
                if (ClassUtils.isPrimitiveOrWrapper(field.getType()) || type == String.class || type == Date.class) {
                    oFieldsInfo.add(getPrimitiveOrWrapperFieldInfo(field, o));
                    refreshfieldProp();
                } else if (type instanceof ParameterizedType) {
                    ParameterizedType pType = (ParameterizedType) type;
                    Type rType = pType.getRawType();
                    Type aType = pType.getActualTypeArguments()[0];
                    Iterator subObjects = ((Iterable) (field.get(o))).iterator();
                    while (subObjects.hasNext()) {
                        Object subObject = subObjects.next();
                        Field[] subField = subObject.getClass().getDeclaredFields();
                        for (Field subEntityField : subField
                                ) {
                            subEntityField.setAccessible(true);
                            fieldName = subObject.getClass().getSimpleName();
                            if (ClassUtils.isPrimitiveOrWrapper(subEntityField.getType())) {
                                oFieldsInfo.add(getPrimitiveOrWrapperSubObjectFieldInfo(fieldName, subEntityField, subObject));
                                refreshfieldProp();
                            } else {
                                oFieldsInfo.add(getPrimitiveOrWrapperSubObjectFieldInfo(fieldName, subEntityField, subObject));
                                refreshfieldProp();
                            }
                        }
                    }
                } else {

                    try {
                        for (Field usrDefinedObjectField : ((Class) type).getDeclaredFields()) {
                            usrDefinedObjectField.setAccessible(true);
                            fieldName = field.getName();
                            oFieldsInfo.add(getSubObjectFieldInfo(fieldName, usrDefinedObjectField,
                                    usrDefinedObjectField.get(field.get(o))));
                            refreshfieldProp();
                        }
                    } catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

            return oFieldsInfo;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private NameTypeValue getPrimitiveOrWrapperFieldInfo(Field field, Object o) {
        try {
            fieldName = field.getName();
            fieldType = field.getGenericType();
            fieldValue = field.get(o);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return new NameTypeValue(fieldName, fieldType, fieldValue);
    }

    private NameTypeValue getPrimitiveOrWrapperSubObjectFieldInfo(String objectName, Field field, Object o) {
        try {
            fieldName = objectName + "." + field.getName();
            fieldType = field.getGenericType();
            fieldValue = field.get(o);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return new NameTypeValue(fieldName, fieldType, fieldValue);
    }

    private NameTypeValue getSubObjectFieldInfo(String objectName, Field field, Object o) {
        fieldName = objectName + "." + field.getName();
        fieldType = field.getGenericType();
        fieldValue = o;
        return new NameTypeValue(fieldName, fieldType, fieldValue);
    }

}
