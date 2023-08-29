package commands;

import main.Graph;

public class DropCommand implements Command {
    private Player player;
    private String itemName;

    public DropCommand() {
        this.player = Graph.getInstance().getPlayer();
    }

    public void init(String userString) {
        this.itemName = userString.substring(5).trim();
    }

    public boolean execute() {
        player.dropItem(itemName);
        return false;
    }

    public String getCommandWord() {
        return "drop";
    }
}
