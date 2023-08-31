package HP35;

import HP35.ItemType;

public class Item {
    private ItemType type;
    private int value = 0;

    public Item(ItemType type){
        this.type = type;
    }

    public Item(int value){
        this.type = ItemType.VALUE;
        this.value = value;
    }


    public static Item Mul() {
        return new Item(ItemType.MUL);
    }

    public static Item Add() {
        return new Item(ItemType.ADD);
    }


    public ItemType type(){
        return this.type;
    }

    public int value(){
        return this.value;
    }

    public static Item Value(int x){
        return new Item(x);
    }
}
