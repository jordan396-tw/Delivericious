import java.util.HashMap;
import java.util.UUID;

public final class MockDataStore {
    private static MockDataStore INSTANCE;

    private final HashMap<UUID, Basket> basketStore = new HashMap<>();

    private MockDataStore() {
    }

    public static MockDataStore getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MockDataStore();
        }

        return INSTANCE;
    }

    public UUID saveBasket(Basket basket) {
        UUID uuid = UUID.randomUUID();
        basketStore.put(uuid, basket);
        return uuid;
    }

    public Basket getBasketById(UUID uuid) {
        return basketStore.get(uuid);
    }

    public int getStoreSize(String storeName) {
        switch (storeName) {
            case "baskets":
                return basketStore.size();
            default:
                return -1;
        }
    }
}
