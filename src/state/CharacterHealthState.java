package state;

public interface CharacterHealthState {
    void gotShot(String character);
    void collectedFirstAidKit(String character);
    void foundArmour(String character);
}
