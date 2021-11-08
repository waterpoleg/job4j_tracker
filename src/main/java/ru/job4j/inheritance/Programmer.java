package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String specialization;

    public Programmer(String name,
                      String surname,
                      String education,
                      String birthday,
                      int category,
                      String specialization) {
        super(name, surname, education, birthday, category);
        this.specialization = specialization;
    }

    public void hire(Project project, double salary) {
    }
}
