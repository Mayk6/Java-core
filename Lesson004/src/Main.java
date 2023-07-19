import Enums.ProdCategories;
import Exceptions.IllegalAmountException;
import Exceptions.NoBuyerFoundException;
import Exceptions.NoItemFoundException;
import Exceptions.TooMuchSaleException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Shampoo", 120, ProdCategories.HOUSEHOLD_GOODS));
        items.add(new Item("Toothpaste", 90, ProdCategories.HOUSEHOLD_GOODS));
        items.add(new Item("Banana", 75, ProdCategories.FRUITS));

        ArrayList<Buyer> buyers = new ArrayList<>();
        buyers.add(new Buyer("Ilia", 1000));
        buyers.add(new Buyer("Sabina", 5000));

        Shop shop = new Shop(items, buyers);
        try {

            Order order1 = shop.deal("Ilia", "Shampoo", 1);
            order1.addItemInOrder(new Item("Biscod", 400, ProdCategories.VEGETABLES), 3);

            shop.deal("Ilia", "Banana", 1);
            try {
                order1.calculateDiscountPrice(ProdCategories.VEGETABLES, ProdCategories.HOUSEHOLD_GOODS, ProdCategories.FRUITS);
                System.out.println(order1.getDiscountPrice());
            } catch (TooMuchSaleException e){
                System.out.println(e.getMessage());
                System.out.println(order1.getDiscountPrice());
            }

            System.out.println(order1.getTotalPrice());
            shop.deal("Sabina", "Toothpaste", 1);
        } catch (NoBuyerFoundException e) {
            e.printStackTrace();
        } catch (NoItemFoundException e) {
            e.printStackTrace();
        } catch (IllegalAmountException e) {
            e.printStackTrace();
        }

        System.out.println("-------------");
        System.out.println("Total deals: " + Order.getCounter());
    }


}