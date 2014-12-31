import command.*;
import factory.ArmouredCar;
import factory.Tank;
import org.junit.Assert;
import org.junit.Test;
import strategy.Enemy;

import java.util.ArrayList;
import java.util.List;

public class CommandTest {

    @Test
    public void TestCommand(){
        ICheatCodeReceiver receiver = CheatTarget.getTarget("T");
        ICommand command = CheatAction.getAction("D", receiver);
        CheatCodeInvoker invoker = new CheatCodeInvoker(command);
        Assert.assertEquals("Enemy Tank has been destroyed", invoker.performCheat());
        Assert.assertEquals("Tank has re-formed", invoker.undoCheat());

        receiver = CheatTarget.getTarget("E");
        command = CheatAction.getAction("C", receiver);
        invoker = new CheatCodeInvoker(command);
        Assert.assertEquals("Enemy has spontaneously combusted", invoker.performCheat());
        Assert.assertEquals("Enemy has re-spawned!", invoker.undoCheat());

        receiver = CheatTarget.getTarget("A");
        command = CheatAction.getAction("W", receiver);
        invoker = new CheatCodeInvoker(command);
        Assert.assertEquals("Armoured car striped off Weaponry", invoker.performCheat());
        Assert.assertEquals("Armoured car has re-added weaponry", invoker.undoCheat());

        List<ICheatCodeReceiver> receiverList = new ArrayList<ICheatCodeReceiver>();
        receiverList.add(new Enemy("Enemy 1"));
        receiverList.add(new ArmouredCar());
        receiverList.add(new Tank());

        EnemyObliterationCheat cheat = new EnemyObliterationCheat(receiverList);
        invoker = new CheatCodeInvoker(cheat);
        Assert.assertEquals("Enemy has spontaneously combusted\nArmoured car spontaneously combusted\nEnemy Tank spontaneously combusted", invoker.performCheat());
        Assert.assertEquals("Enemy has re-spawned!\nArmoured car has re-spawned!\nTank has re-spawned!", invoker.undoCheat());
    }
}
