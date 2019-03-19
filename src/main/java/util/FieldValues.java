package util;

public class FieldValues {
    String field;
    Object oldValue;
    Object newValue;

    public FieldValues(String field, Object oldValue, Object newValue) {
        this.field = field;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }
}
