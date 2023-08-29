package main;

import java.util.Scanner;
import entities.*;
import items.*;
import commands.*;

public class Main {
    private static Player player;
    private static Graph g;

    public static void main(String[] args) {

        player = new Player("player", "player");

        g = Graph.getInstance(player);

        g.addNode("hall");
        g.addNode("closet");
        g.addNode("dungeon");

        g.addUndirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "closet");

        String response = "";
        Scanner in = new Scanner(System.in);

        player.setCurrentRoom(g.getNode("hall"));

        CommandParser parser = new CommandParser();
        initCommands(parser, player);
        initItems(g);
        initEntities(g);

        new Thread(g).start();

        do {
            System.out.println("You are currently in the " + player.getCurrentRoom().getName());
            System.out.println("What do you want to do?");

            response = in.nextLine().trim();

            Command nextCommand = parser.parseCommandString(response);

            if (nextCommand != null) {
                nextCommand.init(response);
                nextCommand.execute();
            }
            else parser.displayCommands();

        } while (!response.equals("quit"));
    }

    private static void initCommands(CommandParser parser, Player player) {
        parser.addCommand(new TakeCommand());
        parser.addCommand(new LookCommand());
        parser.addCommand(new AddCommand());
        parser.addCommand(new GoCommand());
        parser.addCommand(new DropCommand());
    }

    private static void initItems(Graph graph) {
        graph.createItem("item", "item", "hall");
    }

    private static void initEntities(Graph graph) {
        graph.createChicken("hall");
        graph.createWumpus("dungeon");
        graph.createPopstar("dungeon");
    }

}
