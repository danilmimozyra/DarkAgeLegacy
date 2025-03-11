package commands.console;

import commands.*;
import items.player.Player;
import mapState.MapState;

import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private Scanner sc = new Scanner(System.in);
    private final MapState mapState;
    private HashMap <String, Command> commands;
    private Player player;

    public Console() {
        initialiseCommands();
        mapState = new MapState();
    }

    private void initialiseCommands(){
        commands = new HashMap<>();
        commands.put("go", new Go());
        commands.put("help", new Help());
        commands.put("tip", new Tip());
        commands.put("take", new Take());
        commands.put("put", new Put());
        commands.put("use", new Use());
        commands.put("talk", new Talk());
        commands.put("attack", new Attack());
        commands.put("block", new Block());
        commands.put("leave", new Leave());
    }

    public void start(){
        System.out.println("You are now in " + mapState.getCurrentRoom().getName());
        String line = "";
        do {
            line = sc.nextLine().trim().toLowerCase();
            try {
                System.out.println(commands.get(line).execute());
            } catch (Exception e){
                try {
                    String[] lines = line.split("[ ]+");
                    System.out.println(commands.get(lines[0]).execute(mapState, lines[1]));
                } catch (IndexOutOfBoundsException e1){
                    System.out.println("I don't know what to do.");
                }
            }
        } while (!line.equals("exit"));
    }
}