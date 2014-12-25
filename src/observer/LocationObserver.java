package observer;

public class LocationObserver implements IObserver{
    private double longitude, latitude;
    private ISubject playerLocation;

    public LocationObserver(ISubject playerLocation){
        this.playerLocation = playerLocation;

        playerLocation.register(this);
    }

    @Override
    public void update(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getLocation(){
        return "Main Character Position [" + longitude + ", " + latitude + "]";
    }
}
