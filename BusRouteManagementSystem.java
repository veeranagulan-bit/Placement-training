import java.util.*;

class Bus {
    private String busNumber;
    private String routeName;
    private int capacity;
    private int passengers;

    public Bus(String busNumber, String routeName, int capacity) {
        this.busNumber = busNumber;
        this.routeName = routeName;
        this.capacity = capacity;
        this.passengers = 0;
    }

    public void passengerIn(int count) {
        if (passengers + count <= capacity) {
            passengers += count;
            System.out.println(count + " passengers boarded.");
        } else {
            System.out.println("Bus Full!");
        }
    }

    public void passengerOut(int count) {
        if (count <= passengers) {
            passengers -= count;
            System.out.println(count + " passengers left.");
        } else {
            System.out.println("Invalid Count.");
        }
    }

    public int getPassengers() {
        return passengers;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getRouteName() {
        return routeName;
    }

    public int getCapacity() {
        return capacity;
    }
}

class Route {
    private String[] stops;

    public Route() {
        stops = new String[]{
                "Central Bus Stand",
                "Railway Station",
                "City Mall",
                "Airport"
        };
    }

    public void displayRoute() {
        System.out.println("\n===== BUS ROUTE =====");
        for (int i = 0; i < stops.length; i++) {
            System.out.println((i + 1) + ". " + stops[i]);
        }
    }
}

class FareSystem {
    protected double totalFare = 0;

    public void collectFare(int passengers) {
        double fare = passengers * 20;
        totalFare += fare;
        System.out.println("Fare Collected : Rs." + fare);
    }

    public double getTotalFare() {
        return totalFare;
    }
}

class PremiumFare extends FareSystem {
    @Override
    public void collectFare(int passengers) {
        double fare = passengers * 30;
        totalFare += fare;
        System.out.println("Premium Fare Collected : Rs." + fare);
    }
}

public class BusRouteManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bus bus = new Bus("TN01AB1234",
                "City Express",
                50);

        Route route = new Route();

        FareSystem fare = new FareSystem();

        int choice;

        do {

            System.out.println("\n========== BUS MANAGEMENT ==========");
            System.out.println("1. Display Bus Details");
            System.out.println("2. Display Route");
            System.out.println("3. Passenger In");
            System.out.println("4. Passenger Out");
            System.out.println("5. Current Occupancy");
            System.out.println("6. Total Fare Collection");
            System.out.println("7. Daily Report");
            System.out.println("8. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nBus Number : "
                            + bus.getBusNumber());
                    System.out.println("Route Name : "
                            + bus.getRouteName());
                    System.out.println("Capacity : "
                            + bus.getCapacity());
                    break;

                case 2:
                    route.displayRoute();
                    break;

                case 3:
                    System.out.print("Passengers Boarding: ");
                    int in = sc.nextInt();
                    bus.passengerIn(in);
                    fare.collectFare(in);
                    break;

                case 4:
                    System.out.print("Passengers Leaving: ");
                    int out = sc.nextInt();
                    bus.passengerOut(out);
                    break;

                case 5:
                    System.out.println(
                            "Current Passengers : "
                                    + bus.getPassengers());
                    break;

                case 6:
                    System.out.println(
                            "Total Fare : Rs."
                                    + fare.getTotalFare());
                    break;

                case 7:
                    System.out.println("\n===== DAILY REPORT =====");
                    System.out.println("Bus : "
                            + bus.getBusNumber());
                    System.out.println("Route : "
                            + bus.getRouteName());
                    System.out.println("Passengers : "
                            + bus.getPassengers());
                    System.out.println("Revenue : Rs."
                            + fare.getTotalFare());
                    break;

                case 8:
                    System.out.println("System Closed");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 8);

        sc.close();
    }
}