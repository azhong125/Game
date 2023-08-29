package main;

import java.util.ArrayList;
import java.util.List;
import entities.*;
import items.*;

public class Graph implements Runnable{
    private static Graph instance;
    private List<Node> nodes;
    private Player player;
    private List<GenericEntity> entityList;

    private Graph(Player player) {
        nodes = new ArrayList<Node>();
        this.player = player;
        entityList = new ArrayList<>();
    }

    public void run() {
        while(true){
            moveAllCreatures();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void addNode(String name) {
        nodes.add(new Node(name));
    }

    public void addDirectedEdge(String name1, String name2) {
        Node node1 = new Node(null);
        Node node2 = new Node(null);

        for (int i = 0; i < nodes.size(); i++) {
            if (name1.equals(nodes.get(i).getName())) node1 = nodes.get(i);
            if (name2.equals(nodes.get(i).getName())) node2 = nodes.get(i);
        }

        node1.addNeighbor(node2);
    }

    public void addUndirectedEdge(String name1, String name2) {
        Node node1 = new Node(null);
        Node node2 = new Node(null);

        for (int i = 0; i < nodes.size(); i++) {
            if (name1.equals(nodes.get(i).getName())) node1 = nodes.get(i);
            if (name2.equals(nodes.get(i).getName())) node2 = nodes.get(i);
        }

        node1.addNeighbor(node2);
        node2.addNeighbor(node1);
    }

    public Node getPlayerRoom() {
        return player.getCurrentRoom();
    }

    public Node getNode(String name) {

        for (int i = 0; i < nodes.size(); i++) {
            if (name.equals(nodes.get(i).getName())) return nodes.get(i);
        }

        return null;
    }

    public void moveAllCreatures() {
        for (int i = 0; i < entityList.size(); i++) {
            entityList.get(i).move();
        }

    }

    public void createItem(String itemName, String description, String location) {
        Item item = new Item(itemName, description);
        getNode(location).itemList.addItem(item);
    }

    public void createChicken(String location) {
        Chicken chicken = new Chicken(getNode(location));
    }

    public void createWumpus(String location) {
        Wumpus wumpus = new Wumpus(getNode(location));
    }
    public void createPopstar(String location) {
        Popstar popstar = new Popstar(getNode(location));
    }

    public Player getPlayer() {
        return player;
    }

    public static Graph getInstance() {
        return instance;
    }

    public static Graph getInstance(Player player) {
        if(instance == null) instance = new Graph(player);
        return instance;
    }

    public class Node {

        private String name;
        private ArrayList<Node> neighbors;
        public ItemContainer itemList;

        private Node(String name) {
            neighbors = new ArrayList<>();
            this.name = name;
            itemList = new ItemContainer();
        }

        public void addNeighbor(Node n) {
            neighbors.add(n);

            if (!nodes.contains(n)) {
                nodes.add(n);
            }
        }

        public void addNeighbor(String n) {
            Node newNode = new Node(n);
            neighbors.add(newNode);

            if (!nodes.contains(newNode)) {
                nodes.add(newNode);
            }
        }

        public String getNeighborNames() {
            return neighbors.toString();
        }

        public int getNumNeighbors() {
            return neighbors.size();
        }

        public Node getNeighbor(int n) {
            return neighbors.get(n);
        }

        public Node getNeighbor(String name) {

            for (int i = 0; i < neighbors.size(); i++) {
                if (neighbors.get(i).getName().equals(name)) {
                    return neighbors.get(i);
                }
            }
            return null;
        }

        public void directedEdge(String node1, String node2) {
            Graph.this.addDirectedEdge(node1, node2);
        }

        public Node getRandomNeighbor() {
            if (neighbors.size() == 0) return null;
            int neighborNum = (int) (Math.random() * neighbors.size());
            return neighbors.get(neighborNum);
        }

        public boolean containsPlayer() {
            if (getPlayerRoom() == this) return true;
            return false;
        }

        public void addEntity(GenericEntity entity) {
            entityList.add(entity);
        }

        public void getEntities() {
            for (Entity e : entityList) {
                if (e.getRoom() == this) {
                    System.out.print(e.getName() + " ");
                }
            }
        }

        public String getName() {
            return name;
        }

        public String toString() {
            return name;
        }

    }
}
