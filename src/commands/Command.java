package commands;

import mapState.MapState;

public abstract class Command {
    private String command;

    public void setCommand(String command) {
        this.command = command;
    }

    public abstract String execute();
    public abstract String execute(MapState mapS, String direction);
    public abstract boolean exit();
}
