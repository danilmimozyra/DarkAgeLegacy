package commands.console;

import commands.*;
import items.player.Player;
import mapState.MapState;

import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private final Scanner sc;
    private final MapState mapState;
    private HashMap <String, Command> commands;
    private final Player player;
    private boolean exit;

    public Console() {
        initialiseCommands();
        sc = new Scanner(System.in);
        player = new Player();
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
        System.out.println(commands.get("help").execute(mapState, player));
        System.out.println(mapState.getCurrentRoom().getName());
        String line = "";
        do {
            commands.get("block").setCommand("check");
            commands.get("block").execute(mapState, player);
            line = sc.nextLine().trim().toLowerCase();
            try {
                System.out.println(commands.get(line).execute(mapState, player));
                exit = commands.get(line).exit();
            } catch (NullPointerException e){
                try {
                    String[] lines = line.split("[ ]+");
                    commands.get(lines[0]).setCommand(lines[1]);
                    System.out.println(commands.get(lines[0]).execute(mapState, player));
                    exit = commands.get(lines[0]).exit();
                } catch (Exception e1){
                    System.out.println("You seem confused.");
                }
            }
        } while (!exit);
    }
}