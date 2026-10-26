package observers;

import java.util.ArrayList;
import java.util.List;

public class EventBus {
    private static final EventBus bus = new EventBus();
    private final List<Observer> observers = new ArrayList<>();

    private EventBus() {

    }

    public static EventBus getBus() {
        return bus;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void updateEventBus() {
        return;
    }

    public void updateObservers(Context context) {
        for (Observer observer: observers) {
            observer.update(context);
        }
    }
}
