package items;

import java.util.ArrayList;

public class ItemContainer {
    private ArrayList<Item> itemList;

    public ItemContainer() {
        itemList = new ArrayList<>();
    }

    public String displayItems() {
        return itemList.toString();
    }

    public void addItem(String name) {
        itemList.add(new Item(name, null));
    }

    public void addItem(String name, String description) {
        itemList.add(new Item(name, description));
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void removeItem(Item item) {
        itemList.remove(item);
    }

    public Item checkForItem(String name) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getName().equals(name)) {
                return itemList.get(i);
            }
        }
        return null;
    }
}
