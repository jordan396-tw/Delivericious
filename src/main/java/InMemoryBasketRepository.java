import java.util.HashMap;
import java.util.UUID;

public final class InMemoryBasketRepository implements BasketRepository {
    private static InMemoryBasketRepository INSTANCE;

    private final HashMap<UUID, Basket> basketStore = new HashMap<>();

    private InMemoryBasketRepository() {
    }

    public static InMemoryBasketRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InMemoryBasketRepository();
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
