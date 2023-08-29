package commands;

import main.Graph;

public class LookCommand implements Command {
    private Player player;

    public LookCommand() {
        this.player = Graph.getInstance().getPlayer();
    }

    public void init(String userString) {
    }

    public boolean execute() {
        System.out.println("Rooms: " + player.getCurrentRoom().getNeighborNames());
        System.out.println("Items: " + player.getCurrentRoom().itemList.displayItems());
        System.out.print("Entities: " );
        player.getCurrentRoom().getEntities();
        System.out.println();
        return false;
    }

    public String getCommandWord() {
        return "look";
    }
}
