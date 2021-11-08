package ru.job4j.inheritance;

public class Engineer extends Profession {
    private int category;

    public Engineer() {
    }

    public Engineer(String name,
                    String surname,
                    String education,
                    String birthday,
                    int category) {
        super(name, surname, education, birthday);
        this.category = category;
    }

    public int getCategory() {
        return this.category;
    }
}
