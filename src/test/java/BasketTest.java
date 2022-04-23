import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


public class BasketTest {
    @Test
    void testAddItemWithQuantityWithPricesToBasket() {
        Basket basket = new Basket();
        Item item = new Item("Icecream", "Ice Cream");
        BasketItem basketItem = new BasketItem(item, 4, 3);

        basket.addItem(basketItem);

        assertEquals(1, basket.lineItems.size());
        assertEquals("Icecream", basket.lineItems.get(0).getItem().name);
        assertEquals(4, basket.lineItems.get(0).price);
    }

    @Test
    void testRemoveItemFromBasketWithQuantityGreaterThanOne() {
        Basket basket = new Basket();
        Item item = new Item("Icecream", "Ice Cream");
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
        Item item = new Item("Icecream", "Ice Cream");
        BasketItem basketItem = new BasketItem(item, 4, 1);

        basket.addItem(basketItem);

        basket.removeItem("Icecream");

        assertEquals(0, basket.lineItems.size());
    }

    @Test
    void duplicateBasket() {
        Basket basket = new Basket();
        Item icecreamItem = new Item("Icecream", "Ice Cream");
        Item seafoodSaladItem = new Item("Seafood salad", "Salad");
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
        Item icecreamItem = new Item("Icecream", "Ice Cream");
        Item seafoodSaladItem = new Item("Seafood salad", "Salad");
        BasketItem icecreamBasketItem = new BasketItem(icecreamItem, 4, 1);
        BasketItem seafoodSaladbasketItem = new BasketItem(seafoodSaladItem, 12, 3);

        basket.addItem(icecreamBasketItem);
        basket.addItem(seafoodSaladbasketItem);

        double totalPrice = basket.getTotalPrice();

        assertEquals(40, totalPrice);
    }

    @Test
    void basketCanBeSaved() {
        InMemoryBasketRepository repository = InMemoryBasketRepository.getInstance();
        Basket basket = new Basket();

        Item item = new Item("Expensive Mineral Water", "Water");
        BasketItem basketItem = new BasketItem(item, 30, 1);
        basket.addItem(basketItem);

        UUID uuid = repository.save(basket);

        assertEquals(1, repository.getSize());
        assertNotNull(repository.get(uuid));
        assertEquals(basket, repository.get(uuid));
    }
}
