package state;

import strategy.Character;

public class FullHealth implements CharacterHealthState {

    Character currentCharacter;

    public FullHealth(Character currentCharacter){
        this.currentCharacter = currentCharacter;
    }

    @Override
    public String gotShot() {
        currentCharacter.setCurrentState(currentCharacter.getLowHealthState());
        return " got shot...had Full Health state now Low Health...";
    }

    @Override
    public String collectedFirstAidKit() {
        return " has Full Health and doesn't need first aid right now..";
    }

    @Override
    public String foundArmour() {
        currentCharacter.setCurrentState(currentCharacter.getHasArmourState());
        return " armour added..";
    }
}
