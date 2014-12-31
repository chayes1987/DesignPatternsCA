package command;

import factory.*;
import strategy.Enemy;

public class CheatTarget {
    public static ICheatCodeReceiver getTarget(String target){
        if(target.equals("E")){
            return new Enemy("Enemy1");
        }else if(target.equals("A")){
            return new ArmouredCar();
        }else if(target.equals("T")){
            return new Tank();
        }
        return null;
    }
}
