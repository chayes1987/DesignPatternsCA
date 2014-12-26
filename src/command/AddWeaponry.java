package command;

public class AddWeaponry implements ICommand {
    ICheatCodeReceiver receiver;

    public AddWeaponry(ICheatCodeReceiver receiver){
        this.receiver = receiver;
    }

    @Override
    public String execute() {
        return receiver.addWeaponry();
    }

    @Override
    public String undo() {
        return receiver.stripWeaponry();
    }
}
