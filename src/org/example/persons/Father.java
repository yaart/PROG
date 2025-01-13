package org.example.persons;


import org.example.interfaces.Repair;
import org.example.world.Emotion;
import org.example.world.Location;

public record Father(String name, int age, Emotion emotion, Location location) implements Repair {

    @Override
    public void repair() {
        System.out.println(this.name + " чинит обувь");
    }

    public void drink(){
        System.out.println(this.name + " размышляет о жизни...");
    }
}
