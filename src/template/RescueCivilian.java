package template;

import strategy.Character;

public class RescueCivilian extends Rescue{

    public RescueCivilian(Character civilian){
        super(civilian);
    }

    @Override
    public String checkWounded() {
        if(innocentCharacter.getCurrentState() == innocentCharacter.getNearlyDeadState()){
            innocentCharacter.setCurrentState(innocentCharacter.getDeadState());
            return "Checking if civilian is injured...\nCivilian is nearly dead...putting them out of their misery\nCivilian is dead...";
        }else{
            return "Checking if civilian is injured...\nCivilian not injured";
        }
    }
}
