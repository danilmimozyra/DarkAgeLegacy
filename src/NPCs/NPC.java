package NPCs;

import items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class NPC {

    Random rd = new Random();
    protected String name;
    protected int health;
    protected final ArrayList<HashMap<Integer, Item>> drops;
    protected final ArrayList<String> phrases;


    public NPC(String name, int health) {
        this.name = name;
        this.health = health;
        drops = new ArrayList<>();
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
        if (!phrases.isEmpty()) {
            return phrases.get(rd.nextInt(phrases.size()));
        } else {
            return "He doesn't seem to talk.";
        }
    }

    public void addDrop(int dropRate, Item item) {
        HashMap<Integer, Item> temp = new HashMap<>();
        temp.put(dropRate, item);
        drops.add(temp);
    }

    public ArrayList<Item> drop() {
        ArrayList<Item> droppedItems = new ArrayList<>();
        for (HashMap<Integer, Item> map : drops) {
            for (int i : map.keySet()) {
                int j = rd.nextInt(i+1);
                if (j == i) {
                    droppedItems.add(map.get(j));
                }
            }
        }
        return droppedItems;
    }
}
