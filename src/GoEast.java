public class GoEast extends Command{
    @Override
    public String execute() {
        return null;
    }

    @Override
    public String execute(MapState mapS) {
        int id = mapS.getCurrentRoom().getEastRoom();
        if (id != 0) {
            mapS.setCurrentRoom(mapS.getMap().get(id));
            return "You are now in " + mapS.getCurrentRoom().getName();
        } else {
            return "This room doesn't have an entrance there!";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
