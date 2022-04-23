/*
 * Represents an Item added into a Basket.
 */
public class BasketItem {
    private final Item item;

    public int price;

    private int quantity;

    public BasketItem(Item item, int price, int quantity) {
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }
}
