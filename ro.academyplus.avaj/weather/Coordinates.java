/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Coordinates.java                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: arangari <arangari@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/26 17:12:21 by arangari          #+#    #+#             */
/*   Updated: 2018/06/27 17:38:30 by arangari         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */


public class Coordinates
{
	private int	height;
	private int	longitude;
	private int	latitude;

	Coordinates(int longitude, int latitude, int height)
	{
		this.height = height;
		this.latitude = latitude;
		this.longitude = longitude;

	}

	public	getHeight()
	{
	return height;
	}
	public	getLongitude()
	{
		return longitude;
	}
	public	getLatitude()
	{
		return latitude;
	}

}