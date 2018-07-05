/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Coordinates.java                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: arangari <arangari@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/26 17:12:21 by arangari          #+#    #+#             */
/*   Updated: 2018/07/03 16:03:38 by arangari         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package weather;
import Vehicles.Aircraft;

public class Coordinates
{
	private int	height;
	private int	longitude;
	private int	latitude;

	Coordinates(int longitude, int latitude, int height)
	{
		this.height = height;
		this.latitude = (latitude > 0) ? latitude : 0;
		this.longitude = (longitude > 0) ? longitude : 0;
	}

	public int getHeight()
	{
		return height;
	}
	public int getLongitude()
	{
		return longitude;
	}
	public int getLatitude()
	{
		return latitude;
	}

	public void updateCoordinates(int latitude, int longitude, int height)
	{
		this.latitude += latitude;
		this.longitude += longitude;
		this.height += height;
	}
}