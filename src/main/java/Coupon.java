public class Coupon {
    private final String code;
    private final double percentDiscount;

    public Coupon(String code, double percentDiscount) {
        this.code = code;
        this.percentDiscount = percentDiscount;
    }

    public String getCode() {
        return code;
    }
}
