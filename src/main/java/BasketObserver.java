import java.util.Observable;
import java.util.Observer;

public class BasketObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Basket basket = (Basket) arg;
    }
}
