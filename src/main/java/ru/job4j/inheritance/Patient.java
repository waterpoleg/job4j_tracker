package ru.job4j.inheritance;

public class Patient {
    private String name;
    private Diagnosis diagnosis;

    public String getName() {
        return this.name;
    }

    public Diagnosis getDiagnosis() {
        return this.diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }
}
