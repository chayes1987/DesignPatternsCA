package composite;

import javax.swing.tree.DefaultMutableTreeNode;

public class Game {
    LevelComponent levels;

    public Game(LevelComponent levels){
        this.levels = levels;
    }

    public void displayLevelList(DefaultMutableTreeNode root){
        levels.displayLevelInfo(root);
    }
}
