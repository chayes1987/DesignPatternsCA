package strategy;

public class AttackWithGrenadeLauncher implements IAttackBehaviour {
    @Override
    public String attack() {
        return "firing from Grenade Launcher...";
    }
}
