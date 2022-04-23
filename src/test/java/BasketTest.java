import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class BasketTest {
    @Test
    void testAddItemWithQuantityWithPricesToBasket() {
        Basket basket = new Basket();
        Item item = new Item("Icecream");
        BasketItem basketItem = new BasketItem(item, 4, 3);

        basket.addItem(basketItem);

        assertEquals(1, basket.lineItems.size());
        assertEquals("Icecream", basket.lineItems.get(0).getItem().name);
        assertEquals(4, basket.lineItems.get(0).price);
    }

    @Test
    void testRemoveItemFromBasketWithQuantityGreaterThanOne() {
        Basket basket = new Basket();
        Item item = new Item("Icecream");
        BasketItem basketItem = new BasketItem(item, 4, 3);

        basket.addItem(basketItem);

        basket.removeItem("Icecream");

        assertEquals(1, basket.lineItems.size());
        assertEquals("Icecream", basket.lineItems.get(0).getItem().name);
        assertEquals(2, basket.lineItems.get(0).getQuantity());
    }

    @Test
    void testRemoveItemFromBasketWithQuantityEqualToOne() {
        Basket basket = new Basket();
        Item item = new Item("Icecream");
        BasketItem basketItem = new BasketItem(item, 4, 1);

        basket.addItem(basketItem);

        basket.removeItem("Icecream");

        assertEquals(0, basket.lineItems.size());
    }

    @Test
    void duplicateBasket() {
        Basket basket = new Basket();
        Item icecreamItem = new Item("Icecream");
        Item seafoodSaladItem = new Item("Seafood salad");
        BasketItem icecreamBasketItem = new BasketItem(icecreamItem, 4, 1);
        BasketItem seafoodSaladbasketItem = new BasketItem(seafoodSaladItem, 12, 1);

        basket.addItem(icecreamBasketItem);
        basket.addItem(seafoodSaladbasketItem);
        Basket duplicateBasket = basket.duplicate();

        assertTrue(duplicateBasket.lineItems.containsAll(basket.lineItems));
    }

    @Test
    void getTotalPrice() {
        Basket basket = new Basket();
        Item icecreamItem = new Item("Icecream");
        Item seafoodSaladItem = new Item("Seafood salad");
        BasketItem icecreamBasketItem = new BasketItem(icecreamItem, 4, 1);
        BasketItem seafoodSaladbasketItem = new BasketItem(seafoodSaladItem, 12, 3);

        basket.addItem(icecreamBasketItem);
        basket.addItem(seafoodSaladbasketItem);

        double totalPrice = basket.getTotalPrice();

        assertEquals(40, totalPrice);
    }

    @Test
    void basketCanBeSaved() {
        MockDataStore dataStore = MockDataStore.getInstance();
        Basket basket = new Basket();

        Item item = new Item("Expensive Mineral Water");
        BasketItem basketItem = new BasketItem(item, 30, 1);
        basket.addItem(basketItem);

        UUID uuid = dataStore.saveBasket(basket);

        assertEquals(1, dataStore.getStoreSize("baskets"));
        assertNotNull(dataStore.getBasketById(uuid));
        assertEquals(basket, dataStore.getBasketById(uuid));
    }
}
