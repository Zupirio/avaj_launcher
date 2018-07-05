/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Baloon.java                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: arangari <arangari@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/26 11:40:43 by arangari          #+#    #+#             */
/*   Updated: 2018/07/05 15:02:48 by arangari         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Vehicles;
// package Baloon;

import java.util.HashMap;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import ro.academy.avaj.simulator.*;
import ro.academy.avaj.simulator.Tower;
import simulator.WeatherTower;
import simulator.WriteFile;
import weather.Coordinates;

public class Baloon extends Aircraft implements Flyable
{
	WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	public void updateConditions()
	{
		String weatherType = this.weatherTower.getWeather(this.coordinates);
		HashMap<String, String> messageshMap = new HashMap<String, String>();
		messageshMap.put("SUN", "Fine weather in tha balloon");
		messageshMap.put("RAIN", "Brrr... Rain getting in from the sides.");
		messageshMap.put("SNOW", "Snow collecting on the top!!");
		messageshMap.put("FOG", "Can't see anything from here");

		if (messageshMap.equals("SUN"))
		{
			return coordinates.updateCoordinates(0, +2, +4);
		}
		if(messageshMap.equals("RAIN"))
		{
			return coordinates.updateCoordinates(0, 0, -5);
		}
		if(messageshMap.equals("SNOW"))
		{
			return coordinates.updateCoordinates(0, 0, -3);
		}
		if(messageshMap.equals("FOG"))
		{
			return coordinates.updateCoordinates(0, 0, -15);
		}

		WriteFile.getWriteFile().writeToFile()("Baloon#" + this.name + " (" + this.id + ")" + messageshMap.get(weatherType));
		if (this.coordinates.)
	}

	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		WriteFile.getWriteFile().writeToFile("Tower says: Baloon#" + this.name + " (" + this.id + " (" + "is registered to weather tower.");

	}
}
