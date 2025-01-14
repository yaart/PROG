package org.example.interfaces;

import org.example.items.Goods;

public interface InventoryYakov {

    void addItemToInventory(Goods good);

    Goods removeRandomItemFromInventory();

    void showInventory();
}