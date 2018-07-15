package vehicles;

public class Aircraft {
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
