package Enums;

public enum Discounts {
    ZERO(0), FIVE(5), TEN(10), FIFTEEN(15), TWENTY(20);

    public final int count;

    Discounts(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
