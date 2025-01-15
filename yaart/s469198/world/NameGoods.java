package org.example.world;

public enum NameGoods {
    SPOON("ложка"),
    KNIFE("нож"),
    PLATE("тарелка"),
    POT("горшок");

    private String name;
    private NameGoods(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
