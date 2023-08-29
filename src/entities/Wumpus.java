package entities;

import main.*;
import items.*;
import entities.*;
import commands.*;
public class Wumpus extends GenericEntity {

    public Wumpus(Graph.Node room) {
        super("wumpus");
        this.description = "a wumpus";
        setRoom(room);
        room.addEntity(this);
    }

    public void move() {
        for (int i = 0; i < getRoom().getNumNeighbors(); i++) {
            Graph.Node neighbor = getRoom().getNeighbor(i);
            if (!neighbor.containsPlayer()) {
                move(neighbor);
            }
        }
    }
}
