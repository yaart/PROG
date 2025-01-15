package org.example.world;

public enum Emotion {
    NEUTRAL("нейтральное"),
    APPROVAL("одобрение"),
    ANGRY("злость"),
    SAD("грусть"),

    HAPPINESS("счастье"),
    CONFUSED("озадаченность");

    private String name;
    private Emotion(String name) {
        this.name=name;
    }

    @Override
    public String toString() {
        return name;
    }
}