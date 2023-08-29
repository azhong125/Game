package entities;

import main.Graph;

public class Popstar extends GenericEntity {

    public Popstar(Graph.Node room) {
        super("popstar");
        this.description = "a popstar";
        setRoom(room);
        room.addEntity(this);
    }

    public void move() {
        for (int i = 0; i < getRoom().getNumNeighbors(); i++) {
            if (getRoom().getNeighbor(i).containsPlayer()) {
                move(getRoom().getNeighbor(i));
            }
        }
    }
}
