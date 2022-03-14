public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurements(97,60,10);
        weatherData.setMeasurements(74,40,10);
        weatherData.setMeasurements(89,20,10);
    }
}