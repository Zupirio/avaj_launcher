/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Aircraft.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: arangari <arangari@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/26 11:50:42 by arangari          #+#    #+#             */
/*   Updated: 2018/07/02 11:32:16 by arangari         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Vehicles;

import weather.Coordinates;

public class Aircraft
{
	public long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter = 1;

	protected Aircraft(String name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();
	}

	private long nextId()
	{
		Aircraft.idCounter += 1;
		return (Aircraft.idCounter);
	}
}

/*c
	This class handles the aircraft and weather simulation
 */