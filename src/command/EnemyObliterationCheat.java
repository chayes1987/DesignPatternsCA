package command;

import java.util.List;

public class EnemyObliterationCheat implements ICommand{
    List<ICheatCodeReceiver> receivers;

    public EnemyObliterationCheat(List<ICheatCodeReceiver> receivers){
        this.receivers = receivers;
    }

    @Override
    public String execute() {
        String cheat="";
        for(ICheatCodeReceiver receiver : receivers){
            cheat += receiver.spontaneouslyCombust() + "\n";
        }
        return cheat;
    }
}
