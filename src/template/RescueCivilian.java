package template;

import strategy.Character;

public class RescueCivilian extends Rescue{

    public RescueCivilian(Character civilian){
        super(civilian);
    }

    @Override
    public void checkWounded() {
        System.out.println("Checking if civilian is injured...");
        if(innocentCharacter.getCurrentState() == innocentCharacter.getNearlyDeadState()){
            System.out.println("Civilian is nearly dead...putting them out of their misery");
            innocentCharacter.setCurrentState(innocentCharacter.getDeadState());
            System.out.println("Civilian is dead...");
        }else{
            System.out.println("Civilian not injured");
        }
    }
}
