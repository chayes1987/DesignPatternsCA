import org.junit.Assert;
import org.junit.Test;
import strategy.*;
import strategy.Character;

public class StrategyAndStateTest {
    private Character character;

    @Test
    public void testGetGrenadeBehaviour() throws Exception {
        character = new MainCharacter("Main Character");
        Assert.assertEquals(character.getName() + " is throwing grenade...", character.getGrenadeBehaviour());
        character.setGrenadeBehaviour(new CantThrowGrenade());
        Assert.assertEquals(character.getName() + " can't throw grenade...", character.getGrenadeBehaviour());
        character.setGrenadeBehaviour(new CanThrowGrenade());
        Assert.assertEquals(character.getName() + " is throwing grenade...", character.getGrenadeBehaviour());
        Assert.assertNotEquals(character.getName() + " can't throw grenade...", character.getGrenadeBehaviour());
    }

    @Test
    public void testGetAttackBehaviour() throws Exception {
        character = new Hostage("Hostage 1");
        Assert.assertEquals(character.getName() + " can't attack...", character.getAttackBehaviour());
        character.setAttackBehaviour(new AttackWithAK47());
        Assert.assertEquals(character.getName() + " is shooting with AK-47...", character.getAttackBehaviour());
        character.setAttackBehaviour(new AttackWithUzi());
        Assert.assertEquals(character.getName() + " is shooting with Uzi...", character.getAttackBehaviour());
        character.setAttackBehaviour(new CantAttack());
        Assert.assertEquals(character.getName() + " can't attack...", character.getAttackBehaviour());
        Assert.assertNotEquals(character.getName() + " is shooting with Uzi...", character.getAttackBehaviour());
    }

    @Test
    public void testGetCurrentState() throws Exception {
        character = new Civilian("Civilian 1");
        Assert.assertEquals(character.getFullHealthState(), character.getCurrentState());
        character.foundArmour();
        Assert.assertEquals(character.getHasArmourState(), character.getCurrentState());
        character.gotShot();
        Assert.assertEquals(character.getFullHealthState(), character.getCurrentState());
        character.setCurrentState(character.getNearlyDeadState());
        character.collectedFirstAidKit();
        Assert.assertEquals(character.getLowHealthState(), character.getCurrentState());
        character.gotShot();
        Assert.assertEquals(character.getNearlyDeadState(), character.getCurrentState());
        character.gotShot();
        Assert.assertEquals(character.getDeadState(), character.getCurrentState());
        Assert.assertNotEquals(character.getFullHealthState(), character.getCurrentState());
    }

    @Test
    public void testGetHasArmourState() throws Exception {
        character = new Enemy("Enemy 1");
        character.setCurrentState(character.getHasArmourState());
        Assert.assertEquals(character.getHasArmourState(), character.getCurrentState());
        character.gotShot();
        Assert.assertNotEquals(character.getHasArmourState(), character.getCurrentState());
        character.foundArmour();
        Assert.assertEquals(character.getHasArmourState(), character.getCurrentState());
    }

    @Test
    public void testGetFullHealthState() throws Exception {
        character = new MainCharacter("Main Character");
        Assert.assertEquals(character.getFullHealthState(), character.getCurrentState());
        character.gotShot();
        Assert.assertNotEquals(character.getFullHealthState(), character.getCurrentState());
        character.collectedFirstAidKit();
        Assert.assertEquals(character.getFullHealthState(), character.getCurrentState());
    }

    @Test
    public void testGetLowHealthState() throws Exception {
        character = new Civilian("Civilian 1");
        Assert.assertNotEquals(character.getLowHealthState(), character.getCurrentState());
        character.gotShot();
        Assert.assertEquals(character.getLowHealthState(), character.getCurrentState());
        character.collectedFirstAidKit();
        Assert.assertNotEquals(character.getLowHealthState(), character.getCurrentState());
        character.setCurrentState(character.getLowHealthState());
        Assert.assertEquals(character.getLowHealthState(), character.getCurrentState());
    }

    @Test
    public void testGetNearlyDeadState() throws Exception {
        character = new Hostage("Hostage 1");
        Assert.assertNotEquals(character.getNearlyDeadState(), character.getCurrentState());
        character.gotShot();
        Assert.assertNotEquals(character.getNearlyDeadState(), character.getCurrentState());
        character.gotShot();
        Assert.assertEquals(character.getNearlyDeadState(), character.getCurrentState());
        character.collectedFirstAidKit();
        Assert.assertNotEquals(character.getNearlyDeadState(), character.getCurrentState());
        character.setCurrentState(character.getDeadState());
        Assert.assertNotEquals(character.getLowHealthState(), character.getCurrentState());
    }

    @Test
    public void testGetDeadState() throws Exception {
        character = new Enemy("Enemy 1");
        Assert.assertNotEquals(character.getDeadState(), character.getCurrentState());
        character.gotShot();
        Assert.assertNotEquals(character.getDeadState(), character.getCurrentState());
        character.gotShot();
        Assert.assertNotEquals(character.getDeadState(), character.getCurrentState());
        character.gotShot();
        Assert.assertEquals(character.getDeadState(), character.getCurrentState());
    }
}