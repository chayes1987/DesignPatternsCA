package strategy;

public class ShootEmUpGame {
    public static void main(String[] args) {
        Character mainCharacter = new MainCharacter();
        System.out.println("Main character is " + mainCharacter.walk());

        Character enemy1 = new Enemy();
        System.out.println("Enemy1 is " + enemy1.walk());

        System.out.println("Main character " + mainCharacter.throwGrenade());

        Character civilian1 = new Civilian();
        System.out.println("Civilian 1 is " + civilian1.run());
        System.out.println("Civilian 1 " + civilian1.shoot());
    }
}
