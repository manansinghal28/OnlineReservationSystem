import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class OnlineReservationSystem {

    private static HashMap<String, String> loginCredentials = new HashMap<>();

    private static ArrayList<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("\n===== Online Reservation System =====");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();


        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Reservation System");
            System.out.println("2. Cancellation Form");
            System.out.println("3. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    reserveTicket();
                    break;
                case 2:
                    cancelTicket();
                    break;
                case 3:
                    System.out.println("Thank you for using the Online Reservation System!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void reserveTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n===== Reservation System =====");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();
        System.out.print("Enter your phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();
        System.out.print("Enter class type (e.g. AC, Non-AC): ");
        String classType = scanner.nextLine();
        System.out.print("Enter date of journey (dd/mm/yyyy): ");
        String date = scanner.nextLine();
        System.out.print("Enter source station: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination station: ");
        String destination = scanner.nextLine();
        System.out.print("Enter number of tickets: ");
        int numTickets = scanner.nextInt();

        Reservation reservation = new Reservation(name, age, email, phone, trainNumber, classType, date, source, destination, numTickets);
        reservations.add(reservation);

        System.out.println("\nReservation successful! Your PNR number is: " + reservation.getPnr());
    }

    private static void cancelTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n===== Cancellation Form =====");
        System.out.print("Enter PNR number: ");
        String pnr = scanner.nextLine();

        Reservation reservation = null;
        for (Reservation r : reservations) {
            if (r.getPnr().equals(pnr)) {
                reservation = r;
                break;
            }
        }
        if (reservation != null) {
            reservation.cancel();
            reservations.remove(reservation);
            System.out.println("\nReservation cancelled successfully!");
        } else {
            System.out.println("\nInvalid PNR number!");
        }
    }
}

class Reservation {
    private static int nextPnr = 1;

    private String name;
    private int age;
    private String email;
    private String phone;
    private String trainNumber;
    private String classType;
    private String date;
    private String source;
    private String destination;
    private int numTickets;
    private String pnr;
    private boolean cancelled;

    public Reservation(String name, int age, String email, String phone, String trainNumber, String classType, String date, String source, String destination, int numTickets) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.trainNumber = trainNumber;
        this.classType = classType;
        this.date = date;
        this.source = source;
        this.destination = destination;
        this.numTickets = numTickets;
        this.pnr = "PNR" + nextPnr;
        this.cancelled = false;
        nextPnr++;
    }

    public String getPnr() {
        return pnr;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void cancel() {
        this.cancelled = true;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", trainNumber='" + trainNumber + '\'' +
                ", classType='" + classType + '\'' +
                ", date='" + date + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", numTickets=" + numTickets +
                ", pnr='" + pnr + '\'' +
                ", cancelled=" + cancelled +
                '}';
    }
}