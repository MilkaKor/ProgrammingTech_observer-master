package ObserverComponents;

public interface Observable {
    //List<IObserver> observers = new ArrayList<>();
    public void notifyAllObserver();
    public void attach(Observer obs);
    public void detach(Observer obs);
}

