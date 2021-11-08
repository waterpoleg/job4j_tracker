package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private int expertLevel = 100;
    private int numberOfOperations;

    public Surgeon() {
    }

    public Surgeon(String name,
                   String surname,
                   String education,
                   String birthday,
                   int experience,
                   int numberOfOperations) {
        super(name, surname, education, birthday, experience);
        this.numberOfOperations = numberOfOperations;
    }

    public boolean isExpert() {
        return this.numberOfOperations >= expertLevel;
    }
}
