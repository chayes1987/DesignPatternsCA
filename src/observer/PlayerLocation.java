package observer;

import java.util.List;

public class PlayerLocation implements ISubject{
    private List<IObserver> observers;
    private double longitude, latitude;

    public PlayerLocation(List<IObserver> observers){
        this.observers = observers;
    }

    @Override
    public void register(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(IObserver observer : observers){
            observer.update(longitude, latitude);
        }
    }

    public void setLongitude(double longitude){
        this.longitude = longitude;
        notifyObservers();
    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
        notifyObservers();
    }
}
