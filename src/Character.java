/**
 * Created by filipebraida on 31/05/16.
 */
public class Character {

    public Character(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    public void battle(Character enemy) {
        this.takeDamage(enemy.getAttack());
        enemy.takeDamage(this.getAttack());
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int attack) {
        this.health -= attack;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getHealth() {
        return health;
    }

    private int health;
    private int attack;
}
