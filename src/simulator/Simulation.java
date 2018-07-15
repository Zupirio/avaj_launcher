package simulator;

import Interface.Flyable;
import vehicles.AircraftFactory;
import weather.WeatherTower;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//Asa
public class Simulation {

    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line =  reader.readLine();
            if (line != null)
            {
                weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations < 0)
                {
                    System.out.println("Invalid simulation count" + simulations);
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null)
                {
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ") [1],
                            Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));
                    if (flyable != null)
                        flyables.add(flyable);
                }
                for (Flyable flyable : flyables)
                {
                    flyable.registerTower(weatherTower);
                }
                for (int i = 1; i <= simulations; i++)
                {
                    weatherTower.changeWeather();
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Couldn't find file " + args[0]);
        }
        catch (IOException e)
        {
            System.out.println("There was an error while reading the file " + args[0]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Specify simulation file");
        }
        finally
        {
            WriteFile.getWriteFile().close();
            System.out.println("scanner closed\n");
        }
    }
}
