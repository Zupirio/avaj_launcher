/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   JetPlane.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: arangari <arangari@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/26 11:40:22 by arangari          #+#    #+#             */
/*   Updated: 2018/06/27 18:13:03 by arangari         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Vehicles;


public class JetPlane extends Aircraft implements Flyable
{
	WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates)
	{}

	public void updateConditions()
	{

	}

	public void registerTower(WeatherTower weatherTower)
	{

	}
}