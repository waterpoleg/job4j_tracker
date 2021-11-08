package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book code = new Book("Clean Code", 500);
        Book java = new Book("Java", 1350);
        Book react = new Book("React", 580);
        Book linux = new Book("Linux", 700);
        Book[] books = new Book[4];
        books[0] = code;
        books[1] = java;
        books[2] = react;
        books[3] = linux;
        for (Book book : books) {
            System.out.println(book.getName() + " : " + book.getPages());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("---");
        for (Book book : books) {
            System.out.println(book.getName() + " : " + book.getPages());
        }
        System.out.println("---");
        for (Book book : books) {
            if (book.getName().equals("Clean Code")) {
                System.out.println(book.getName() + " : " + book.getPages());
            }
        }
    }
}
