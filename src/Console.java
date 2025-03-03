import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private Scanner sc = new Scanner(System.in);
    private MapState mapState;
    private HashMap <String, Command> commands;

    public Console() {
        initialiseCommands();
        mapState = new MapState();
    }

    private void initialiseCommands(){
        commands = new HashMap<>();
        commands.put("west", new GoWest());
        commands.put("north", new GoNorth());
        commands.put("east", new GoEast());
        commands.put("south", new GoSouth());
    }

    public void start(){
        System.out.println("You are now in " + mapState.getCurrentRoom().getName());
        String line = "";
        do {
            line = sc.nextLine().trim().toLowerCase();
            System.out.println(commands.get(line).execute(mapState));
        } while (!line.equals("exit"));
    }
}