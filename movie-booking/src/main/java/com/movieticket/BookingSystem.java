package com.movieticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BookingSystem {
    private List<Show> shows;
    private double totalRevenue;
    private double serviceTaxTotal;
    private double swachhBharatCessTotal;
    private double krishiKalyanCessTotal;

    public BookingSystem() {
        shows = new ArrayList<>();
        totalRevenue = 0;
        serviceTaxTotal = 0;
        swachhBharatCessTotal = 0;
        krishiKalyanCessTotal = 0;
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public Show getShow(int showNumber) {
        for (Show show : shows) {
            if (show.getShowNumber() == showNumber) {
                return show;
            }
        }
        return null;
    }

    public void printTotalSales() {
        System.out.printf("Total Sales:\nRevenue: Rs. %.2f\n", totalRevenue);
        System.out.printf("Service Tax: Rs. %.2f\n", serviceTaxTotal);
        System.out.printf("Swachh Bharat Cess: Rs. %.2f\n", swachhBharatCessTotal);
        System.out.printf("Krishi Kalyan Cess: Rs. %.2f\n", krishiKalyanCessTotal);
    }

    public void bookTickets(Scanner scanner) {
        while (true) {
            System.out.print("Enter Show no: ");
            int showNumber = scanner.nextInt();
            Show show = getShow(showNumber);
            if (show == null) {
                System.out.println("Invalid Show number. Try again.");
                continue;
            }
            show.displayAvailableSeats();
            System.out.print("Enter seats: ");
            scanner.nextLine();
            String seatInput = scanner.nextLine();
            List<String> seatNumbers = Arrays.asList(seatInput.split(",\\s*"));
            if (show.bookSeats(seatNumbers)) {
                double subtotal = show.calculateSubtotal(seatNumbers);
                double serviceTax = subtotal * 0.14;
                double swachhBharatCess = subtotal * 0.005;
                double krishiKalyanCess = subtotal * 0.005;
                double total = subtotal + serviceTax + swachhBharatCess + krishiKalyanCess;

                System.out.printf("Successfully Booked - Show %d\n", showNumber);
                System.out.printf("Subtotal: Rs. %.2f\n", subtotal);
                System.out.printf("Service Tax @14%%: Rs. %.2f\n", serviceTax);
                System.out.printf("Swachh Bharat Cess @0.5%%: Rs. %.2f\n", swachhBharatCess);
                System.out.printf("Krishi Kalyan Cess @0.5%%: Rs. %.2f\n", krishiKalyanCess);
                System.out.printf("Total: Rs. %.2f\n", total);

                totalRevenue += subtotal;
                serviceTaxTotal += serviceTax;
                swachhBharatCessTotal += swachhBharatCess;
                krishiKalyanCessTotal += krishiKalyanCess;
            }
            System.out.print("Would you like to continue (Yes/No): ");
            String continueBooking = scanner.nextLine();
            if (!continueBooking.equalsIgnoreCase("Yes")) {
                break;
            }
        }
        printTotalSales();
    }

    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();

        List<Seat> show1Seats = Arrays.asList(
                new Seat("A1", Category.Platinum), new Seat("A2", Category.Platinum), new Seat("A3", Category.Platinum),
                new Seat("A4", Category.Platinum), new Seat("A5", Category.Platinum), new Seat("A6", Category.Platinum),
                new Seat("A7", Category.Platinum), new Seat("A8", Category.Platinum), new Seat("A9", Category.Platinum),
                new Seat("B1", Category.Gold), new Seat("B2", Category.Gold), new Seat("B3", Category.Gold),
                new Seat("B4", Category.Gold), new Seat("B5", Category.Gold), new Seat("B6", Category.Gold),
                new Seat("C2", Category.Silver), new Seat("C3", Category.Silver), new Seat("C4", Category.Silver),
                new Seat("C5", Category.Silver), new Seat("C6", Category.Silver), new Seat("C7", Category.Silver)
        );
        bookingSystem.addShow(new Show(1, show1Seats));

        List<Seat> show2Seats = Arrays.asList(
                new Seat("A1", Category.Platinum), new Seat("A2", Category.Platinum), new Seat("A3", Category.Platinum),
                new Seat("A4", Category.Platinum), new Seat("A5", Category.Platinum), new Seat("A6", Category.Platinum),
                new Seat("A7", Category.Platinum), new Seat("B2", Category.Gold), new Seat("B3", Category.Gold),
                new Seat("B4", Category.Gold), new Seat("B5", Category.Gold), new Seat("B6", Category.Gold),
                new Seat("C1", Category.Silver), new Seat("C2", Category.Silver), new Seat("C3", Category.Silver),
                new Seat("C4", Category.Silver), new Seat("C5", Category.Silver), new Seat("C6", Category.Silver),
                new Seat("C7", Category.Silver)
        );
        bookingSystem.addShow(new Show(2, show2Seats));

        List<Seat> show3Seats = Arrays.asList(
                new Seat("A1", Category.Platinum), new Seat("A2", Category.Platinum), new Seat("A3", Category.Platinum),
                new Seat("A4", Category.Platinum), new Seat("A5", Category.Platinum), new Seat("A6", Category.Platinum),
                new Seat("A7", Category.Platinum), new Seat("B1", Category.Gold), new Seat("B2", Category.Gold),
                new Seat("B3", Category.Gold), new Seat("B4", Category.Gold), new Seat("B5", Category.Gold),
                new Seat("B6", Category.Gold), new Seat("B7", Category.Gold), new Seat("B8", Category.Gold),
                new Seat("C1", Category.Silver), new Seat("C2", Category.Silver), new Seat("C3", Category.Silver),
                new Seat("C4", Category.Silver), new Seat("C5", Category.Silver), new Seat("C6", Category.Silver),
                new Seat("C7", Category.Silver), new Seat("C8", Category.Silver), new Seat("C9", Category.Silver)
        );
        bookingSystem.addShow(new Show(3, show3Seats));

        Scanner scanner = new Scanner(System.in);
        bookingSystem.bookTickets(scanner);
    }
}

