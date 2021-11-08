package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private boolean isImplantologist;

    public Dentist() {
    }

    public Dentist(String name,
                   String surname,
                   String education,
                   String birthday,
                   int experience,
                   boolean isImplantologist) {
        super(name, surname, education, birthday, experience);
        this.isImplantologist = isImplantologist;
    }

    public void makeAppointment(Patient patient) {
        if (patient.getDiagnosis().getTitle().equals("Covid-19")) {
            System.out.println("Не в этот раз");
        }
    }
}
