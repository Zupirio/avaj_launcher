package Vehicles;/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Flyable.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: arangari <arangari@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/26 17:08:23 by arangari          #+#    #+#             */
/*   Updated: 2018/07/02 14:28:55 by arangari         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

// package	ro.academy.avaj.simulator.Vehicles;

import simulator.WeatherTower;

public interface Flyable
{
	public void updateConditions();
	public void registerTower(WeatherTower WeatherTower);
}
