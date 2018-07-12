package vehicles;

import Interface.Flyable;
import simulator.WriteFile;
import weather.WeatherTower;

import java.util.HashMap;

public class Helicopter extends Aircraft implements Flyable {

    WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weatherType = this.weatherTower.getWeather(this.coordinates);
        HashMap<String, String> messageshMap = new HashMap<String, String>();
        messageshMap.put("SUN", "Fine weather in tha Helicopter");
        messageshMap.put("RAIN", "Brrr... Slashing the rain with my blades.");
        messageshMap.put("SNOW", "Aint no snow that can touch me!!");
        messageshMap.put("FOG", "Fog and copter dont go together");

        if (messageshMap.equals("SUN"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude() + 0, coordinates.getHeight() + 2);
        }
        if(messageshMap.equals("RAIN"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude() + 0, coordinates.getHeight() + 0);
        }
        if(messageshMap.equals("SNOW"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude() + 0, coordinates.getHeight() + 0);
        }
        if(messageshMap.equals("FOG"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 0, coordinates.getLatitude() + 0, coordinates.getHeight() -12);
        }

        WriteFile.getWriteFile().writeToFile("Helicopter#" + this.name + " (" + this.id + ")" + messageshMap.get(weatherType));
        if (this.coordinates.getHeight() == 0)
        {
            WriteFile.getWriteFile().writeToFile("Helicopter#" + this.name + " (" + this.id + "): landing. ");
            this.weatherTower.unregister(this);
            WriteFile.getWriteFile().writeToFile("Helicopter#" + this.name + " (" + this.id + ")" + "Says unregistered from Tower.");

        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        WriteFile.getWriteFile().writeToFile("Tower says: Helicopter#" + this.name + " (" + this.id + ") " + " (" + "is registered to tower.)" );
    }

}
