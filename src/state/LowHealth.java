package state;

import strategy.Character;

public class LowHealth implements CharacterHealthState{

    Character currentCharacter;

    public LowHealth(Character currentCharacter){
        this.currentCharacter = currentCharacter;
    }

    @Override
    public void gotShot(String character) {
        System.out.println(character + " got shot..");
        currentCharacter.setCurrentState(currentCharacter.getNearlyDeadState());
        System.out.println(character + " had Low Health state now Nearly Dead...");
    }

    @Override
    public void collectedFirstAidKit(String character) {
        System.out.println(character + " had Low Health and now has Full Health..");
    }

    @Override
    public void foundArmour(String character) {
        currentCharacter.setCurrentState(currentCharacter.getHasArmourState());
        System.out.println(character + " armour added..");
    }
}
