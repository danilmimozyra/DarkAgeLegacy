package items;

import java.util.ArrayList;

public class Inventory {
    private final Item[] items;

    public Inventory() {
        items = new Item[4];
    }

    public boolean addItem(Item item){
            for (int i = 0; i < items.length; i++) {
                if (items[i] == null) {
                    items[i] = item;
                    return true;
                }
            }
            return false;
        }

    public boolean removeItem(){
        return false;
    }

    public Item[] getItems() {
        return items;
    }
}
