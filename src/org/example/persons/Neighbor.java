package org.example.persons;

import org.example.interfaces.InteractWithCharacter;
import org.example.world.Emotion;
import org.example.world.Location;

public class Neighbor extends Character implements InteractWithCharacter {

    public Neighbor(String name, int age, Emotion emotion, Location location) {
        super(name, age, emotion, location);
    }

    @Override
    public String hello() {
        return "Привет, я " + this.getName() + "как мне надоели соседи.";
    }

    @Override
    public void interactWith(Character other) {
        if (other.getLocation() == this.getLocation()) {
            if (other instanceof Yakov){
                System.out.println(other.getName() + " тебе " + other.getAge() + ". Как ты можешь себя так вести.");
                if(Math.random() <= 0.1){
                    other.setHP(other.getHP() - 10);
                    System.out.println(other.getName() + "теряет 10 здоровья");
                }
                other.setEmotion(Emotion.CONFUSED);
            }
        } else {
            System.out.println(this.getName() + " не встречает " + other.getName());
        }

    }
}
