package org.example.persons;


import org.example.interfaces.Repairable;
import org.example.world.Emotion;
import org.example.world.Location;

public record Father(String name, int age, Emotion emotion, Location location) implements Repairable {

    @Override
    public void repair() {
        System.out.println(this.name + " чинит обувь");
    }

    public void drink(){
        System.out.println(this.name + " размышляет о жизни...");
    }
}
