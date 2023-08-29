package commands;

import java.util.ArrayList;

public class CommandParser {
    private ArrayList<Command> commands;

    public CommandParser() {
        commands = new ArrayList<>();
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public Command parseCommandString(String string) {
        String[] words = string.split(" ");
        String first = words[0];

        for (int i = 0; i < commands.size(); i++) {
            if (first.equals(commands.get(i).getCommandWord())) {
                return commands.get(i);
            }
        }
        return null;
    }

    public void displayCommands() {
        System.out.println("Go to a room by typing 'go <room name>'");
        System.out.println("Look at rooms you can go to by typing 'look'");
        System.out.println("Add a room by typing 'add room <room name>'");
        System.out.println("Take an item by typing 'take <item name>'");
        System.out.println("Drop an item by typing 'drop <item name>'");
        System.out.println("Quit by typing 'quit'");
    }
}
