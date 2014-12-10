package composite;

import java.util.ArrayList;
import java.util.List;

public class Mission extends LevelComponent{
    int missionNo;
    List<LevelComponent> levelComponents;

    public Mission(int missionNo){
        this.missionNo = missionNo;
        this.levelComponents = new ArrayList<LevelComponent>();
    }

    public int getMissionNo() {
        return missionNo;
    }

    public void displayLevelInfo(){
        System.out.println("\tMission " + getMissionNo() +
            "\n\tMission Objectives: ");

        for(LevelComponent objective : levelComponents){
            objective.displayLevelInfo();
        }
    }

    public void addLevel(LevelComponent levelComponent) {
        levelComponents.add(levelComponent);
    }
}
