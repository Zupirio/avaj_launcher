/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Baloon.java                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: arangari <arangari@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/26 11:40:43 by arangari          #+#    #+#             */
/*   Updated: 2018/07/10 18:26:17 by arangari         ###   ########.fr       */
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
			this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
		}
		if(messageshMap.equals("RAIN"))
		{
			this.coordinates = new Coordinates(coordinates.getLongitude() + 0, coordinates.getLatitude() + 0, coordinates.getHeight() -5);
		}
		if(messageshMap.equals("SNOW"))
		{
			this.coordinates = new Coordinates(coordinates.getLongitude() + 0, coordinates.getLatitude() + 0, coordinates.getHeight() -3);
		}
		if(messageshMap.equals("FOG"))
		{
			this.coordinates = new Coordinates(coordinates.getLongitude() + 0, coordinates.getLatitude() + 0, coordinates.getHeight() -15);
		}

		WriteFile.getWriteFile().writeToFile("Baloon#" + this.name + " (" + this.id + ")" + messageshMap.get(weatherType));
		if (this.coordinates.getHeight() == 0)
		{
				WriteFile.getWriteFile().writeToFile("Baloon#" + this.name + " (" + this.id + "): landing. ");
				this.weatherTower.unregister(this);
				WriteFile.getWriteFile().writeToFile("Baloon#" + this.name + " (" + this.id + ")" + "Says unregistered from Tower.");

		}
	}

	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		WriteFile.getWriteFile().writeToFile("Tower says: Baloon#" + this.name + " (" + this.id + " )" + "is registered to weather tower.");

	}
}
