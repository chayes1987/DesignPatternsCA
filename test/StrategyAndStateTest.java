import org.junit.Assert;
import org.junit.Test;
import strategy.*;
import strategy.Character;

public class StrategyAndStateTest {
    private Character character;

    @Test
    public void testGetGrenadeBehaviour() throws Exception {
        character = new MainCharacter();
        Assert.assertEquals("throwing grenade...", character.getGrenadeBehaviour());
        character.setGrenadeBehaviour(new CantThrowGrenade());
        Assert.assertEquals("can't throw grenade...", character.getGrenadeBehaviour());
        character.setGrenadeBehaviour(new CanThrowGrenade());
        Assert.assertEquals("throwing grenade...", character.getGrenadeBehaviour());
        Assert.assertNotEquals("can't throw grenade...", character.getGrenadeBehaviour());
    }

    @Test
    public void testGetAttackBehaviour() throws Exception {
        character = new Hostage();
        Assert.assertEquals("can't attack...", character.getAttackBehaviour());
        character.setAttackBehaviour(new AttackWithAK47());
        Assert.assertEquals("shooting with AK-47...", character.getAttackBehaviour());
        character.setAttackBehaviour(new AttackWithUzi());
        Assert.assertEquals("shooting with Uzi...", character.getAttackBehaviour());
        character.setAttackBehaviour(new CantAttack());
        Assert.assertEquals("can't attack...", character.getAttackBehaviour());
        Assert.assertNotEquals("shooting with Uzi...", character.getAttackBehaviour());
    }

    @Test
    public void testGetCurrentState() throws Exception {
        character = new Civilian();
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
        character = new Enemy();
        character.setCurrentState(character.getHasArmourState());
        Assert.assertEquals(character.getHasArmourState(), character.getCurrentState());
        character.gotShot();
        Assert.assertNotEquals(character.getHasArmourState(), character.getCurrentState());
        character.foundArmour();
        Assert.assertEquals(character.getHasArmourState(), character.getCurrentState());
    }

    @Test
    public void testGetFullHealthState() throws Exception {
        character = new MainCharacter();
        Assert.assertEquals(character.getFullHealthState(), character.getCurrentState());
        character.gotShot();
        Assert.assertNotEquals(character.getFullHealthState(), character.getCurrentState());
        character.collectedFirstAidKit();
        Assert.assertEquals(character.getFullHealthState(), character.getCurrentState());
    }

    @Test
    public void testGetLowHealthState() throws Exception {
        character = new Civilian();
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
        character = new Hostage();
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
        character = new Enemy();
        Assert.assertNotEquals(character.getDeadState(), character.getCurrentState());
        character.gotShot();
        Assert.assertNotEquals(character.getDeadState(), character.getCurrentState());
        character.gotShot();
        Assert.assertNotEquals(character.getDeadState(), character.getCurrentState());
        character.gotShot();
        Assert.assertEquals(character.getDeadState(), character.getCurrentState());
    }
}