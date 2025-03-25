package commands;

import NPCs.NPC;
import items.Item;
import items.player.Player;
import mapState.MapState;

import java.util.ArrayList;

public class Attack extends Command {
    private String command;

    @Override
    public String execute(MapState mapS, Player player) {
        NPC n = mapS.getCurrentRoom().findNPC(command);
        if (n != null) {
            n.sufferDamage(player.getDamage());
            if (n.getHealth() <= 0) {
                ArrayList<Item> items = n.drop();
                if (items != null) {
                    for (Item item : items) {
                        mapS.getCurrentRoom().addItem(item);
                    }
                }
                mapS.getCurrentRoom().removeNPC(n);
                return killDescription(n, items);
            }
            return "You've attacked " + n.getName() + ". His remaining health is " + n.getHealth() + ".";
        }
        return "There is no such enemy";
    }

    private String killDescription(NPC n, ArrayList<Item> items) {
        String line = "You've killed " + n.getName() + ".";
        if (!items.isEmpty()) {
            line += " He dropped ";
            for (int i = 0; i < items.size(); i++) {
                line += "'" + items.get(i).getName() + "'";
                if (items.get(i).getAmount() > 1) {
                    line += "(" + items.get(i).getAmount() + ")";
                }
                if (i <= items.size() - 3) {
                    line += ", ";
                } else if (i <= items.size() - 2) {
                    line += " and ";
                } else if (i == items.size() - 1) {
                    line += ".";
                }
            }
        }
        return line;
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public void setCommand(String command) {
        this.command = command;
    }
}
