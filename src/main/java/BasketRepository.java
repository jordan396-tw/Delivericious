import java.util.UUID;

public interface BasketRepository {
    UUID save(Basket basket);

    Basket get(UUID uuid);

    int getSize();
}
