package state;

import strategy.Character;

public class NearlyDead implements CharacterHealthState{

    Character currentCharacter;

    public NearlyDead(Character currentCharacter){
        this.currentCharacter = currentCharacter;
    }

    @Override
    public String gotShot() {
        currentCharacter.setCurrentState(currentCharacter.getDeadState());
        return " got shot...was Nearly Dead state now Dead...";
    }

    @Override
    public String collectedFirstAidKit() {
        currentCharacter.setCurrentState(currentCharacter.getLowHealthState());
        return " found a first aid kit...was Nearly Dead and now has Low Health..";
    }

    @Override
    public String foundArmour() {
        currentCharacter.setCurrentState(currentCharacter.getHasArmourState());
        return " armour added..";
    }
}
