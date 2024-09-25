import java.util.Scanner;

public class TravelItineraryPlanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Travel Itinerary Planner!");

        System.out.print("Enter your destination: ");
        String destination = scanner.nextLine();

        System.out.print("Enter your travel dates (e.g., 2024-10-01 to 2024-10-10): ");
        String dates = scanner.nextLine();

        System.out.print("Enter your preferences (activities, budget, etc.): ");
        String preferences = scanner.nextLine();

        System.out.print("Enter your total budget (in USD): ");
        double budget = scanner.nextDouble();

        // Calculate number of days
        int numberOfDays = calculateDays(dates);
        double dailyBudget = budget / numberOfDays;

        // Display the itinerary
        displayItinerary(destination, dates, preferences, budget, dailyBudget);

        // Optional: Call external APIs for maps and weather (not implemented here)

        scanner.close();
    }

    private static int calculateDays(String dates) {
        String[] dateRange = dates.split(" to ");
        String startDateString = dateRange[0].trim();
        String endDateString = dateRange[1].trim();

        // Convert strings to Date objects
        try {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Date startDate = sdf.parse(startDateString);
            java.util.Date endDate = sdf.parse(endDateString);

            long difference = endDate.getTime() - startDate.getTime();
            return (int) (difference / (1000 * 60 * 60 * 24)) + 1; // Include both start and end dates
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return 0;
        }
    }

    private static void displayItinerary(String destination, String dates, String preferences, double budget, double dailyBudget) {
        System.out.println("\n--- Your Travel Itinerary ---");
        System.out.printf("Destination: %s%n", destination);
        System.out.printf("Dates: %s%n", dates);
        System.out.printf("Preferences: %s%n", preferences);
        System.out.printf("Total Budget: $%.2f%n", budget);
        System.out.printf("Daily Budget: $%.2f%n", dailyBudget);
    }
}
