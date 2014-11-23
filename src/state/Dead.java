package state;

import strategy.Character;

public class Dead implements CharacterHealthState {

    Character currentCharacter;

    public Dead(Character currentCharacter){
        this.currentCharacter = currentCharacter;
    }

    @Override
    public void gotShot(String character) {
        System.out.println(character + " got shot..");
        System.out.println(character + " already Dead...");
    }

    @Override
    public void collectedFirstAidKit(String character) {
        System.out.println(character + " is still very much dead..");
    }

    @Override
    public void foundArmour(String character) {
        currentCharacter.setCurrentState(currentCharacter.getHasArmourState());
        System.out.println(character + " don't need it..I am dead...");
    }
}
