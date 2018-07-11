/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   JetPlane.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: arangari <arangari@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/26 11:40:22 by arangari          #+#    #+#             */
/*   Updated: 2018/07/10 18:34:49 by arangari         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Vehicles;

import simulator.WeatherTower;
import simulator.WriteFile;
import weather.Coordinates;

import java.util.HashMap;

public class JetPlane extends Aircraft implements Flyable
{
	WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	public void updateConditions()
	{
		String weatherType = this.weatherTower.getWeather(this.coordinates);
		HashMap<String, String> messageshMap = new HashMap<String, String>();
		messageshMap.put("SUN", "Fine weather in tha JetPlane");
		messageshMap.put("RAIN", "Flying through this rain like I'm slice man .");
		messageshMap.put("SNOW", "Got snow as my dust!!");
		messageshMap.put("FOG", "Totally need sonic vision to see through this.");

		if (messageshMap.equals("SUN"))
		{
			this.coordinates = new Coordinates(coordinates.getLongitude() + 0, coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
		}
		if(messageshMap.equals("RAIN"))
		{
			this.coordinates = new Coordinates(coordinates.getLongitude() + 0, coordinates.getLatitude() + 5, coordinates.getHeight() + 0);
		}
		if(messageshMap.equals("SNOW"))
		{
			this.coordinates = new Coordinates(coordinates.getLongitude() + 0, coordinates.getLatitude() + 1, coordinates.getHeight() + 0);
		}
		if(messageshMap.equals("FOG"))
		{
			this.coordinates = new Coordinates(coordinates.getLongitude() + 0, coordinates.getLatitude() + 0, coordinates.getHeight() -7);
		}

		WriteFile.getWriteFile().writeToFile("JetPlane#" + this.name + " (" + this.id + ")" + messageshMap.get(weatherType));
		if (this.coordinates.getHeight() == 0)
		{
				WriteFile.getWriteFile().writeToFile("JetPlane#" + this.name + " (" + this.id + "): landing. ");
				this.weatherTower.unregister(this);
				WriteFile.getWriteFile().writeToFile("JetPlane#" + this.name + " (" + this.id + ")" + "Says unregistered from Tower.");

		}
	}

	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		WriteFile.getWriteFile().writeToFile("Tower says: JetPlane#" + this.name + " (" + this.id + " )" + "is registered to weather tower.");

	}
}
