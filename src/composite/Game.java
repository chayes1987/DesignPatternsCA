package composite;

public class Game {
    LevelComponent levels;

    public Game(LevelComponent levels){
        this.levels = levels;
    }

    public void displayLevelList(){
        levels.displayLevelInfo();
    }
}
