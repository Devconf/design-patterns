import Observer.Observer;
import Subject.Subject;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private final ArrayList<Observer> observers;

    private float temperature;

    private float humidity;

    private float pressure;

    public WeatherData(){
        this.observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i= observers.indexOf(o);

        if(i>0){
            this.observers.remove(i);
        }
    }

    @Override
    public void notifyObserve() {
        for(int i=0;i<observers.size();i++){
            Observer observer = this.observers.get(i);
            observer.update(this.temperature, this.humidity, this.pressure);
        }
    }

    public void measurementsChanged(){
        notifyObserve();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature= temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementsChanged();
    }
}