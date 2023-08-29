package entities;

import main.Graph;

public interface Entity {

    public String getName();
    public String getDescription();
    public void move();
    public void setName(String name);
    public void setDescription(String word);
    public Graph.Node getRoom();
    public void setRoom(Graph.Node node);
    public String toString();
}
