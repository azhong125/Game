package commands;

import main.Graph;

public class AddCommand implements Command {
    private Player player;
    private String roomName;

    public AddCommand() {
        this.player = Graph.getInstance().getPlayer();
    }

    public void init(String userString) {
        this.roomName = userString.substring(4).trim();
    }

    public boolean execute() {
        player.addRoom(roomName);
        return false;
    }

    public String getCommandWord() {
        return "add";
    }
}
