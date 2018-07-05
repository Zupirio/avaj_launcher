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

package ro.academy.avaj.simulator;

import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;
import java.lang.Object;

import javax.naming.RefAddr;

import com.sun.javafx.iio.ios.IosDescriptor;
import com.sun.javafx.image.IntPixelGetter;
import com.sun.javafx.print.PrintAccessor;

import Simulator.WeatherTower;
import Vehicles.Aircraft;
import Vehicles.AircraftFactory;
import Vehicles.Flyable;
import jdk.nashorn.internal.ir.CatchNode;
import ro.academyplus.avaj.weather.Coordinates;


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
			BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
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
			System.out.println("Couldn't find file " + arg[0]);
		}
		catch (IOException e)
		{
			System.out.println("There was an error while reading the file " + arg[0]);
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Specify simulation file");
		}
		finally
		{
			Logger.getLogger("msg").clone();
		}
	}
}