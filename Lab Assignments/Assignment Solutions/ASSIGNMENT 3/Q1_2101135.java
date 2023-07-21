import java.util.Scanner;

class Book {
    public int bookId;
    private String bookTitle;
    private int yearOfPublication;
    private String authorName;
    private String publisherName;
    private int numberOfAvailableCopies;
    public int totalCopies;

    Book() {

    }

    Book(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public void setDetails(int id, String title, int year, String author, String publisher, int count) {
        bookId = id;
        bookTitle = title;
        yearOfPublication = year;
        authorName = author;
        publisherName = publisher;
        totalCopies = numberOfAvailableCopies = count;
    }

    public void getDetails() {
        System.out.println("Book Title:");
        System.out.println(this.bookTitle);
        System.out.println("Year of publication:");
        System.out.println(this.yearOfPublication);
        System.out.println("Author:");
        System.out.println(this.authorName);
        System.out.println("Publisher:");
        System.out.println(this.publisherName);
        System.out.println("Total copies:");
        System.out.println(this.totalCopies);
        System.out.println("Total copies left:");
        System.out.println(this.numberOfAvailableCopies);
    }

    public void issue() {
        if(this.numberOfAvailableCopies==0){
            System.out.println("No book with the given book ID is availabe now! Try with another book ID.");
        }
        else{
            numberOfAvailableCopies--;
        }
    }

    public void Return() {
        if(this.numberOfAvailableCopies==this.totalCopies){
            System.out.println("Stock of this book with given book is already full! Try with another ID.");
        }
        else{
            numberOfAvailableCopies++;
        }
    }
}

public class Q1_2101135 {
    public static void main(String[] args) {
        Book[] array = new Book[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Book();
        }

        Scanner sc = new Scanner(System.in);
        int track = 0;
        int id;
        String title;
        int year;
        String author;
        String publisher;
        int count;

        System.out.println("Welcome to Library Management System!");

        while (track <= array.length) {
            int choice;
            System.out.println("Enter your choice");
            System.out.println("1. Set Details");
            System.out.println("2. Get Details");
            System.out.println("3. Issue");
            System.out.println("4. Return");
            System.out.println("5. Exit");

            choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Enter id of the book:");
                id = sc.nextInt();
                System.out.println("Enter title of the book:");
                title = sc.next();
                System.out.println("Enter year of the book:");
                year = sc.nextInt();
                System.out.println("Enter author of the book:");
                author = sc.next();
                System.out.println("Enter publisher of the book:");
                publisher = sc.next();
                System.out.println("Enter total copies of the book:");
                count = sc.nextInt();
                array[track].setDetails(id, title, year, author, publisher, count);
                track++;
                continue;
            }

            else if (choice == 2) {
                int reqID;
                System.out.println("Enter id of the book:");
                reqID = sc.nextInt();
                int i = 0;
                while (i < array.length) {
                    if (array[i].bookId == reqID) {
                        array[i].getDetails();
                        break;
                    }
                    i++;
                }
                if (i == array.length) {
                    System.out.println("No book with the input book ID.Try again");
                    continue;
                }
                else{
                    continue;
                }
            }

            else if (choice == 3) {
                int reqID;
                System.out.println("Enter id of the book:");
                reqID = sc.nextInt();
                int i = 0;
                while (i < array.length) {
                    if (array[i].bookId == reqID) {
                        array[i].issue();
                        break;
                    }
                    i++;
                }
                if (i == array.length) {
                    System.out.println("No book with the input book ID.Try again");
                    continue;
                }
                else{
                    continue;
                }
            }

            else if (choice == 4) {
                int reqID;
                System.out.println("Enter id of the book:");
                reqID = sc.nextInt();
                int i = 0;
                while (i < array.length) {
                    if (array[i].bookId == reqID) {
                        array[i].Return();
                        break;
                    }
                    i++;
                }
                if (i == array.length) {
                    System.out.println("No book with the input book ID.Try again");
                    continue;
                }
                else{
                    continue;
                }
            }

            else if (choice == 5) {
                System.out.println("Thank you for using our Library Management System.");
                break;
            }
        }
        sc.close();
    }
}