import java.util.ArrayList;

public class Basket {
    ArrayList<BasketItem> lineItems = new ArrayList<BasketItem>();

    public void addItem(BasketItem bi) {
        lineItems.add(bi);
    }

    public void removeItem(String itemName) {
        // What does remove do?
//        lineItems.remove();

        // Alternative: Iterate and string compare
        int indexToRemove = -1;

        for (int i = 0; i < lineItems.size(); i++) {
            if (itemName.equals(lineItems.get(i).getItem().name)) {
                BasketItem basketItem = lineItems.get(i);
                basketItem.setQuantity(basketItem.getQuantity() - 1);

                if (0 == basketItem.getQuantity()) {
                    indexToRemove = i;
                    break;
                }
                return;
            }
        }
        lineItems.remove(indexToRemove);
    }

    public Basket duplicate() {
        Basket duplicateBasket = new Basket();
        for (int i = 0; i < this.lineItems.size(); i++) {
            duplicateBasket.addItem(this.lineItems.get(i));
        }
        return duplicateBasket;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < this.lineItems.size(); i++) {
            totalPrice += (this.lineItems.get(i).getPrice() * this.lineItems.get(i).getQuantity());
        }
        return totalPrice;
    }
}
