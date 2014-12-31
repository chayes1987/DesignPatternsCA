package strategy;

public class CantAttack implements IAttackBehaviour {

    @Override
    public String attack() {
        return " can't attack...";
    }
}
