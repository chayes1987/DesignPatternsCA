package factory;

public abstract class Vehicle {
    private String type;

    public void setType(String type) { this.type = type; }
    public String getType(){ return type; }

    public String drive(){
        return "is driving a " + this.getType();
    }

    public String shoot(){
        return "is shooting from " + this.getType();
    }

}
