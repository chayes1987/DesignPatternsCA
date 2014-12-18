package composite;

import javax.swing.tree.DefaultMutableTreeNode;

public class Objective extends LevelComponent{
    String objective;
    static int count = 0;

    public Objective(String objective){
        this.objective = objective;
    }

    public String getObjective() {
        return objective;
    }

    public void displayLevelInfo(DefaultMutableTreeNode root){
        root.add(new DefaultMutableTreeNode("Objective " + ++count + " | " + getObjective()));
    }
}