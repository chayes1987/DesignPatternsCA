package template;

import strategy.Character;

public class RescueHostage extends Rescue {

    public RescueHostage(Character hostage){
        super(hostage);
    }

    @Override
    public String untie(){
        return "Untying hostage";
    }

    @Override
    public String checkWounded() {
        if(innocentCharacter.getCurrentState() == innocentCharacter.getNearlyDeadState()){
            innocentCharacter.setCurrentState(innocentCharacter.getFullHealthState());
            return "Checking if hostage is wounded...\nHostage condition is critical, applying first aid...\nHostage health restored";
        }else{
            return "Checking if hostage is wounded...\nHostage not injured";
        }
    }

    @Override
    public String escort(){
        return "Escorting hostage to safety...";
    }
}
