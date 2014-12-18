package state;

import strategy.Character;

public class LowHealth implements CharacterHealthState{

    Character currentCharacter;

    public LowHealth(Character currentCharacter){
        this.currentCharacter = currentCharacter;
    }

    @Override
    public String gotShot() {
        currentCharacter.setCurrentState(currentCharacter.getNearlyDeadState());
        return " got shot...had Low Health state now Nearly Dead...";
    }

    @Override
    public String collectedFirstAidKit() {
        currentCharacter.setCurrentState(currentCharacter.getFullHealthState());
        return " found a first aid kit...had Low Health and now has Full Health..";
    }

    @Override
    public String foundArmour() {
        currentCharacter.setCurrentState(currentCharacter.getHasArmourState());
        return " armour added..";
    }
}
