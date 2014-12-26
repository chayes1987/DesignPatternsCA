package command;

public class StripWeaponry implements ICommand {
    ICheatCodeReceiver receiver;

    public StripWeaponry(ICheatCodeReceiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute() {
        return receiver.stripWeaponry();
    }

    @Override
    public String undo() {
        return receiver.addWeaponry();
    }
}
