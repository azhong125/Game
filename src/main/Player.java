package main;

import main.*;
import items.*;
import entities.*;
import commands.*;

public class Player {
    private Graph.Node location;
    private String name;
    private String description;
    public ItemContainer itemList;

    public Player(String name, String description) {
        this.name = name;
        this.description = description;
        itemList = new ItemContainer();
    }

    public Graph.Node getCurrentRoom() {
        return location;
    }

    public void setCurrentRoom(Graph.Node newRoom) {
        location = newRoom;
    }

    public boolean moveToRoom(String name) {
        if (location.getNeighbor(name) != null) {
            location = location.getNeighbor(name);
            System.out.println("Moved to " + name);
            return true;
        }
        System.out.println("You can't go to the " + name);
        return false;
    }

    public void takeItem(String itemName) {
        Item item = location.itemList.checkForItem(itemName);
        if (item != null) {
            itemList.addItem(item);
            location.itemList.removeItem(item);
            System.out.println("Took " + itemName + " from " + location.getName());
        } else {
            System.out.println(itemName + " is not in this room");
        }
    }

    public void dropItem(String itemName) {
        Item item = this.itemList.checkForItem(itemName);
        if (item != null) {
            location.itemList.addItem(item);
            this.itemList.removeItem(item);
            System.out.println("Dropped " + itemName + " at " + location.getName());
        } else {
            System.out.println("You do not have " + itemName);
        }
    }

    public void addRoom(String newRoom) {
        location.addNeighbor(newRoom);
        location.directedEdge( newRoom, location.getName());
        System.out.println(newRoom + " has been added.");
    }

}
