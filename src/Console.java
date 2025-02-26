import java.util.Scanner;

public class Console {

    private Scanner sc = new Scanner(System.in);
    private MapState mapState;

    public Console() {
        mapState = new MapState();
    }

    public void start(){
        System.out.println("You are now in " + mapState.getCurrentRoom().getName());
        String line = "";
        do {
            line = sc.nextLine();
            System.out.println(mapState.setCurrentRoom(line));
        } while (!line.equals("exit"));
    }
}