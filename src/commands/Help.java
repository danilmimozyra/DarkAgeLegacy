package commands;

import mapState.MapState;

public class Help extends Command{
    @Override
    public String execute() {
        return "help is here";
    }

    @Override
    public String execute(MapState mapS, String direction) {
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
