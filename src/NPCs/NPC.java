package NPCs;

import java.util.ArrayList;
import java.util.Random;

public class NPC {

    Random rd = new Random();
    private String name;
    private int health;
    private final ArrayList<String> phrases;

    public NPC(String name, int health) {
        this.name = name;
        this.health = health;
        phrases = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void sufferDamage(int damage) {
        health -= damage;
    }

    public ArrayList<String> getPhrases() {
        return phrases;
    }

    public void addPhrase(String phrase) {
        if (!phrases.contains(phrase)) {
            phrases.add(phrase);
        }
    }

    public String randomPhrase(){
        return phrases.get(rd.nextInt(phrases.size()));
    }
}
