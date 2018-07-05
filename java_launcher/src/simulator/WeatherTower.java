/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   WeatherTower.java                                  :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: arangari <arangari@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/27 09:17:49 by arangari          #+#    #+#             */
/*   Updated: 2018/07/03 16:03:31 by arangari         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package simulator;

import weather.Coordinates;

public class WeatherTower extends Tower
{
	public String getWeather(Coordinates coordinates)
	{
		return coordinates;
	}

	public void changeWeather()
	{

	}
}