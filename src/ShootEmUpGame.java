import command.*;
import composite.*;
import decorator.*;
import factory.ArmouredCar;
import factory.Tank;
import factory.VehicleFactory;
import observer.IObserver;
import observer.LocationObserver;
import observer.PlayerLocation;
import strategy.*;
import strategy.Character;
import factory.IVehicle;
import template.Rescue;
import template.RescueCivilian;
import template.RescueHostage;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShootEmUpGame {
    private Character mainCharacter;
    private JFrame frame;
    private JTextArea game_output;
    private JSplitPane pane;
    private List<Character> characters;

    public static void main(String[] args) {
        ShootEmUpGame game = new ShootEmUpGame();
        game.createLevelListing();
        game.narrateGameplay();
        game.useVehicles();
        game.pimpGun();
        game.executeCheatCodes();
        game.rollCredits();
    }

    private void rollCredits() {
        print("\nThanks for playing, characters in alphabetical order were:");
        Collections.sort(characters,
                (character1, character2) -> character1.getName().compareTo(character2.getName())
        );

        for(Character character : characters){
            print(character.getName());
        }
    }

    private void executeCheatCodes() {
        String target = JOptionPane.showInputDialog("Enter the Target of your cheat (E for Enemy, T for Tank or A for Armoured Car)");

        while(!target.equals("T") && !target.equals("A") && !target.equals("E")) {
            target = JOptionPane.showInputDialog("Invalid...Enter the Target of your cheat (E for Enemy, T for Tank or A for Armoured Car)");
        }
        ICheatCodeReceiver receiver = CheatTarget.getTarget(target);

        String action = JOptionPane.showInputDialog("What do you wish to do to them? (W for Strip Weaponry, C for Spontaneously Combust or D for Destroy)");

        while(!action.equals("W") && !action.equals("C") && !action.equals("D")) {
            action = JOptionPane.showInputDialog("Invalid...What do you wish to do to them? (W for Strip Weaponry, C for Spontaneously Combust or D for Destroy)");
        }

        print("Gamer has entered a cheat");

        ICommand command = CheatAction.getAction(action, receiver);
        CheatCodeInvoker invoker = new CheatCodeInvoker(command);
        print(invoker.performCheat());

        String obliterate = JOptionPane.showInputDialog("Obliterate all enemies? (Yes or No)");

        while(!obliterate.equals("Yes") && !obliterate.equals("No")) {
            obliterate = JOptionPane.showInputDialog("Invalid...Obliterate all enemies? (Yes or No)");
        }

        if(obliterate.equals("Yes")){
            List<ICheatCodeReceiver> receiverList = new ArrayList<>();
            receiverList.add(new Enemy("Enemy 2"));
            receiverList.add(new ArmouredCar());
            receiverList.add(new Tank());

            EnemyObliterationCheat cheat = new EnemyObliterationCheat(receiverList);
            invoker = new CheatCodeInvoker(cheat);
            print(invoker.performCheat());
            print(invoker.undoCheat());
        }
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
        characters = new ArrayList<>();
        mainCharacter = new MainCharacter("Main Character");
        characters.add(mainCharacter);
        PlayerLocation mainCharacterLocation = new PlayerLocation(new ArrayList<>());
        LocationObserver mainCharacterLocationObserver = new LocationObserver(mainCharacterLocation);
        mainCharacterLocation.setLongitude(140.4);
        mainCharacterLocation.setLatitude(230.5);
        print(mainCharacterLocationObserver.getLocation());
        print(mainCharacter.walk());
        mainCharacterLocation.setLongitude(150.4);
        mainCharacterLocation.setLatitude(224.5);
        print(mainCharacterLocationObserver.getLocation());
        Character enemy1 = new Enemy("Enemy 1");
        characters.add(enemy1);
        print(enemy1.walk());
        print(mainCharacter.getAttackBehaviour());
        print(enemy1.run());
        print(mainCharacter.getGrenadeBehaviour());
        Character civilian1 = new Civilian("Civilian 1");
        characters.add(civilian1);
        print(civilian1.run());
        print(civilian1.getAttackBehaviour());
        Character hostage1 = new Hostage("Hostage 1");
        characters.add(hostage1);
        print(hostage1.walk());
        print(hostage1.getGrenadeBehaviour());
        mainCharacterLocation.setLongitude(180.8);
        mainCharacterLocation.setLatitude(150.5);
        print(mainCharacterLocationObserver.getLocation());
        print("Civilian 1 becomes Vigilante!");
        civilian1.setAttackBehaviour(new AttackWithAK47());
        print(civilian1.getAttackBehaviour());
        print(mainCharacter.gotShot());
        print(enemy1.foundArmour());
        print(mainCharacter.collectedFirstAidKit());
        print(hostage1.getAttackBehaviour());
        Rescue rescue1 = new RescueHostage(hostage1);
        print(rescue1.rescue());
        print(hostage1.getAttackBehaviour());
        Rescue rescue2 = new RescueCivilian(civilian1);
        civilian1.setCurrentState(civilian1.getNearlyDeadState());
        rescue2.rescue();
        mainCharacterLocation.setLongitude(390.4);
        mainCharacterLocation.setLatitude(205.1);
        print(mainCharacterLocationObserver.getLocation());
    }

    private void useVehicles() {
        VehicleFactory enemyVehicleFactory = VehicleFactory.getVehicleFactory("Enemy");
        String type = JOptionPane.showInputDialog("Enter Enemy Vehicle type (T for Tank or A for Armoured Car)");

        while(!type.equals("T") && !type.equals("A")) {
            type = JOptionPane.showInputDialog("Invalid...Enter Enemy Vehicle type (T for Tank or A for Armoured Car)");
        }

        IVehicle vehicle = enemyVehicleFactory.createVehicle(type);
        print("Enemy " + vehicle.drive());
        print("Enemy " + vehicle.shoot());

        VehicleFactory mainCharacterVehicleFactory = VehicleFactory.getVehicleFactory("Main Character");
        type = JOptionPane.showInputDialog("Enter Main Character Vehicle type (F for Flamethrower Tank or H for Helicopter)");

        while(!type.equals("F") && !type.equals("H")) {
            type = JOptionPane.showInputDialog("Invalid...Enter Main Character Vehicle type (F for Flamethrower Tank or H for Helicopter)");
        }

        vehicle = mainCharacterVehicleFactory.createVehicle(type);
        print("Main Character " + vehicle.drive());
        print("Main Character " + vehicle.shoot());
    }

    private void createLevelListing() {
        LevelComponent allLevels = new Level("Listing", "All Game Levels", new ArrayList<LevelComponent>());

        LevelComponent level1 = new Level("One", "Journey Begins", new ArrayList<LevelComponent>());
        LevelComponent level2 = new Level("Two", "Evasion Tactics", new ArrayList<LevelComponent>());
        LevelComponent level3 = new Level("Three", "The Great Escape", new ArrayList<LevelComponent>());

        LevelComponent objective1 = new Objective("Find a Gun");
        LevelComponent objective2 = new Objective("Rescue 5 Hostages");
        LevelComponent objective3 = new Objective("Evade the Guards");
        LevelComponent objective4 = new Objective("Kill 10 Enemies");

        LevelComponent mission1 = new Mission(new ArrayList<LevelComponent>());
        mission1.addLevel(objective1);
        mission1.addLevel(objective2);

        LevelComponent mission2 = new Mission(new ArrayList<LevelComponent>());
        mission2.addLevel(objective3);
        mission2.addLevel(objective4);

        level1.addLevel(mission1);
        level1.addLevel(mission2);

        LevelComponent objective5 = new Objective("Get 3 Head-shots");
        LevelComponent objective6 = new Objective("Help 5 Civilians");
        LevelComponent objective7 = new Objective("Find a grenade launcher mod");
        LevelComponent objective8 = new Objective("Blow up 3 Enemies");

        LevelComponent mission3 = new Mission(new ArrayList<LevelComponent>());
        mission3.addLevel(objective5);
        mission3.addLevel(objective6);

        LevelComponent mission4 = new Mission(new ArrayList<LevelComponent>());
        mission4.addLevel(objective7);
        mission4.addLevel(objective8);

        level2.addLevel(mission3);
        level2.addLevel(mission4);

        LevelComponent objective9 = new Objective("Find the Flamethrower Mod");
        LevelComponent objective10 = new Objective("Incinerate 15 Enemies");
        LevelComponent objective11 = new Objective("Find the Helicopter");
        LevelComponent objective12 = new Objective("Use the Helicopter to escape");

        LevelComponent mission5 = new Mission(new ArrayList<LevelComponent>());
        mission5.addLevel(objective9);
        mission5.addLevel(objective10);

        LevelComponent mission6 = new Mission(new ArrayList<LevelComponent>());
        mission6.addLevel(objective11);
        mission6.addLevel(objective12);

        level3.addLevel(mission5);
        level3.addLevel(mission6);

        allLevels.addLevel(level1);
        allLevels.addLevel(level2);
        allLevels.addLevel(level3);

        displayGameStructure(allLevels);
    }

    private void displayGameStructure(LevelComponent allLevels) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Shoot 'Em Up Game");
        JTree tree = new JTree(root);
        Game shootEmUp = new Game(allLevels);
        shootEmUp.displayLevelList(root);
        for(int node = 0; node < tree.getRowCount(); node++){
            tree.expandRow(node);
        }
        pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        pane.setLeftComponent(tree);

        displayGame();
    }

    private void displayGame() {
        JPanel p = new JPanel();
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Game Output"));
        p.setLayout(new GridLayout(1, 1));
        p.setPreferredSize(new Dimension(450, 150));
        game_output = new JTextArea();
        DefaultCaret caret = (DefaultCaret)game_output.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        game_output.setLineWrap(true);
        game_output.setEditable(false);
        p.add(new JScrollPane (game_output, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        pane.setRightComponent(p);
        frame = new JFrame();
        frame.add(pane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Shoot 'Em Up Game");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void print(String output){
        game_output.append(output + "\n");
    }
}
