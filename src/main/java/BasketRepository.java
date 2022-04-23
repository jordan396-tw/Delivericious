import java.util.HashMap;
import java.util.UUID;

public final class BasketRepository {
    private static BasketRepository INSTANCE;

    private final HashMap<UUID, Basket> basketStore = new HashMap<>();

    private BasketRepository() {
    }

    public static BasketRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BasketRepository();
        }

        return INSTANCE;
    }

    public UUID save(Basket basket) {
        UUID uuid = UUID.randomUUID();
        basketStore.put(uuid, basket);
        return uuid;
    }

    public Basket get(UUID uuid) {
        return basketStore.get(uuid);
    }

    public int getSize() {
        return basketStore.size();
    }
}
