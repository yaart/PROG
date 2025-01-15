package org.example.items;

import java.util.Objects;

public abstract class Item {
    private final int maxCount;
    private String name;
    private int count;
    private int damage;

    public Item(String name, int maxCount, int damage) {
        if(maxCount <= 0)
            throw new IllegalArgumentException("maxCount must be greater than 0");

        if(damage <= 0)
            throw new IllegalArgumentException("damage must be greater than 0");

        this.name = name;
        this.maxCount = maxCount;
        this.count = 1;
        this.damage = damage;
    }

    public Item(String name, int maxCount, int damage, int count) {
        this(name, maxCount, damage);
        setCount(count);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if(count > this.maxCount)
            throw new IllegalArgumentException("count is greater than maxCount");
        if(count < 0)
            throw new IllegalArgumentException("count is less than 0");
        this.count = count;
    }

    public void addCount(int count) {
        setCount(count + this.getCount());
    }

    public int getMaxCount() {
        return this.maxCount;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Count: " + count + ", MaxCount: " + maxCount + ", Damage: " + damage;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;

        if(o == null)
            return false;

        if(o instanceof Item other) {
            return this.name.equals(other.name) &&
                    this.maxCount == other.maxCount &&
                    this.damage == other.damage;
        }

        if(o instanceof String str) {
            return this.name.equals(str);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count, maxCount, damage);
    }
}