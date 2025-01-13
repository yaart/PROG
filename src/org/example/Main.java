package org.example;

import org.example.persons.*;
import org.example.world.*;
import org.example.items.*;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Yakov yakov = new Yakov("Яков", 17, Emotion.NEUTRAL, Location.MARKET);
        Mother mother = new Mother("Мама Якова", 52, Emotion.NEUTRAL, Location.MARKET);
        Father father = new Father("Папа Якова", 53, Emotion.NEUTRAL, Location.FATHERSHOP);
        Neighbor neighbor = new Neighbor("Соседка Галя", 65, Emotion.NEUTRAL,Location.MARKET);
        for (NameGoods name : NameGoods.values()) {
            Goods good = new Goods(String.valueOf(name), random.nextInt(11) + 1, random.nextInt(50) + 1,random.nextInt(20) + 1);
            yakov.addItemToInventory(good);
        }

    }
}
