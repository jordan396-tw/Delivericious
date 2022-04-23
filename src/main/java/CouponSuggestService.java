import java.util.List;

public class CouponSuggestService {
    public Coupon call(Basket basket) {
        int quantityOfSoup = basket.getLineItems()
                .stream()
                .filter(basketItem -> basketItem.getItem().getCategory().equals("SOUP"))
                .map(basketItem -> basketItem.getQuantity())
                .reduce(0, Integer::sum);

        if (quantityOfSoup > 5) {
            return getAvailableCoupons().get(0);
        }

        return null;
    }

    private List<Coupon> getAvailableCoupons() {
        // refactor: coupons should be retrieved from a Coupon Repository?
        return List.of(
                new Coupon("DELIVERICIOUS_10", 10)
        );
    }
}
