package commands;

import main.Graph;

public class GoCommand implements Command {
    private Player player;
    private String nextRoom;

    public GoCommand() {
        this.player = Graph.getInstance().getPlayer();
    }

    public void init(String userString) {
        this.nextRoom = userString.substring(3).trim();
    }

    public boolean execute() {
        player.moveToRoom(nextRoom);
        return false;
    }

    public String getCommandWord() {
        return "go";
    }
}
