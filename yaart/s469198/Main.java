package org.example;

import org.example.exceptions.*;
import org.example.persons.*;
import org.example.world.*;
import org.example.items.*;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        Yakov yakov = new Yakov("Яков", 17, Emotion.NEUTRAL, Location.HOUSE);
        Mother mother = new Mother("Мама Якова", 52, Emotion.NEUTRAL, Location.HOUSE);
        Father father = new Father("Папа Якова", 53, Emotion.NEUTRAL, Location.FATHERSHOP);
        Neighbor neighbor = new Neighbor("Соседка Галя", 65, Emotion.NEUTRAL, Location.MARKET);
        PartOfDay time = PartOfDay.MORNING;

        try {
            System.out.println("В какой день недели происходит событие:\n1-ПH\t2-ВТ\t3-СР\t4-ЧТ\n5-ПТ\t6-СБ\t7-ВС");
            if (!sc.hasNextInt()) {
                throw new InvalidTypeOfArgumentException();
            }
            int choice = sc.nextInt();
            if (choice > 7 || choice <= 0) {
                throw new InvalidArgumentException();
            }
            if (choice % 2 == 1) {
                yakov.setEmotion(Emotion.ANGRY);
                System.out.println("Был обычное " + time + " " + Days.values()[choice - 1] + " " + yakov.getName() + " рано проснуля и чуствовал " +
                        yakov.getEmotion() + ", т.к. он должен был пойти с " + mother.getName() + " на " + Location.MARKET);
                System.out.println(mother.getName() + " сказала собрать товары " + yakov.getName());
                for (NameGoods name : NameGoods.values()) {
                    Goods good = new Goods(String.valueOf(name), random.nextInt(11) + 1, random.nextInt(50) + 1, random.nextInt(20) + 1);
                    yakov.addItemToInventory(good);
                }
                yakov.setLocation(Location.MARKET);
                mother.setLocation(Location.MARKET);
                System.out.println(yakov.getName() + " принимается расскладывать товары");

                while (true) {
                    Goods good = yakov.removeRandomItemFromInventory();
                    if (good == null) {
                        System.out.println(yakov.getName() + " справился с задачей");
                        mother.setEmotion(Emotion.APPROVAL);
                        break;
                    }
                    if (Math.random() <= 0.3) {
                        System.out.println(yakov.getName() + " уронил: " + good.getName());
                        System.out.println(good.getName() + " упал на ногу и " + yakov.getName() + " теряет " + good.getDamage() + " здоровья");
                        yakov.setHP(yakov.getHP() - good.getDamage());
                        System.out.println("Теперь у Якова " + yakov.getHP() + " HP");
                        if (Math.random() <= 0.1) {
                            System.out.println(mother.getName() + " забеспокоилась за " + yakov.getName());
                            System.out.println(mother.getName() + " говроит идти отдохнуть " + yakov.getName());
                            yakov.setOffend(false);
                        } else {
                            System.out.println(mother.getName() + " забеспокоилась за товар");
                            mother.setEmotion(Emotion.ANGRY);
                            System.out.println(mother.getName() + " говроит убираться прочь " + yakov.getName());
                            yakov.argue(mother);
                            yakov.setOffend(true);
                        }
                        break;
                    } else {
                        System.out.println(yakov.getName() + " выложил: " + good);
                    }
                }
                yakov.setLocation(Location.HOUSE);
                System.out.println(yakov.getName() + " считает, что ему стоит отдохнуть");
                yakov.setLocation(Location.KITCHEN);
                yakov.eat();
                yakov.setLocation(Location.BEDROOM);
                yakov.sleep();
                time = PartOfDay.AFTERNOON;
                System.out.println("Наступил " + time);
                yakov.setLocation(Location.MARKET);

                if (yakov.getOffend()) {
                    neighbor.setEmotion(Emotion.ANGRY);
                    neighbor.interactWith(yakov);
                    mother.interactWith(yakov);
                }
                else {
                    neighbor.interactWith(yakov);
                    mother.interactWith(yakov);
                }

                yakov.setLocation(Location.FATHERSHOP);
                System.out.println("Может он меня узнает");
                if (Math.random() <= 0.3){
                    time = PartOfDay.EVENING;
                    System.out.println("Наступил " + time);
                    System.out.println(yakov.getName() + " не находит " + father.name());
                } else{
                    father.repair();
                    father.drink();
                    System.out.println(yakov.getName() + " помогает отцу");
                }

            } else{
                yakov.setEmotion(Emotion.HAPPINESS);
                System.out.println("Был обычное " + time + " " + Days.values()[choice - 1] + " " + yakov.getName() + " рано проснуля и чуствовал " +
                        yakov.getEmotion() + ", т.к. он должен был пойти с " + mother.getName() + " на " + Location.MARKET);
                System.out.println(mother.getName() + " сказала собрать товары " + yakov.getName());
                System.out.println(yakov.getName() + " быстро собрал товары");
                for (NameGoods name : NameGoods.values()) {
                    Goods good = new Goods(String.valueOf(name), random.nextInt(11) + 1, random.nextInt(50) + 1, random.nextInt(20) + 1);
                    yakov.addItemToInventory(good);
                }
                yakov.setLocation(Location.MARKET);
                mother.setLocation(Location.MARKET);
                System.out.println(yakov.getName() + " принимается расскладывать товары");

                while (true) {
                    Goods good = yakov.removeRandomItemFromInventory();
                    if (good == null) {
                        System.out.println(yakov.getName() + " справился с задачей");
                        mother.setEmotion(Emotion.APPROVAL);
                        break;
                    }
                    if (Math.random() <= 0.05) {
                        System.out.println(yakov.getName() + " уронил: " + good.getName());
                        System.out.println(good.getName() + " упал на ногу и " + yakov.getName() + " теряет " + good.getDamage() + " здоровья");
                        yakov.setHP(yakov.getHP() - good.getDamage());
                        System.out.println("Теперь у Якова " + yakov.getHP() + " HP");
                        if (Math.random() <= 0.7) {
                            System.out.println(mother.getName() + " забеспокоилась за " + yakov.getName());
                            System.out.println(mother.getName() + " говроит идти отдохнуть " + yakov.getName());
                            yakov.setOffend(false);
                        } else {
                            System.out.println(mother.getName() + " забеспокоилась за товар");
                            mother.setEmotion(Emotion.ANGRY);
                            System.out.println(mother.getName() + " говроит убираться прочь " + yakov.getName());
                            yakov.argue(mother);
                            yakov.setOffend(true);
                        }
                        break;
                    } else {
                        System.out.println(yakov.getName() + " выложил: " + good);
                    }
                }
                yakov.setLocation(Location.HOUSE);
                System.out.println(yakov.getName() + " считает, что ему стоит отдохнуть");
                yakov.setLocation(Location.KITCHEN);
                yakov.eat();
                yakov.setLocation(Location.BEDROOM);
                yakov.sleep();
                time = PartOfDay.AFTERNOON;
                System.out.println("Наступил " + time);
                yakov.setLocation(Location.MARKET);

                if (yakov.getOffend()) {
                    neighbor.setEmotion(Emotion.ANGRY);
                    neighbor.interactWith(yakov);
                    mother.interactWith(yakov);
                    System.out.println("Может он меня узнает");
                }
                else {
                    yakov.interactWith(neighbor);
                    mother.interactWith(yakov);
                    System.out.println(yakov.getName() + "хочет навестить отца");
                }

                yakov.setLocation(Location.FATHERSHOP);
                if (Math.random() <= 0.6){
                    time = PartOfDay.EVENING;
                    System.out.println("Наступил " + time);
                    System.out.println(yakov.getName() + " не находит " + father.name());
                } else{
                    father.repair();
                    father.drink();
                    System.out.println(yakov.getName() + " помогает отцу");
                }
            }
        } catch (InvalidArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InvalidTypeOfArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

