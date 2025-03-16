package commands;

import items.player.Player;
import mapState.MapState;

public class Block extends Command {

    private String command;
    private boolean block = false;

    @Override
    public String execute(MapState mapS, Player player) {
        if (command.equals("check")) {
            if (block) {
                block = false;
                player.setDefence(-10);
            }
            command = "block";
            return "checking def";
        } else {
            if (!block) {
                block = true;
                player.setDefence(10);
            }
            return "You are now blocking the next shot.";
        }
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
