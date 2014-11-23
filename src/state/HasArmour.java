package state;

import strategy.Character;

public class HasArmour implements CharacterHealthState {

    Character currentCharacter;

    public HasArmour(Character currentCharacter){
        this.currentCharacter = currentCharacter;
    }

    @Override
    public void gotShot(String character) {
        System.out.println(character + " got shot..");
        currentCharacter.setCurrentState(currentCharacter.getFullHealthState());
        System.out.println(character + " had Armour state now Full Health...");
    }

    @Override
    public void collectedFirstAidKit(String character) {
        System.out.println(character + " has armour and doesn't need first aid right now..");
    }

    @Override
    public void foundArmour(String character) {
        System.out.println(character + " already has armour..");
    }
}
