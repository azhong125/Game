package entities;

import main.Graph;

public class Chicken extends GenericEntity {

    public Chicken(Graph.Node room) {
        super("chicken");
        this.description = "a chicken";
        setRoom(room);
        room.addEntity(this);
    }

    public void move() {
        Graph.Node next = this.getRoom().getRandomNeighbor();
        move(next);
    }
}
