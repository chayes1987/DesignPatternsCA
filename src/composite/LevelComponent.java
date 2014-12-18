package composite;

import javax.swing.tree.DefaultMutableTreeNode;

public abstract class LevelComponent {

    public void addLevel(LevelComponent levelComponent){
        throw new UnsupportedOperationException();
    }
    public void displayLevelInfo(DefaultMutableTreeNode root){
        throw new UnsupportedOperationException();
    }
}
