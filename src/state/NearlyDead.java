package state;

import strategy.Character;

public class NearlyDead implements CharacterHealthState{

    Character currentCharacter;

    public NearlyDead(Character currentCharacter){
        this.currentCharacter = currentCharacter;
    }

    @Override
    public void gotShot(String character) {
        System.out.println(character + " got shot..");
        currentCharacter.setCurrentState(currentCharacter.getDeadState());
        System.out.println(character + " was Nearly Dead state now Dead...");
    }

    @Override
    public void collectedFirstAidKit(String character) {
        System.out.println(character + " found a first aid kit...");
        currentCharacter.setCurrentState(currentCharacter.getLowHealthState());
        System.out.println(character + " was Nearly Dead and now has Low Health..");
    }

    @Override
    public void foundArmour(String character) {
        currentCharacter.setCurrentState(currentCharacter.getHasArmourState());
        System.out.println(character + " armour added..");
    }
}
