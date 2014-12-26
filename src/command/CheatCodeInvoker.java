package command;

public class CheatCodeInvoker {
    ICommand command;

    public CheatCodeInvoker(ICommand command){
        this.command = command;
    }

    public String performCheat(){
        return command.execute();
    }
    public String undoCheat(){
        return command.undo();
    }
}
