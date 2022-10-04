package design.strategy;

import java.util.ArrayList;
import java.util.List;

interface PaymentStrategy{
    public void pay(int amount);
}

class KAKAOCardStrategy implements PaymentStrategy{
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public KAKAOCardStrategy(String name, String cardNumber, String cvv, String dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using KAKAOCard");
    }
}

class LUNACardStrategy implements PaymentStrategy{

    private String emailId;
    private String paswword;

    public LUNACardStrategy(String emailId, String paswword) {
        this.emailId = emailId;
        this.paswword = paswword;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using LUNACard");
    }
}

class Item{
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class ShoppingCart{

    List<Item> items;

    public ShoppingCart(){
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public int calculateTotal(){
        int sum = 0;

        for(Item item : items){
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentMethod){
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }
}

public class HelloWorld {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        Item A = new Item("kundoLA", 100);
        Item B = new Item("kundoLB", 300);

        cart.addItem(A);
        cart.addItem(B);

        cart.pay(new LUNACardStrategy("kundol@Example.com", "pukubababo"));
        cart.pay(new KAKAOCardStrategy("이름","123","134","12/01"));


    }
}
