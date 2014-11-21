package strategy;

import factory.Tank;
import factory.Vehicle;
import javax.swing.*;

public class ShootEmUpGame {
    public static void main(String[] args) {
        Character mainCharacter = new MainCharacter();
        System.out.println("Main character is " + mainCharacter.walk());

        Character enemy1 = new Enemy();
        System.out.println("Enemy1 is " + enemy1.walk());

        System.out.println("Main character is " + mainCharacter.getShootBehaviour());
        System.out.println("Enemy1 is " + enemy1.run());

        System.out.println("Main character is " + mainCharacter.getGrenadeBehaviour());

        Character civilian1 = new Civilian();
        System.out.println("Civilian1 is " + civilian1.run());
        System.out.println("Civilian1 " + civilian1.getShootBehaviour());

        Character hostage1 = new Hostage();
        System.out.println("Hostage1 is " + hostage1.walk());
        System.out.println("Hostage1 " + hostage1.getGrenadeBehaviour());

        System.out.println("Civilian 1 becomes Vigilante!");
        civilian1.setShootBehaviour(new ShootWithAK47());
        System.out.println("Civilian1 " + civilian1.getShootBehaviour());

        Vehicle tank = new Tank();
        System.out.println("Main character " + tank.drive());
        System.out.println("Main character " + tank.shoot());
    }
}
