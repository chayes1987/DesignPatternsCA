package command;

public class CheatAction {
    public static ICommand getAction(String action, ICheatCodeReceiver target){
        if(action.equals("W")){
            return new StripWeaponry(target);
        }else if(action.equals("C")){
            return new SpontaneouslyCombust(target);
        }else if(action.equals("D")){
            return new Destroy(target);
        }
        return null;
    }
}
