import composite.*;
import decorator.*;
import factory.EnemyVehicleFactory;
import factory.MainCharacterVehicleFactory;
import factory.VehicleFactory;
import strategy.*;
import strategy.Character;
import factory.IVehicle;
import template.Rescue;
import template.RescueCivilian;
import template.RescueHostage;

import javax.swing.*;

public class ShootEmUpGame {
    private Character mainCharacter;

    public static void main(String[] args) {
        ShootEmUpGame game = new ShootEmUpGame();
        game.createLevelListing();
        game.narrateGameplay();
        game.useVehicles();
        game.pimpGun();
    }

    private void pimpGun() {
        Gun gun = new SimpleGun();
        print("Main character found a " + gun.getDescription());
        print("Main character found a scope...");
        gun = new Scope(gun);
        print("Main character now has a " + gun.getDescription());
        print("Main character found a bayonet and a flamethrower and a grenade launcher...");
        gun = new GrenadeLauncher(new Flamethrower(new Bayonet(gun)));
        print("Main character now has a " + gun.getDescription());
        mainCharacter.setAttackBehaviour(new AttackWithFlamethrower());
        print("Main character is " + mainCharacter.getAttackBehaviour());
    }

    private void narrateGameplay() {
        mainCharacter = new MainCharacter();
        print("Main character is " + mainCharacter.walk());
        Character enemy1 = new Enemy();
        print("Enemy1 is " + enemy1.walk());
        print("Main character is " + mainCharacter.getAttackBehaviour());
        print("Enemy1 is " + enemy1.run());
        print("Main character is " + mainCharacter.getGrenadeBehaviour());
        Character civilian1 = new Civilian();
        print("Civilian1 is " + civilian1.run());
        print("Civilian1 " + civilian1.getAttackBehaviour());
        Character hostage1 = new Hostage();
        print("Hostage1 is " + hostage1.walk());
        print("Hostage1 " + hostage1.getGrenadeBehaviour());
        print("Civilian 1 becomes Vigilante!");
        civilian1.setAttackBehaviour(new AttackWithAK47());
        print("Civilian1 " + civilian1.getAttackBehaviour());
        mainCharacter.gotShot("Main character");
        enemy1.foundArmour("Enemy 1");
        enemy1.foundArmour("Enemy 1");
        mainCharacter.collectedFirstAidKit("Main character");
        Rescue rescue1 = new RescueHostage(hostage1);
        rescue1.rescue();
        Rescue rescue2 = new RescueCivilian(civilian1);
        civilian1.setCurrentState(civilian1.getNearlyDeadState());
        rescue2.rescue();
    }

    private void useVehicles() {
        VehicleFactory enemyVehicleFactory = new EnemyVehicleFactory();
        String type = JOptionPane.showInputDialog("Enter Enemy Vehicle type (T for Tank or A for Armoured Car)");
        IVehicle vehicle = enemyVehicleFactory.createVehicle(type);
        print("Enemy " + vehicle.drive());
        print("Enemy " + vehicle.shoot());

        VehicleFactory mainCharacterVehicleFactory = new MainCharacterVehicleFactory();
        type = JOptionPane.showInputDialog("Enter Main Character Vehicle type (F for Flamethrower Tank or H for Helicopter)");
        vehicle = mainCharacterVehicleFactory.createVehicle(type);
        print("Main Character " + vehicle.drive());
        print("Main Character " + vehicle.shoot());
    }

    private void createLevelListing() {
        LevelComponent level1 = new Level("One", "Journey Begins");
        LevelComponent level2 = new Level("Two", "Evasion Tactics");
        LevelComponent level3 = new Level("Three", "The Great Escape");

        LevelComponent allLevels = new Level("Listing", "All Game Levels");

        LevelComponent objective1 = new Objective("Find a Gun");
        LevelComponent objective2 = new Objective("Rescue 5 Hostages");
        LevelComponent objective3 = new Objective("Evade the Guards");
        LevelComponent objective4 = new Objective("Kill 10 Enemies");

        LevelComponent mission1 = new Mission();
        mission1.addLevel(objective1);
        mission1.addLevel(objective2);

        LevelComponent mission2 = new Mission();
        mission2.addLevel(objective3);
        mission2.addLevel(objective4);

        level1.addLevel(mission1);
        level1.addLevel(mission2);

        LevelComponent objective5 = new Objective("Get 3 Head-shots");
        LevelComponent objective6 = new Objective("Help 5 Civilians");
        LevelComponent objective7 = new Objective("Find a grenade launcher mod");
        LevelComponent objective8 = new Objective("Blow up 3 Enemies");

        LevelComponent mission3 = new Mission();
        mission3.addLevel(objective5);
        mission3.addLevel(objective6);

        LevelComponent mission4 = new Mission();
        mission4.addLevel(objective7);
        mission4.addLevel(objective8);

        level2.addLevel(mission3);
        level2.addLevel(mission4);

        LevelComponent objective9 = new Objective("Find the Flamethrower Mod");
        LevelComponent objective10 = new Objective("Incinerate 15 Enemies");
        LevelComponent objective11 = new Objective("Find the Helicopter");
        LevelComponent objective12 = new Objective("Use the Helicopter to escape");

        LevelComponent mission5 = new Mission();
        mission5.addLevel(objective9);
        mission5.addLevel(objective10);

        LevelComponent mission6 = new Mission();
        mission6.addLevel(objective11);
        mission6.addLevel(objective12);

        level3.addLevel(mission5);
        level3.addLevel(mission6);

        allLevels.addLevel(level1);
        allLevels.addLevel(level2);
        allLevels.addLevel(level3);

        Game shootEmUp = new Game(allLevels);
        shootEmUp.displayLevelList();
    }

    public static void print(String output){
        System.out.println(output);
    }
}
