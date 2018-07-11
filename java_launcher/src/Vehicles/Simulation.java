/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Simulation.java                                    :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: arangari <arangari@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/29 10:24:20 by arangari          #+#    #+#             */
/*   Updated: 2018/07/03 11:18:05 by arangari         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Vehicles;

import simulator.*;
import weather.*;

import java.io.*;
import java.util.*;


/**
 * Simulation
 */
public class Simulation
{
	private static WeatherTower weatherTower;
	private static List<Flyable> flyables = new ArrayList<>();

	private static void main(String[] args) throws InterruptedException
	{
		AircraftFactory aircraftFactory = new AircraftFactory(); //
		Flyable aircraft = null; //
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
				while (line = reader.readLine() != null)
				{
					Flyable flyable = Aircraft.newAircraft(line.split(" ")[0], line.split(" ") [1],
							Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
							Integer.parseInt(line.split(" ")[4]));
					flyable.add(flyable);
				}
				for (flyables flyable : flyables)
				{
					flyables.registerTower(weatherTower);
				}
				for (int i = 1; 1 <= simulations; i++)
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