import java.util.Scanner;

public class LibraryFineSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("      LIBRARY MANAGEMENT");
        System.out.println("=================================");

        // Person Details
        System.out.print("Enter Member Name: ");
        String personName = sc.nextLine();

        System.out.print("Enter Book Title: ");
        String bookTitle = sc.nextLine();

        // Book Type
        System.out.println("\nBook Type");
        System.out.println("1. Normal Book");
        System.out.println("2. Magazine");
        System.out.println("3. Journal");
        System.out.print("Choose Type: ");
        int bookType = sc.nextInt();

        System.out.print("Enter Number of Days Late: ");
        int daysLate = sc.nextInt();

        sc.nextLine(); // buffer clear

        System.out.print("Is the Book Missing? (yes/no): ");
        String isMissing = sc.nextLine();

        // Fine Calculation Based on Book Type
        int ratePerDay = 10;

        switch (bookType) {
            case 1:
                ratePerDay = 10;
                break;
            case 2:
                ratePerDay = 5;
                break;
            case 3:
                ratePerDay = 20;
                break;
            default:
                System.out.println("Invalid Type! Using Normal Book Rate.");
                ratePerDay = 10;
        }

        int fine = daysLate * ratePerDay;

        // Missing Book Penalty
        if (isMissing.equalsIgnoreCase("yes")) {
            fine += 500;
        }

        // Damaged Book
        System.out.print("Is the Book Damaged? (yes/no): ");
        String damaged = sc.nextLine();

        if (damaged.equalsIgnoreCase("yes")) {
            fine += 200;
        }

        // Book Condition Rating
        System.out.println("\nBook Condition Rating");
        System.out.println("1. Excellent");
        System.out.println("2. Good");
        System.out.println("3. Damaged");
        System.out.println("4. Heavily Damaged");
        System.out.print("Choose Rating: ");
        int rating = sc.nextInt();

        switch (rating) {
            case 1:
                break;
            case 2:
                fine += 50;
                break;
            case 3:
                fine += 200;
                break;
            case 4:
                fine += 500;
                break;
            default:
                System.out.println("Invalid Rating!");
        }

        sc.nextLine(); // buffer clear

        // Fine Payment Status
        System.out.print("\nHas the Fine Been Paid? (yes/no): ");
        String paid = sc.nextLine();

        String borrowingStatus;

        if (paid.equalsIgnoreCase("yes")) {
            borrowingStatus = "Borrowing Allowed";
        } else {
            borrowingStatus = "Borrowing Privileges Blocked";
        }

        // Book Type Name
        String typeName;

        switch (bookType) {
            case 1:
                typeName = "Normal Book";
                break;
            case 2:
                typeName = "Magazine";
                break;
            case 3:
                typeName = "Journal";
                break;
            default:
                typeName = "Unknown";
        }

        // Digital Receipt
        System.out.println("\n=================================");
        System.out.println("         LIBRARY RECEIPT");
        System.out.println("=================================");
        System.out.println("Member Name      : " + personName);
        System.out.println("Book Title       : " + bookTitle);
        System.out.println("Book Type        : " + typeName);
        System.out.println("Days Late        : " + daysLate);
        System.out.println("Book Missing     : " + isMissing);
        System.out.println("Book Damaged     : " + damaged);
        System.out.println("Total Fine       : ₹" + fine);
        System.out.println("Fine Paid        : " + paid);
        System.out.println("Status           : " + borrowingStatus);
        System.out.println("=================================");

        sc.close();
    }

    
}
