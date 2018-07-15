package weather;

import Interface.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

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

    public void unregister(Flyable flyable)
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

    protected void conditionsChanged()
    {
        for(int i = 0; i < observers.size(); i++)
        {
            observers.get(i).updateConditions();
        }
    }
}
