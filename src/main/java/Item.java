public class Item {
    public String name;
    public int price;
    public int quantity;

    public Item(String name){
        this.name = name;
    }

    public Item(String name, int price){
        this.name = name;
        this.price = price;
    }

    public Item(String name, int price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
