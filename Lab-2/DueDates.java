
//LocalDate is used to represent the date
import java.time.LocalDate;
//DateTimeFormatter the dates and converts to a string with a specified format
import java.time.format.DateTimeFormatter;
//ChronoField enum containing different units of time
import java.time.temporal.ChronoField;
//Locale is used to portray different areas of the world 
import java.util.Locale;
//Scanner class
import java.util.Scanner;

public class DueDates {
    // private method from the DateTimeFormatter class to format the date as
    // MM/dd/uuuu
    private final static DateTimeFormatter DEFAULT_FORMAT = DateTimeFormatter.ofPattern("MM/dd/uuuu", Locale.US);
    // private method from the LocalDate class to store the current date from the
    // system clock in the default time-zone
    private final static LocalDate NOW = LocalDate.now();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int userInput = 0;
        // do while loop
        do {
            // prints out the getMenu method
            System.out.println(getMenu());
            // reads in the user input
            userInput = sc.nextInt();
            String input1;
            String input2;
            LocalDate date1;
            LocalDate date2;
            // chooses the case based on the userInput
            switch (userInput) {
                case 1:
                    System.out.print("\nEnter further date: ");
                    input1 = sc.next();
                    System.out.print("\nEnter closer date: ");
                    input2 = sc.next();
                    date1 = parseDateString(input1, sc);
                    date2 = parseDateString(input2, sc);
                    System.out.printf(formatReponse(date1, date2));
                    break;
                case 2:
                    System.out.print("Enter date: ");
                    input1 = sc.next();
                    date1 = parseDateString(input1, sc);
                    System.out.printf(formatReponse(date1, NOW));
                    break;
                case 3:
                    System.out.println("Select an option from the saved dates...");
                    System.out.println(getSavedDates());
                    input1 = sc.next();
                    date1 = getDateFromChoice(input1);
                    System.out.print("\nEnter date: ");
                    input2 = sc.next();
                    date2 = parseDateString(input2, sc);
                    System.out.printf(formatReponse(date1, date2));
                    break;
                case 4:
                    System.out.println("Select an option from the saved dates...");
                    System.out.println(getSavedDates());
                    input1 = sc.next();
                    date1 = getDateFromChoice(input1);
                    System.out.printf(formatReponse(date1, NOW));
                    break;
                default:
                    if (userInput == 5) {
                        System.out.println("Goodbye!");
                    } else
                        System.out.println(userInput + " Invalid option.");
                    break;
            }
        } while (userInput != 5);
        sc.close();
    }

    private static String formatReponse(LocalDate date1, LocalDate date2) {
        return String.format("\n~~~~~~~/ There is %d day(s) left... \\~~~~~~~", calcDateDiff(date1, date2));
    }

    // parseDateString used
    private static LocalDate parseDateString(String input, Scanner sc) throws Exception {
        LocalDate temp = null;
        int year;
        while (temp == null && input != "q") {
            try {
                // checks if the input is in a certain format (dd-dd/d-d)
                if (input.matches("^\\d?\\d-\\d?\\d$")) {
                    // splitting input with the -
                    String[] arr = input.split("-");
                    // assigning month with the first part of the dash(array)
                    int month = Integer.parseInt(arr[0]);
                    // assigning day with the second half of the dash(array)
                    int day = Integer.parseInt(arr[1]);
                    // if statement to see if the date inputted is less then the current date
                    if (month < NOW.get(ChronoField.MONTH_OF_YEAR) || (month == NOW.get(ChronoField.MONTH_OF_YEAR)
                            && day < NOW.get(ChronoField.DAY_OF_MONTH))) {
                        year = (NOW.get(ChronoField.YEAR) + 1);
                    } else {
                        year = NOW.get(ChronoField.YEAR);
                    }
                    temp = LocalDate.of(year, month, day);
                } else
                    temp = LocalDate.parse(input, DEFAULT_FORMAT);

            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("\nError: Invalid date entered");
                System.out.print("Enter a date in a format MM/DD/YYYY or MM-DD: ");
                input = sc.next();
            }
        }
        return temp;
    }

    private static LocalDate getDateFromChoice(String choice) {
        switch (choice) {
            case "L1":
                return LocalDate.of(2022, 9, 28);
            case "L2":
                return LocalDate.of(2022, 10, 26);
            case "L3":
                return LocalDate.of(2022, 11, 23);
            case "L4":
                return LocalDate.of(2022, 12, 7);
            case "Q1":
                return LocalDate.of(2022, 9, 14);
            case "Q2":
                return LocalDate.of(2022, 9, 28);
            case "Q3":
                return LocalDate.of(2022, 10, 26);
            case "Q4":
                return LocalDate.of(2022, 11, 16);
            case "Q5":
                return LocalDate.of(2022, 12, 7);
            case "F":
                return LocalDate.of(2022, 12, 19);
        }
        return LocalDate.now();
    }

    private static String getSavedDates() {
        return "\n\n* Labs\n\n"
                + "  (L1) Lab 1: 09/28/2022\n"
                + "  (L2) Lab 2: 10/26/2022\n"
                + "  (L3) Lab 3: 11/23/2022\n"
                + "  (L4) Lab 4: 12/7/2022\n"
                + "\n* Quizes\n\n"
                + "  (Q1) Quiz 1: 09/14/2022\n"
                + "  (Q2) Quiz 2: 09/28/2022\n"
                + "  (Q3) Quiz 3: 10/26/2022\n"
                + "  (Q4) Quiz 4: 11/16/2022\n"
                + "  (Q5) Quiz 5: 12/07/2022\n"
                + "\n~ (F) Final: 12/19/2022\n";
    }

    private static String getMenu() {
        return "\n\n-------/ Date Calculator \\-------\n"
                + "\n"
                + "Please choose one of the options below ~\n\n"
                + "(1) Subtract two specified dates\n"
                + "(2) Specified date minus today's date\n"
                + "(3) Saved date minus specified date\n"
                + "(4) Saved date minus today's date\n"
                + "(5) Quit\n"
                + "\n"
                + "Note: Saved dates are...\n"
                + "- Assignments\n"
                + "- Quizes\n"
                + "- Finals\n";
    }

    private static int calcDateDiff(LocalDate date1, LocalDate date2) {
        int correction = 0;
        int currYear = NOW.get(ChronoField.YEAR);
        if (date1.get(ChronoField.YEAR) > currYear || date2.get(ChronoField.YEAR) > currYear) {
            correction = currYear % 4 == 0 ? 366 : 365;
        }
        return correction + date1.get(ChronoField.DAY_OF_YEAR) - date2.get(ChronoField.DAY_OF_YEAR);
    }
}
