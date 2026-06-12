import java.util.*;

class User {
    String name;
    String accountType;
    String cardNumber;
    int pin;
    double balance;
    boolean locked;

    ArrayList<String> history = new ArrayList<>();

    User(String name, String accountType, String cardNumber,
         int pin, double balance) {

        this.name = name;
        this.accountType = accountType;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
        this.locked = false;
    }
}

public class ATMProject1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<User> users = new ArrayList<>();

        while (true) {

            System.out.println("\n===== ATM SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
           
            System.out.println("31. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Account Type (Savings/Current): ");
                    String type = sc.nextLine();

                    System.out.print("Card Number: ");
                    String card = sc.nextLine();

                    System.out.print("Create PIN: ");
                    int pin = sc.nextInt();

                    System.out.print("Initial Deposit: ₹");
                    double balance = sc.nextDouble();
                    sc.nextLine();

                    users.add(
                        new User(name, type, card, pin, balance)
                    );

                    System.out.println("Account Created Successfully");
                    break;

                case 2:

                    System.out.print("Enter Card Number: ");
                    String enteredCard = sc.nextLine();

                    User current = null;

                    for (User u : users) {
                        if (u.cardNumber.equals(enteredCard)) {
                            current = u;
                            break;
                        }
                    }

                    if (current == null) {
                        System.out.println("Card Not Found");
                        break;
                    }

                    if (current.locked) {
                        System.out.println("Account Locked");
                        break;
                    }

                    int attempts = 0;
                    boolean loginSuccess = false;

                    while (attempts < 3) {

                        System.out.print("Enter PIN: ");
                        int enteredPin = sc.nextInt();

                        if (enteredPin == current.pin) {
                            loginSuccess = true;
                            break;
                        }

                        attempts++;

                        System.out.println("Wrong PIN");

                        if (attempts == 3) {
                            current.locked = true;
                            System.out.println("Account Locked");
                        }
                    }

                    if (!loginSuccess)
                        break;

                    int menu;

                    do {

                        System.out.println("\n===== USER MENU =====");
                        System.out.println("1. Check Balance");
                        System.out.println("2. Deposit");
                        System.out.println("3. Withdraw");
                        System.out.println("4. Transfer");
                        System.out.println("5. Cardless Withdrawal");
                        System.out.println("6. Transaction History");
                        System.out.println("7. Change PIN");
                        System.out.println("8. Account Details");
                        System.out.println("9. Logout");

                        System.out.print("Enter Choice: ");

                        menu = sc.nextInt();

                        try {

                            switch (menu) {

                                case 1:

                                    System.out.println(
                                        "Balance: ₹" + current.balance
                                    );
                                    break;

                                case 2:

                                    System.out.print(
                                        "Deposit Amount: ₹"
                                    );

                                    double dep =
                                        sc.nextDouble();

                                    current.balance += dep;

                                    current.history.add(
                                        "Deposit ₹" + dep
                                    );

                                    System.out.println(
                                        "Deposit Successful"
                                    );

                                    break;

                                case 3:

                                    System.out.print(
                                        "Withdraw Amount: ₹"
                                    );

                                    double wd =
                                        sc.nextDouble();

                                    if (wd > current.balance) {
                                        System.out.println(
                                            "Insufficient Balance"
                                        );
                                    } else {

                                        current.balance -= wd;

                                        current.history.add(
                                            "Withdraw ₹" + wd
                                        );

                                        System.out.println(
                                            "Withdrawal Successful"
                                        );
                                    }

                                    break;

                                case 4:

                                    System.out.print(
                                        "Receiver Card Number: "
                                    );

                                    sc.nextLine();

                                    String receiver =
                                        sc.nextLine();

                                    User receiverUser = null;

                                    for (User u : users) {
                                        if (u.cardNumber.equals(receiver)) {
                                            receiverUser = u;
                                            break;
                                        }
                                    }

                                    if (receiverUser == null) {
                                        System.out.println(
                                            "Receiver Not Found"
                                        );
                                        break;
                                    }

                                    System.out.print(
                                        "Transfer Amount: ₹"
                                    );

                                    double transfer =
                                        sc.nextDouble();

                                    if (transfer > current.balance) {

                                        System.out.println(
                                            "Insufficient Balance"
                                        );

                                    } else {

                                        current.balance -= transfer;
                                        receiverUser.balance += transfer;

                                        current.history.add(
                                            "Transfer ₹" + transfer
                                        );

                                        System.out.println(
                                            "Transfer Successful"
                                        );
                                    }

                                    break;

                                case 5:

                                    int otp = 123456;

                                    System.out.println(
                                        "Generated OTP: "
                                        + otp
                                    );

                                    System.out.print(
                                        "Enter OTP: "
                                    );

                                    int enteredOtp =
                                        sc.nextInt();

                                    if (enteredOtp != otp) {

                                        System.out.println(
                                            "Invalid OTP"
                                        );

                                        break;
                                    }

                                    System.out.print(
                                        "Amount: ₹"
                                    );

                                    double amt =
                                        sc.nextDouble();

                                    if (amt > current.balance) {

                                        System.out.println(
                                            "Insufficient Balance"
                                        );

                                    } else {

                                        current.balance -= amt;

                                        current.history.add(
                                            "Cardless Withdrawal ₹"
                                            + amt
                                        );

                                        System.out.println(
                                            "Success"
                                        );
                                    }

                                    break;

                                case 6:

                                    System.out.println(
                                        "\nTransaction History"
                                    );

                                    for (String h :
                                            current.history) {

                                        System.out.println(h);
                                    }

                                    break;

                                case 7:

                                    System.out.print(
                                        "New PIN: "
                                    );

                                    current.pin =
                                        sc.nextInt();

                                    System.out.println(
                                        "PIN Changed"
                                    );

                                    break;

                                case 8:

                                    System.out.println(
                                        "Name: "
                                        + current.name
                                    );

                                    System.out.println(
                                        "Account Type: "
                                        + current.accountType
                                    );

                                    System.out.println(
                                        "Card Number: "
                                        + current.cardNumber
                                    );

                                    System.out.println(
                                        "Balance: ₹"
                                        + current.balance
                                    );

                                    break;

                                case 9:

                                    System.out.println(
                                        "Logged Out"
                                    );

                                    break;

                                default:

                                    System.out.println(
                                        "Invalid Choice"
                                    );
                            }

                        } catch (Exception e) {

                            System.out.println(
                                "Error: "
                                + e.getMessage()
                            );
                        }

                    } while (menu != 9);

                    break;

                case 3:

                    System.out.println("\n===== ADMIN =====");

                    System.out.println(
                        "Total Users: "
                        + users.size()
                    );

                    for (User u : users) {

                        System.out.println(
                            u.name
                            + " | "
                            + u.accountType
                            + " | ₹"
                            + u.balance
                        );
                    }

                    break;

                case 4:

                    System.out.println(
                        "Thank You For Using ATM"
                    );

                    System.exit(0);

                default:

                    System.out.println(
                        "Invalid Choice"
                    );
            }
        }
    }
}