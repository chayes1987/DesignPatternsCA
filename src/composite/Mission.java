package composite;

import java.util.ArrayList;
import java.util.List;

public class Mission extends LevelComponent{
    static int count = 0;
    List<LevelComponent> levelComponents;

    public Mission(){
        this.levelComponents = new ArrayList<LevelComponent>();
    }

    public void displayLevelInfo(){
        System.out.println("\tMission " + ++count +
            "\n\tMission Objectives: ");

        for(LevelComponent objective : levelComponents){
            objective.displayLevelInfo();
        }
    }

    public void addLevel(LevelComponent levelComponent) {
        levelComponents.add(levelComponent);
    }
}
