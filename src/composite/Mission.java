package composite;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.List;

public class Mission extends LevelComponent{
    static int count = 0;
    List<LevelComponent> levelComponents;

    public Mission(List<LevelComponent> levelComponents){
        this.levelComponents = levelComponents;
    }

    public void displayLevelInfo(DefaultMutableTreeNode root){
        DefaultMutableTreeNode missionsNode = new DefaultMutableTreeNode("Mission " + ++count);
        root.add(missionsNode);

        for(LevelComponent objective : levelComponents){
            objective.displayLevelInfo(missionsNode);
        }
    }

    public void addLevel(LevelComponent levelComponent) {
        levelComponents.add(levelComponent);
    }
}
