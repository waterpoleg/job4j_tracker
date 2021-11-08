package ru.job4j.inheritance;

public class Diagnosis {
    private String title;
    private String treatmentMethod;

    public Diagnosis(String title, String treatmentMethod) {
        this.title = title;
        this.treatmentMethod = treatmentMethod;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTreatmentMethod() {
        return this.treatmentMethod;
    }
}
