package weather;

import vehicles.Coordinates;

public class WeatherProvider
{
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider()
    {}

    public static WeatherProvider getProvider()
    {
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        int	weatherOption = 0;
        if (coordinates.getLatitude() > 23)
            weatherOption++;
        if (coordinates.getLongitude() > 30)
            weatherOption++;
        if (coordinates.getHeight() > 20)
            weatherOption++;
        return weather[weatherOption];
    }
}
