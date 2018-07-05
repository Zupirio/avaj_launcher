/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   AircraftFactory.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: arangari <arangari@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/26 11:41:07 by arangari          #+#    #+#             */
/*   Updated: 2018/06/29 15:30:00 by arangari         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Vehicles;

import javax.lang.model.util.ElementScanner6;
import ro.academyplus.avaj.weather.Coordinates;

public class AircraftFactory
{
	public static Flyable Aircraft(String type, String name, int longitude,  int latitude, int height)
	{
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		if (type.equals("Helicopter"))
		{
			return new Helicopter(name, coordinates);
		}
		else if (type.equals("Jetplane"))
		{
			return new JetPlane(name, coordinates);
		}
		else if (type.equals("Baloon"))
		{
			return new Baloon(name, coordinates);
		}
		else
		{
			return null;
		}
	}
}