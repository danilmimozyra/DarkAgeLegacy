public abstract class Command {

    public abstract String execute();
    public abstract String execute(MapState mapS);
    public abstract boolean exit();
}
