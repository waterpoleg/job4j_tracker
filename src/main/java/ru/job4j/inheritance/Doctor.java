package ru.job4j.inheritance;

public class Doctor extends Profession {
    private int experience;

    public Doctor(String name,
                  String surname,
                  String education,
                  String birthday,
                  int experience) {
        super(name, surname, education, birthday);
        this.experience = experience;
    }

    public void heal(Patient patient) {
        Diagnosis diagnosis = new Diagnosis("Covid-19", "Spuntnik-V");
        patient.setDiagnosis(diagnosis);
    }
}
