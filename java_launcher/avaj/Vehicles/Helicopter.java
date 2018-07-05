/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Helicopter.java                                    :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: arangari <arangari@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/26 11:40:02 by arangari          #+#    #+#             */
/*   Updated: 2018/07/01 17:34:58 by arangari         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Vehicles;

public class Helicopter extends Aircraft implements Flyable
{
	WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	public updateConditions()
	{
		return Void;
	}

	public registerTower(WeatherTower weatherTower)
	{
		return Void;
	}


}