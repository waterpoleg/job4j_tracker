package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
         this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Active: " + this.active);
        System.out.println("Status: " + this.status);
        System.out.println("Message: " + this.message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error errorExtended = new Error(true, 1, "Extended error true message");
        Error errExtended = new Error(false, 0, "Extended error false message");
        error.printInfo();
        System.out.println("-");
        errorExtended.printInfo();
        System.out.println("-");
        errExtended.printInfo();
    }
}
