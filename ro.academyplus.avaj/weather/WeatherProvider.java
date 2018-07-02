/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   WeatherProvider.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: arangari <arangari@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/26 17:12:37 by arangari          #+#    #+#             */
/*   Updated: 2018/07/02 17:35:32 by arangari         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

// package ro.academy.avaj.weather;

public class WeatherProvider
{
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static string[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider()
	{}

	public static WeatherProvider getProvider()
	{
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates)
	{
		int	weatherOption = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
		return weather[weatherOption % 4];
	}
}