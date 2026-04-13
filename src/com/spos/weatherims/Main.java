package com.spos.weatherims;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WeatherDepartmentIMS ims = new WeatherDepartmentIMS();
        seedData(ims);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Weather Department Information Management System ===");

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addStation(scanner, ims);
                    break;
                case "2":
                    listStations(ims);
                    break;
                case "3":
                    addObservation(scanner, ims);
                    break;
                case "4":
                    showLatestObservation(scanner, ims);
                    break;
                case "5":
                    issueAlert(scanner, ims);
                    break;
                case "6":
                    listAlerts(ims);
                    break;
                case "0":
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Add Station");
        System.out.println("2. List Stations");
        System.out.println("3. Add Observation");
        System.out.println("4. Show Latest Observation by Station");
        System.out.println("5. Issue Alert");
        System.out.println("6. List Alerts");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void seedData(WeatherDepartmentIMS ims) {
        ims.addStation("ST001", "Central City", "Metro");
        ims.addStation("ST002", "Coastal Point", "Coastal");
        ims.addObservation("ST001", LocalDateTime.now().minusHours(1), 31.2, 62.0, 0.0, 12.4);
        ims.addObservation("ST002", LocalDateTime.now().minusHours(2), 28.9, 78.0, 12.5, 24.3);
    }

    private static void addStation(Scanner scanner, WeatherDepartmentIMS ims) {
        System.out.print("Station ID: ");
        String stationId = scanner.nextLine().trim();
        System.out.print("Station Name: ");
        String stationName = scanner.nextLine().trim();
        System.out.print("District: ");
        String district = scanner.nextLine().trim();

        boolean added = ims.addStation(stationId, stationName, district);
        if (added) {
            System.out.println("Station added successfully.");
        } else {
            System.out.println("Station ID already exists.");
        }
    }

    private static void listStations(WeatherDepartmentIMS ims) {
        List<Station> stations = ims.listStations();
        if (stations.isEmpty()) {
            System.out.println("No stations available.");
            return;
        }
        System.out.println("Stations:");
        for (Station station : stations) {
            System.out.println("- " + station);
        }
    }

    private static void addObservation(Scanner scanner, WeatherDepartmentIMS ims) {
        try {
            System.out.print("Station ID: ");
            String stationId = scanner.nextLine().trim();
            System.out.print("Observed At (YYYY-MM-DDTHH:MM): ");
            LocalDateTime observedAt = LocalDateTime.parse(scanner.nextLine().trim());
            System.out.print("Temperature (°C): ");
            double temperatureC = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Humidity (%): ");
            double humidity = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Rainfall (mm): ");
            double rainfall = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Wind Speed (km/h): ");
            double windSpeed = Double.parseDouble(scanner.nextLine().trim());

            boolean saved = ims.addObservation(stationId, observedAt, temperatureC, humidity, rainfall, windSpeed);
            if (saved) {
                System.out.println("Observation saved.");
            } else {
                System.out.println("Failed to save observation. Check station ID and humidity range (0-100).");
            }
        } catch (DateTimeParseException | NumberFormatException ex) {
            System.out.println("Invalid input format: " + ex.getMessage());
        }
    }

    private static void showLatestObservation(Scanner scanner, WeatherDepartmentIMS ims) {
        System.out.print("Station ID: ");
        String stationId = scanner.nextLine().trim();

        ims.getLatestObservation(stationId)
                .ifPresentOrElse(
                        observation -> System.out.println("Latest observation: " + observation),
                        () -> System.out.println("No observations found for station " + stationId));
    }

    private static void issueAlert(Scanner scanner, WeatherDepartmentIMS ims) {
        System.out.print("Region: ");
        String region = scanner.nextLine().trim();
        System.out.print("Severity (LOW/MEDIUM/HIGH/CRITICAL): ");
        String severity = scanner.nextLine().trim().toUpperCase();
        System.out.print("Alert message: ");
        String message = scanner.nextLine().trim();

        Alert alert = ims.issueAlert(region, severity, message);
        System.out.println("Alert issued: " + alert);
    }

    private static void listAlerts(WeatherDepartmentIMS ims) {
        List<Alert> alerts = ims.listAlerts();
        if (alerts.isEmpty()) {
            System.out.println("No alerts issued yet.");
            return;
        }

        System.out.println("Alerts:");
        for (Alert alert : alerts) {
            System.out.println("- " + alert);
        }
    }
}
