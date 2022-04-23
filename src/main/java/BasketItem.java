import lombok.Getter;
import lombok.Setter;

/*
 * Represents a Item added into a Basket.
 */
public class BasketItem {
    private final Item item;

    public int price;

    @Getter
    @Setter
    private int quantity;

    public BasketItem(Item item, int price, int quantity) {
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }
}
