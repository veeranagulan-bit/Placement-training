import java.util.Scanner;

public class employeeBonus {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Yearly Sales (0 - 10000): ");
        int yearlySales = sc.nextInt();

        System.out.print("Enter Projects Completed (0 - 100): ");
        int projects = sc.nextInt();

        System.out.print("Enter Years of Experience (1 - 50): ");
        int experience = sc.nextInt();

        // Validation
        if (yearlySales < 0 || yearlySales > 10000) {
            System.out.println("Invalid Yearly Sales");
            return;
        }

        if (projects < 0 || projects > 100) {
            System.out.println("Invalid Projects Completed");
            return;
        }

        if (experience < 1 || experience > 50) {
            System.out.println("Invalid Years of Experience");
            return;
        }

        // Performance Score Calculation
        int performanceScore =
                (yearlySales / 1000) +
                (projects * 10) +
                (experience * 5);

        // Performance Level and Bonus
        String performance;
        int bonus;

        if (performanceScore >= 800) {
            performance = "Excellent";
            bonus = 10000;
        } else if (performanceScore >= 600) {
            performance = "Very Good";
            bonus = 7000;
        } else if (performanceScore >= 400) {
            performance = "Good";
            bonus = 5000;
        } else {
            performance = "Needs Improvement";
            bonus = 0;
        }

        // Report
        System.out.println("\n===== EMPLOYEE PERFORMANCE REPORT =====");
        System.out.println("Employee Name       : " + name);
        System.out.println("Yearly Sales        : " + yearlySales);
        System.out.println("Projects Completed  : " + projects);
        System.out.println("Years of Experience : " + experience);
        System.out.println("Performance Score   : " + performanceScore);
        System.out.println("Performance Level   : " + performance);

        if (bonus > 0) {
            System.out.println("Bonus Approved");
            System.out.println("Bonus Amount        : ₹" + bonus);
        } else {
            System.out.println("Bonus Not Approved");
        }
    }
}