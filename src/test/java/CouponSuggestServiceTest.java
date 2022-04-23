import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CouponSuggestServiceTest {
    // 10PercentDiscountCouponForSoups, try Inner Class annotation

    @Test
    void shouldSuggestCoupon() {
        Item item = new Item("Tomato Soup", "SOUP");
        BasketItem basketItem = new BasketItem(item, 5, 6);

        Basket basket = new Basket();
        basket.addItem(basketItem);

        CouponSuggestService service = new CouponSuggestService();
        Coupon coupon = service.call(basket);

        assertEquals("DELIVERICIOUS_10", coupon.getCode());
    }

    @Test
    void shouldNotSuggestAnyCoupon() {
        Basket basket = new Basket();
        CouponSuggestService service = new CouponSuggestService();

        Coupon coupon = service.call(basket);

        assertNull(coupon);
    }
}
