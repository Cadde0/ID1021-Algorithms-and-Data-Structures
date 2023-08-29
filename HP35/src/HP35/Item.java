package HP35;

import HP35.ItemType;

public class Item {
    private ItemType type;
    private int value = 0;

    public Item(ItemType type){
        this.type = type;
    }

    public ItemType type(){
        return this.type;
    }

    public int value(){
        return this.value;
    }
}
