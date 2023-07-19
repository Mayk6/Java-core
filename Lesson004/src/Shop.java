import Enums.Discounts;
import Enums.ProdCategories;
import Exceptions.IllegalAmountException;
import Exceptions.NoBuyerFoundException;
import Exceptions.NoItemFoundException;

import java.util.ArrayList;
import java.util.Random;

public class Shop {

    final ArrayList<Item> stock;
    final ArrayList<Buyer> customers;

    public Shop(ArrayList<Item> stock, ArrayList<Buyer> customers) {
        this.stock = stock;
        this.customers = customers;
    }

    public Order deal(String buyerName, String item, int amount) throws NoBuyerFoundException, NoItemFoundException, IllegalAmountException {

        if (amount <= 0) {
            throw new IllegalAmountException("Amount is: " + amount + "\nExpected > 0");
        }
        Buyer tempBuyer = null;
        Item tempItem = null;

        for (int i = 0; i < customers.size(); i++) {
            if (buyerName.equals(customers.get(i).getName())) {
                tempBuyer = customers.get(i);
                break;
            }
        }
        if (tempBuyer == null) {
            throw new NoBuyerFoundException("No such Buyer found");
        }
        for (int i = 0; i < stock.size(); i++) {
            if (item.equals(stock.get(i).getName())) {
                tempItem = stock.get(i);
                break;
            }
        }
        if (tempItem == null) {
            throw new NoItemFoundException("Shop doesn't have " + item);
        }
        return new Order(tempBuyer, tempItem, amount);
    }


}
