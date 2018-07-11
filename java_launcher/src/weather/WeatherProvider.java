/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   WeatherProvider.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: arangari <arangari@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/26 17:12:37 by arangari          #+#    #+#             */
/*   Updated: 2018/07/03 16:03:48 by arangari         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package weather;

public class WeatherProvider
{
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static string[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider()
	{}

	public static WeatherProvider getProvider()
	{
		return WeatherProvider.weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates)
	{
		int	weatherOption = 0;
		if (coordinates.getLatitude() > 23)
		weatherOption++;
		if (coordinates.getLongitude() > 30)
		weatherOption++;
		if (coordinates.getHeight() > 20)
			weatherOption++;
		return weather[weatherOption];
	}
}
