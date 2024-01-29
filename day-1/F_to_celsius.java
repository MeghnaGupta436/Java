import java.util.Scanner;

public class F_to_celsius {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter start, end, and step values
        System.out.print("Enter start Fahrenheit value: ");
        double startFahrenheit = scanner.nextDouble();

        System.out.print("Enter end Fahrenheit value: ");
        double endFahrenheit = scanner.nextDouble();

        System.out.print("Enter step size: ");
        double stepSize = scanner.nextDouble();

        // Print the table header
        System.out.println("Fahrenheit\tCelsius");
        System.out.println("-------------------------");

        // Iterate from start to end with the specified step size
        for (double fahrenheit = startFahrenheit; fahrenheit <= endFahrenheit; fahrenheit += stepSize) {
            // Convert Fahrenheit to Celsius
            double celsius = (fahrenheit - 32) * 5 / 9;

            // Print the values in tabular format
            System.out.printf("%.2f\t\t%.2f\n", fahrenheit, celsius);
        }

        // Close the scanner
        scanner.close();
    }
}
