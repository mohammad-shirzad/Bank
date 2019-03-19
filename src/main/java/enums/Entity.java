package enums;

public enum Entity {
    Customer(1);
    private final int number;

    Entity(int number) {
        this.number = number;
    }

    public int getCode() {
        return number;
    }
}
