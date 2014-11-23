package state;

import strategy.Character;

public class FullHealth implements CharacterHealthState {

    Character currentCharacter;

    public FullHealth(Character currentCharacter){
        this.currentCharacter = currentCharacter;
    }

    @Override
    public void gotShot(String character) {
        System.out.println(character + " got shot..");
        currentCharacter.setCurrentState(currentCharacter.getLowHealthState());
        System.out.println(character + " had Full Health state now Low Health...");
    }

    @Override
    public void collectedFirstAidKit(String character) {
        System.out.println(character + " has Full Health and doesn't need first aid right now..");
    }

    @Override
    public void foundArmour(String character) {
        currentCharacter.setCurrentState(currentCharacter.getHasArmourState());
        System.out.println(character + " armour added..");
    }
}
