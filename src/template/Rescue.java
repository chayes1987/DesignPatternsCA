package template;

import strategy.AttackWithAK47;
import strategy.Character;

public abstract class Rescue {
    protected Character innocentCharacter;

    public Rescue(Character innocentCharacter){
        this.innocentCharacter = innocentCharacter;
    }

    public final String rescue(){
        String rescue = "";
        rescue += untie();
        rescue += checkWounded() + "\n";

        if(innocentCharacter.getCurrentState() != innocentCharacter.getDeadState()) {
            rescue += comfort() + "\n";
            rescue += arm() + "\n";
            rescue += escort();
        }
        return rescue;
    }

    public String untie(){ return ""; }

    public abstract String checkWounded();

    public String comfort() {
        return "...comforting them";
    }

    public String arm() {
        innocentCharacter.setAttackBehaviour(new AttackWithAK47());
        return "...arming them with AK47";
    }

    public String escort(){ return ""; }
}
