package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Martin");
        student.setGroup("High");
        student.setDate("1 September 1980");
        System.out.println(student.getName() + " enrolled to "
                        + student.getGroup() + " group at "
                        + student.getDate());
    }
}
