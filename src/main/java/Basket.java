import java.util.ArrayList;

public class Basket {
    ArrayList<Item> lineItems = new ArrayList<Item>();

    public void addItem(Item i)
    {
        lineItems.add(i);
    }

    public void removeItem(String itemName)
    {
        // What does remove do?
//        lineItems.remove();

        // Alternative: Iterate and string compare
        int indexToRemove = -1;
        for (int i = 0; i < lineItems.size(); i++) {
            if (itemName.equals(lineItems.get(i).name))
            {
                lineItems.get(i).quantity--;
                if (0 == lineItems.get(i).quantity){
                    indexToRemove = i;
                    break;
                }
                return;
            }
        }
        lineItems.remove(indexToRemove);
    }

    public Basket duplicate()
    {
        Basket duplicateBasket = new Basket();
        for (int i = 0; i < this.lineItems.size(); i++)
        {
            duplicateBasket.addItem(this.lineItems.get(i));
        }
        return duplicateBasket;
    }

    public double getTotalPrice()
    {
        double totalPrice = 0;
        for (int i = 0; i < this.lineItems.size(); i++)
        {
            totalPrice += (this.lineItems.get(i).price * this.lineItems.get(i).quantity);
        }
        return totalPrice;
    }
}
