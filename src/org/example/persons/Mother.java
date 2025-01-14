package org.example.persons;

import org.example.interfaces.InteractWithCharacter;
import org.example.world.*;

public class Mother extends Character implements InteractWithCharacter {

    public Mother(String name, int age, Emotion emotion, Location location) {
        super(name, age, emotion, location);
    }

    @Override
    public String hello() {
        return "Привет, я " + this.getName() + ", торгую на рынке вместе с сыном.";
    }

    @Override
    public void interactWith(Character other) {
        if (other.getLocation() == this.getLocation()) {
            if (other instanceof Yakov){
                if (((Yakov) other).getOffend()){
                    System.out.println(this.getName() + " не узнает " + other.getName());
                    other.setEmotion(Emotion.CONFUSED);
                } else{
                    System.out.println(this.getName() + " узнает " + other.getName());
                }

            }
        } else {
            System.out.println(this.getName() + " не встречает " + other.getName());
        }
    }
}