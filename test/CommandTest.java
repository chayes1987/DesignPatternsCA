import command.*;
import org.junit.Assert;
import org.junit.Test;

public class CommandTest {

    @Test
    public void TestCommand(){
        ICheatCodeReceiver receiver = CheatTarget.getTarget("T");
        ICommand command = CheatAction.getAction("D", receiver);
        CheatCodeInvoker invoker = new CheatCodeInvoker(command);
        Assert.assertEquals("Enemy Tank has been destroyed", invoker.performCheat());

        receiver = CheatTarget.getTarget("E");
        command = CheatAction.getAction("C", receiver);
        invoker = new CheatCodeInvoker(command);
        Assert.assertEquals("Enemy has spontaneously combusted", invoker.performCheat());

        receiver = CheatTarget.getTarget("A");
        command = CheatAction.getAction("W", receiver);
        invoker = new CheatCodeInvoker(command);
        Assert.assertEquals("Armoured car striped off Weaponry", invoker.performCheat());
    }
}
