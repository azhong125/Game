package entities;

import main.Graph;

public abstract class GenericEntity implements Entity {
    protected String name, description;
    protected Graph.Node currentRoom;

    public GenericEntity(String name) {
        this.name = name;
        this.description = "";
        this.currentRoom = null;
    }

    public Graph.Node getRoom() {
        return currentRoom;
    }

    public String getName(){
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setRoom(Graph.Node room) {
        currentRoom = room;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String word) {
        description = word;
    }

    public String toString() {
        return name;
    }

    public abstract void move();

    protected void move(Graph.Node next) {
        if (next != null) {
            setRoom(next);
        }


    }

}
