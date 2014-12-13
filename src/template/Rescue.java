package template;

import strategy.AttackWithAK47;
import strategy.Character;

public abstract class Rescue {
    protected Character innocentCharacter;

    public Rescue(Character innocentCharacter){
        this.innocentCharacter = innocentCharacter;
    }

    public void rescue(){
        untie();
        checkWounded();

        if(innocentCharacter.getCurrentState() != innocentCharacter.getDeadState()) {
            comfort();
            arm();
            escort();
        }
    }

    public void untie(){};

    public abstract void checkWounded();

    public void comfort() {
        System.out.println("comforting");
    }

    public void arm() {
        System.out.println("arming");
        innocentCharacter.setAttackBehaviour(new AttackWithAK47());
        System.out.println("armed with AK47");
    }

    public void escort(){};
}
