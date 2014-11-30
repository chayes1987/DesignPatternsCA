package factory;

public abstract class Vehicle implements IVehicle {
    private String type;

    public void setType(String type) { this.type = type; }
    public String getType(){ return type; }

    @Override
    public String drive(){
        return "is driving a " + this.getType();
    }

    @Override
    public String shoot(){
        return "is shooting from " + this.getType();
    }

}
