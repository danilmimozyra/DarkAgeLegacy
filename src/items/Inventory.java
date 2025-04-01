package items;

/**
 * Player's inventory
 */
public class Inventory {
    private final Item[] items;

    public Inventory() {
        items = new Item[4];
    }

    /**
     * @param item is an Item that being added
     * @return true if the item was added
     */
    public boolean addItem(Item item) {
        if (item.isStackable()) {
            for (int i = 0; i < items.length; i++) {
                if (items[i] != null) {
                    if (item.getName().equals(items[i].getName())) {
                        items[i].changeAmount(item.getAmount());
                        return true;
                    }
                }
            }
        }
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                return true;
            }
        }
        return false;
    }

    public Item[] getItems() {
        return items;
    }

    /**
     * @return String with the information about the inventory
     */
    public String description(){
        String line = "You have ";
        for(int i = 0; i < items.length; i++){
            if (items[i] != null) {
                line += items[i].description();
                if (i == getSize()-1) {
                    line += ".";
                } else {
                    line += ", ";
                }
            }
        }
        if (line.equals("You have ")) {
            line += "nothing in your inventory.";
        }
        return line;

    }

    public int getSize(){
        int i = 0;
        for (Item item : items) {
            if (item != null) {
                i += 0;
            }
        }
        return i;
    }
}
