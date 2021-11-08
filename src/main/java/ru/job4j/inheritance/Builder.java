package ru.job4j.inheritance;

public class Builder extends Engineer {
    private boolean hasWorkPermit;

    public Builder(String name,
                   String surname,
                   String education,
                   String birthday,
                   int category,
                   boolean hasWorkPermit) {
        super(name, surname, education, birthday, category);
        this.hasWorkPermit = hasWorkPermit;
    }

    public void makeBuilding(Building building) {
        if (hasWorkPermit) {
            System.out.println("Construction in progress...");
        }
    }
}
