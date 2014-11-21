import factory.EnemyVehicleFactory;
import factory.MainCharacterVehicleFactory;
import factory.Vehicle;
import factory.VehicleFactory;
import strategy.*;
import strategy.Character;

import javax.swing.*;

public class ShootEmUpGame {
    public static void main(String[] args) {
        Character mainCharacter = new MainCharacter();
        print("Main character is " + mainCharacter.walk());

        Character enemy1 = new Enemy();
        print("Enemy1 is " + enemy1.walk());

        print("Main character is " + mainCharacter.getShootBehaviour());
        print("Enemy1 is " + enemy1.run());

        print("Main character is " + mainCharacter.getGrenadeBehaviour());

        Character civilian1 = new Civilian();
        print("Civilian1 is " + civilian1.run());
        print("Civilian1 " + civilian1.getShootBehaviour());

        Character hostage1 = new Hostage();
        print("Hostage1 is " + hostage1.walk());
        print("Hostage1 " + hostage1.getGrenadeBehaviour());

        print("Civilian 1 becomes Vigilante!");
        civilian1.setShootBehaviour(new ShootWithAK47());
        print("Civilian1 " + civilian1.getShootBehaviour());

        VehicleFactory enemyVehicleFactory = new EnemyVehicleFactory();
        String type = JOptionPane.showInputDialog("Enter Enemy Vehicle type (T for Tank or A for Armoured Car)");
        Vehicle vehicle = enemyVehicleFactory.createVehicle(type);
        print("Enemy " + vehicle.drive());
        print("Enemy " + vehicle.shoot());

        VehicleFactory mainCharacterVehicleFactory = new MainCharacterVehicleFactory();
        type = JOptionPane.showInputDialog("Enter Main Character Vehicle type (F for Flamethrower Tank or H for Helicopter)");
        vehicle = mainCharacterVehicleFactory.createVehicle(type);
        print("Main Character " + vehicle.drive());
        print("Main Character " + vehicle.shoot());
    }

    public static void print(String output){
        System.out.println(output);
    }
}
