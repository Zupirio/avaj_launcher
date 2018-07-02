/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Aircraft.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: arangari <arangari@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/26 11:50:42 by arangari          #+#    #+#             */
/*   Updated: 2018/07/02 08:30:40 by arangari         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Vehicles;

public class Aircraft
{
	protected long id;
	protected string name;
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

/*
	This class handles the aircraft and weather simulation
 */