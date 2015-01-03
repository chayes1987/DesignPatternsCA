package state;

import strategy.Character;

public class Dead implements CharacterHealthState {

    Character currentCharacter;

    public Dead(Character currentCharacter){
        this.currentCharacter = currentCharacter;
    }

    @Override
    public String gotShot() {
        return " got shot...already Dead...";
    }

    @Override
    public String collectedFirstAidKit() {
        return " is still very much dead..";
    }

    @Override
    public String foundArmour() {
        return " don't need it..I am dead...";
    }
}
