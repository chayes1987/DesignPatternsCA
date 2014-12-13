package composite;

public class Objective extends LevelComponent{
    String objective;
    static int count = 0;

    public Objective(String objective){
        this.objective = objective;
    }

    public String getObjective() {
        return objective;
    }

    public void displayLevelInfo(){
        System.out.println("\t\t" + ++count + " " + getObjective());
    }
}