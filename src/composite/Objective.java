package composite;

public class Objective extends LevelComponent{
    String objective;

    public Objective(String objective){
        this.objective = objective;
    }

    public String getObjective() {
        return objective;
    }

    public void displayLevelInfo(){
        System.out.println("\t\t" + getObjective());
    }
}