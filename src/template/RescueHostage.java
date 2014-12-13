package template;

import strategy.Character;

public class RescueHostage extends Rescue {

    public RescueHostage(Character hostage){
        super(hostage);
    }

    @Override
    public void untie(){
        System.out.println("Untying hostage");
    }

    @Override
    public void checkWounded() {
        System.out.println("Checking if hostage is wounded..");
        if(innocentCharacter.getCurrentState() == innocentCharacter.getNearlyDeadState()){
            System.out.println("Hostage condition is critical, applying first aid");
            innocentCharacter.setCurrentState(innocentCharacter.getFullHealthState());
            System.out.println("Hostage health restored");
        }else{
            System.out.println("Hostage not injured");
        }
    }

    @Override
    public void escort(){
        System.out.println("Escorting hostage to safety...");
    }
}
