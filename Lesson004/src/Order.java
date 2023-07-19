import Enums.Discounts;
import Enums.ProdCategories;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/*
Задача: Эмуляция интернет-магазина
написать классы покупатель, товар и заказ;
создать массив покупателей, массив товаров и массив заказов;
создать статический метод “совершить покупку” со строковыми параметрами, соответствующими полям объекта заказа. Метод должен вернуть объект заказа
Если в метод передан несуществующий покупатель, товар или отрицательное количество, метод должен выбросить соответствующее исключение;
Вызвать метод совершения покупки несколько раз таким образом, чтобы заполнить массив покупок возвращаемыми значениями. Обработать исключения.
Вывести в консоль итоговое количество совершённых покупок после выполнения приложения.

 */
public class Order {
    private Buyer buyer;
    private final HashMap<Item, Integer> items = new HashMap<>();
    private double totalPrice;
    private double discountPrice;

    public double getDiscountPrice(ProdCategories... categories) {
        Random random = new Random();
        int rand = random.nextInt(0, Discounts.values().length);
        Discounts discount = Discounts.values()[rand];

        if (categories.length * discount.getCount() > 50) {
            System.out.println("Сумма скидок не может привышать 50 процентов, применена скидка 20% на весь чек");
            return getTotalPrice() - (getTotalPrice() / 100 * 20);
        }

        for (Item item : items.keySet()
        ) {
            if (Arrays.stream(categories).anyMatch(i -> i.equals(item.getCategories()))) {
                double sales1 = ((item.getPrice() / 100) * discount.getCount()) * items.get(item);
                discountPrice += item.getPrice() * items.get(item) - sales1;
            } else {
                discountPrice += item.getPrice() * items.get(item);
            }
        }
        return discountPrice;
    }


    private static int counter;

    public Order(Buyer buyer, Item item, int amountItems) {
        this.buyer = buyer;
        items.put(item, amountItems);
        counter++;
    }

    public HashMap<Item, Integer> getItems() {
        return items;
    }

    public void addItemInOrder(Item item, int count) {
        items.put(item, count);
    }

    public static int getCounter() {
        return counter;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public double getTotalPrice() {
        for (Item item : items.keySet()
        ) {
            totalPrice += item.getPrice() * items.get(item);
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "buyer=" + buyer +
                '}';
    }
}
