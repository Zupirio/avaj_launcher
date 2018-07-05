/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Tower.java                                         :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: arangari <arangari@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/27 17:44:15 by arangari          #+#    #+#             */
/*   Updated: 2018/07/03 16:03:06 by arangari         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package simulator;
import java.util.ArrayList;
import java.util.Observer;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Tower
{
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable)
	{
		try
		{
			observers.add(flyable);
		}
		catch (Exception e)
		{
			System.err.println("Failed to register Aircraft... \n");
		}
	}

	public Void unregister(Flyable flyable)
	{
		try
		{
			observers.remove(flyable);
		}
		catch (Exception e)
		{
			System.err.println("Failed to unregister Aircraft... \n");
		}
	}

	protected Void conditionsChanged()
	{
		for(int i = 0; i < observers.size(); i++)
		{
			observers.getId[i].conditionsChanged();
		}
	}
}