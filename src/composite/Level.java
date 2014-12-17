package composite;

import java.util.ArrayList;
import java.util.List;

public class Level extends LevelComponent{
    List<LevelComponent> levelComponents;
    String level;
    String levelDesc;

    public Level(String level, String levelDesc, List<LevelComponent> levelComponents){
        this.levelComponents = levelComponents;
        this.level = level;
        this.levelDesc = levelDesc;
    }

    public String getLevel() { return level; }
    public String getLevelDescription() { return levelDesc; }

    public void displayLevelInfo(){
        System.out.println("Level " + getLevel() +
            "\nDescription: " + getLevelDescription());

        for(LevelComponent level : levelComponents){
            level.displayLevelInfo();
        }
    }

    public void addLevel(LevelComponent levelComponent) {
        levelComponents.add(levelComponent);
    }
}
