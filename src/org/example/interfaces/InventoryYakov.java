package org.example.interfaces;

import org.example.items.Goods;

public interface InventoryYakov {

    void addItemToInventory(Goods good);

    String removeRandomItemFromInventory();

    void showInventory();
}