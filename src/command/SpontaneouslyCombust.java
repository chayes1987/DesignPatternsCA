package command;

public class SpontaneouslyCombust implements ICommand {
    ICheatCodeReceiver receiver;

    public SpontaneouslyCombust(ICheatCodeReceiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute() {
        return receiver.spontaneouslyCombust();
    }
}