import java.util.Calendar;
import java.util.Scanner;

public class CalculateAge {
    public static void main(String[] args) {
        int birthYear, currentYear, age;

        // Get the current year using the Calendar class
        Calendar calendar = Calendar.getInstance();
        currentYear = calendar.get(Calendar.YEAR);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your birth year: ");
        birthYear = scanner.nextInt();

        // Calculate the age
        age = currentYear - birthYear;

        // Display the result
        System.out.println("Your age is " + age + " years.");

        scanner.close();
    }
}
