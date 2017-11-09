abstract class Creature {

    String name;
    int health;
    int attack;
    int defense;

    public Creature(String n) {
        name = n;
    }

    public void myName() {
        System.out.println("Hi! My name is "+name);
        speak();
    }

    public abstract void speak();

}

class Monster extends Creature {

    public Monster(String n, int health) {
        super(n);
        this.health = health;
    }

    @Override
    public void speak() {
        System.out.println("Rawr! I am a monster");
    }

    public void damage(int amount) {
        health -= amount;
        System.out.println("Ouch! My health is now "+health);
    }
}

class Skeleton extends Monster {

    public Skeleton(String n, int health, int attack, int defense) {
        super(n,health);
        this.attack = attack;
        this.defense = defense;
    }



}

public class OOExample {

    public static void main(String[] args) {

        Creature c = new Monster("Bob", 100);
        Monster m = new Monster("Jerry",100);
        Creature h = new Creature("Reginald") {
            @Override
            public void speak() {
                System.out.println("Eat my ass");
            }
        };
        c.myName();
        m.myName();
        h.myName();
    }

}
