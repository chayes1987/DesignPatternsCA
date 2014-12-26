package command;

public class Destroy implements ICommand {
    ICheatCodeReceiver receiver;

    public Destroy(ICheatCodeReceiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute() {
        return receiver.destroy();
    }

    @Override
    public String undo() {
        return null;
    }
}
