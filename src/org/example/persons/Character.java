package org.example.persons;

import org.example.world.*;

public abstract class Character {

    private final int MAXHP = 100;

    private String name;
    private int age;
    private int hp;
    private Emotion emotion;
    private Location location;


    public Character(String name, int age, Emotion emotion, Location location) {
        this.name = name;
        this.age = age;
        this.emotion = emotion;
        this.location = location;
        setHP(MAXHP);
    }

    public abstract String hello();

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }


    public void setHP(int hp) {
        if(hp < 0)
            throw new IllegalArgumentException("HP cannot be negative");

        if(hp > MAXHP)
            hp = MAXHP;

        this.hp = hp;
    }

    public int getHP() {
        return hp;
    }


    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
        System.out.println(name + " теперь чувствует: " + emotion.toString());
    }
    public Emotion getEmotion() {
        return this.emotion;
    }

    public void setLocation(Location location){
        System.out.println(this.getName() + " приходит к " + location);
        this.location = location;

    }
    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Emotion: " + emotion;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Character h) {
            return h.getName().equals(this.getName()) && h.getAge() == this.getAge();
        }
        return false;
    }
    @Override
    public int hashCode() {
        return name.hashCode() + age + emotion.hashCode();
    }

}
