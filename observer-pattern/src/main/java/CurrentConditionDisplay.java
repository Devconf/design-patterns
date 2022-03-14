import DisplayElement.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Observable observable;

    public CurrentConditionDisplay(Observable observable){
        this.observable =observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: "+ this.temperature + "F degrees and " + this.humidity + "% humidity");
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData)o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
