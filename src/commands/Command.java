package commands;

public interface Command {

    public void init(String userString);

    public boolean execute();

    public String getCommandWord();

}
