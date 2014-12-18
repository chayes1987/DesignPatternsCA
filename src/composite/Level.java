package composite;

import javax.swing.tree.DefaultMutableTreeNode;
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

    public void displayLevelInfo(DefaultMutableTreeNode root){
        DefaultMutableTreeNode levelsNode = new DefaultMutableTreeNode("Level " + getLevel() + " | " + getLevelDescription());
        root.add(levelsNode);

        for(LevelComponent level : levelComponents) {
            level.displayLevelInfo(levelsNode);
        }
    }

    public void addLevel(LevelComponent levelComponent) {
        levelComponents.add(levelComponent);
    }
}
