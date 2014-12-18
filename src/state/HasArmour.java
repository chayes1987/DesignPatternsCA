package state;

import strategy.Character;

public class HasArmour implements CharacterHealthState {

    Character currentCharacter;

    public HasArmour(Character currentCharacter){
        this.currentCharacter = currentCharacter;
    }

    @Override
    public String gotShot() {
        currentCharacter.setCurrentState(currentCharacter.getFullHealthState());
        return  "got shot...had Armour state now Full Health...";
    }

    @Override
    public String collectedFirstAidKit() {
        return "has armour and doesn't need first aid right now..";
    }

    @Override
    public String foundArmour() {
        return " already has armour..";
    }
}
