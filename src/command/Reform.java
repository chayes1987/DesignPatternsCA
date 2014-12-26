package command;

/**
 * Created by Conor on 26/12/2014.
 */
public class Reform implements ICommand {
    ICheatCodeReceiver receiver;

    public Reform(ICheatCodeReceiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute() {
        return receiver.reform();
    }

    @Override
    public String undo() {
        return receiver.destroy();
    }
}
