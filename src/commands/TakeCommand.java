package commands;

import main.Graph;
import main.Player;

public class TakeCommand implements Command {
    private Player player;
    private String itemName;

    public TakeCommand() {
        this.player = Graph.getInstance().getPlayer();
    }

    public void init(String userString) {
        this.itemName = userString.substring(5).trim();
    }

    public boolean execute() {
        player.takeItem(itemName);
        return false;
    }

    public String getCommandWord() {
        return "take";
    }
}
