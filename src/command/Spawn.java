package command;

public class Spawn implements ICommand {
    ICheatCodeReceiver receiver;

    public Spawn(ICheatCodeReceiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute() {
        return receiver.spawn();
    }

    @Override
    public String undo() {
        return receiver.spontaneouslyCombust();
    }
}
