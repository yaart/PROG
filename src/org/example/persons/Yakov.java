package org.example.persons;

import org.example.interfaces.*;
import org.example.items.Goods;
import org.example.world.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Yakov extends Character implements InventoryYakov, Arguable, InteractWithCharacter, Eat, Sleep {

    private List<Goods> inventory;
    private boolean isOffend;

    public Yakov(String name, int age, Emotion emotion, Location location) {
        super(name, age, emotion, location);
        this.inventory = new ArrayList<>();

    }

    public void setOffend(boolean offend){
        this.isOffend = offend;
    }

    public boolean getOffend(){
        return isOffend;
    }

    @Override
    public String hello() {
        return "Привет, я " + this.getName() + ", учусь в ИТМО и думаю о ПСЖ.";
    }

    @Override
    public void addItemToInventory(Goods good) {
        this.inventory.add(good);
        System.out.println(getName() + " положил себе: " + good);
    }

    @Override
    public String removeRandomItemFromInventory() {
        if (inventory.isEmpty()) {
            return "У Якова ничего нет.";
        } else {
            Random random = new Random();
            int randomIndex = random.nextInt(inventory.size());
            Goods good = inventory.get(randomIndex);
            good.setCount(good.getCount() - 1);
            if (Math.random() >= 0.8) {
                return this.getName() + " уронил и разбил: " + good.getName();
            } else {
                return this.getName() + " выложил: " + good.getName();
            }
        }
    }

    @Override
    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println(getName() + " у Якова ничего нет(");
        } else {
            System.out.println(getName() + " имеет при себе:");
            for (Goods good : inventory) {
                System.out.println("- " + good);
            }
        }
    }

    @Override
    public void argue(Character other) {
        System.out.println(getName() + " ссорится с " + other.getName() + ": 'Ты даже не понимаешь, как мне тяжело!'");
        if (Math.random() <= 0.7) {
            other.setEmotion(Emotion.SAD);
        } else {
            other.setEmotion(Emotion.CONFUSED);
        }

    }

    @Override
    public void interactWith(Character other) {
        if (other.getLocation() == this.getLocation()) {
            if (other instanceof Neighbor) {
                if (other.getEmotion() == Emotion.ANGRY) {
                    System.out.println(getName() + " расстривается. " + other.getName() + " осыпают его бранью.");
                    this.setEmotion(Emotion.SAD);
                } else if (other.getEmotion() == Emotion.NEUTRAL) {
                    System.out.println(getName() + " в смятении. " + other.getName() + " слегка ругает его.");
                    this.setEmotion(Emotion.CONFUSED);
                }
            }
            if (other instanceof Mother) {
                System.out.println(getName() + " пытается найти мать.");
            }
        } else {
            System.out.println(this.getName() + " не встречает " + other.getName());
        }
    }

    @Override
    public void eat() {
        System.out.println(this.getName() + " хорошо покушал");
        this.setHP(this.getHP() + 10);
        if (Math.random() <= 0.1){
            this.setEmotion(Emotion.HAPPINESS);}
    }

    @Override
    public void sleep() {
        System.out.println(this.getName() + " поспал");
        this.setHP(this.getHP() + 50);
        if (Math.random() <= 0.1){
            this.setEmotion(Emotion.NEUTRAL);}
    }
}
