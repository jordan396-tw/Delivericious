import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BasketTest {
    @Test
    void testAddItemToBasket() {
        // Arrange
        Basket basket = new Basket();
        Item tomatoSoupItem = new Item("tomato soup");

        // Act
        basket.addItem(tomatoSoupItem);

        // Assert
        assertEquals(1, basket.lineItems.size());
        assertEquals("tomato soup", basket.lineItems.get(0).name);
    }

    @Test
    void testAddItemWithPricesToBasket() {
        // Arrange
        Basket basket = new Basket();
        Item seafoodSaladItem = new Item("Seafood salad", 12);

        // Act
        basket.addItem(seafoodSaladItem);

        // Assert
        assertEquals(1, basket.lineItems.size());
        assertEquals("Seafood salad", basket.lineItems.get(0).name);
        assertEquals(12, basket.lineItems.get(0).price);
    }

    @Test
    void testAddItemWithQuantityWithPricesToBasket() {
        Basket basket = new Basket();
        Item icecreamItem = new Item("Icecream", 4, 3);

        basket.addItem(icecreamItem);

        assertEquals(1, basket.lineItems.size());
        assertEquals("Icecream", basket.lineItems.get(0).name);
        assertEquals(4, basket.lineItems.get(0).price);
    }

    @Test
    void testRemoveItemFromBasketWithQuantityGreaterThanOne() {
        Basket basket = new Basket();
        Item icecreamItem = new Item("Icecream", 4, 3);

        basket.addItem(icecreamItem);

        basket.removeItem("Icecream");

        assertEquals(1, basket.lineItems.size());
        assertEquals("Icecream", basket.lineItems.get(0).name);
        assertEquals(2, basket.lineItems.get(0).quantity);
    }

    @Test
    void testRemoveItemFromBasketWithQuantityEqualToOne() {
        Basket basket = new Basket();
        Item icecreamItem = new Item("Icecream", 4, 1);

        basket.addItem(icecreamItem);

        basket.removeItem("Icecream");

        assertEquals(0, basket.lineItems.size());
    }

    @Test
    void duplicateBasket() {
        Basket basket = new Basket();
        Item icecreamItem = new Item("Icecream", 4, 1);
        Item seafoodSaladItem = new Item("Seafood salad", 12);

        basket.addItem(seafoodSaladItem);
        basket.addItem(icecreamItem);
        Basket duplicateBasket = basket.duplicate();

        assertTrue(duplicateBasket.lineItems.containsAll(basket.lineItems));
    }

    @Test
    void getTotalPrice() {
        Basket basket = new Basket();
        Item icecreamItem = new Item("Icecream", 4, 1);
        Item seafoodSaladItem = new Item("Seafood salad", 12, 3);

        basket.addItem(seafoodSaladItem);
        basket.addItem(icecreamItem);

        double totalPrice = basket.getTotalPrice();

        assertEquals(40, totalPrice);
    }
}
