package commands;

import NPCs.NPC;
import items.player.Player;
import mapState.MapState;

public class Attack extends Command{
    private String command;

    @Override
    public String execute(MapState mapS, Player player) {
        NPC n = mapS.getCurrentRoom().findNPC(command);
        if (n != null) {
            n.sufferDamage(player.getDamage());
            if (n.getHealth() <= 0) {
                mapS.getCurrentRoom().removeNPC(n);
                return "You've killed " + n.getName() + ".";
            }
            return "You've attacked " + n.getName() + ". His remaining health is " + n.getHealth() + ".";
        }
        return "There is no such enemy";
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
