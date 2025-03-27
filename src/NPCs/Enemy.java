package NPCs;

import items.player.Player;

public class Enemy extends NPC {

    protected final int damage;
    protected int defence;
    protected int attack;
    protected String[] attackCycle;
    protected int additionalDefence;

    public Enemy(String name, int health, int damage, int defence) {
        super(name, health);
        this.damage = damage;
        this.defence = defence;
        attack = 0;
    }

    public void sufferDamage(int damage) {
        int i = damage - getDefence();
        if (i < 0) {
            i = 0;
        }
        health -= i;
    }

    public void setAttackCycle(String[] attackCycle) {
        this.attackCycle = attackCycle;
    }

    public int getDefence() {
        return defence + additionalDefence;
    }

    public String attack(Player player) {
        String line = "";
        if (additionalDefence == 10) {
            additionalDefence = 0;
        }
        switch (attackCycle[attack]) {
            case "a":
                player.sufferDamage(damage);
                line = name + " has attacked you.\n";
                if (player.getHealth() > 0) {
                    line += "Your health is " + player.getHealth() + "/" + player.getMaxHealth() + ".\n";
                } else {
                    line += "You died.  L";
                }
                break;
            case "b":
                additionalDefence = 10;
                line = name + " is blocking your next shot. ";
                break;
            default:
                line += name + " is waiting for your move. ";
        }
        if (attack == attackCycle.length - 1) {
            attack = 0;
        } else {
            attack += 1;
        }
        switch (attackCycle[attack]) {
            case "a":
                line += name + " is preparing for an attack. ";
                break;
            case "b":
                line += name + " is preparing to block your next shot. ";
                break;
            default:
                line += name + " is exhausted. ";
        }
        return line;
    }
}