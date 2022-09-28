import java.time.temporal.ChronoField;
import java.time.LocalDate;
import java.time.Month;
/** 
 * Duedate calculator for CISC 3140 Labs: 
 *  
 * Lab 1: 09/28/2022
 * Lab 2: 10/26/2022
 * Lab 3: 11/23/2022
 * Lab 4: 12/7/2022
 * 
 **/
public class DueDates {

    public static void main(String[] args){
        if(args.length == 0){
            System.out.printf("\n\nPlease indicate what Lab you want the date difference for.");
        }
        else {
            String labNum = args[0];
            LocalDate now = LocalDate.now();
            int dayDiff = 0; 
            switch(labNum){
                case "1": 
                    LocalDate lab1 = LocalDate.of(2022, Month.SEPTEMBER, 28);
                    dayDiff = lab1.get(ChronoField.DAY_OF_YEAR) - now.get(ChronoField.DAY_OF_YEAR); 
                    System.out.printf("\nLab 1 is: %d days away", dayDiff);
                    break;
                case "2": 
                    LocalDate lab2 = LocalDate.of(2022, Month.OCTOBER, 26);
                    dayDiff = lab2.get(ChronoField.DAY_OF_YEAR) - now.get(ChronoField.DAY_OF_YEAR); 
                    System.out.printf("\nLab 2 is: %d days away", dayDiff);
                    break;
                case "3": 
                    LocalDate lab3 = LocalDate.of(2022, Month.NOVEMBER, 23);
                    dayDiff = lab3.get(ChronoField.DAY_OF_YEAR) - now.get(ChronoField.DAY_OF_YEAR); 
                    System.out.printf("\nLab 3 is: %d days away", dayDiff);
                    break;
                case "4": 
                    LocalDate lab4 = LocalDate.of(2022, Month.DECEMBER, 07);
                    dayDiff = lab4.get(ChronoField.DAY_OF_YEAR) - now.get(ChronoField.DAY_OF_YEAR); 
                    System.out.printf("\nLab 4 is: %d days away", dayDiff);
                    break;
                default: 
                    System.out.printf("\nCommand line argument %s is not recognized as a valid Lab number, please enter a valid number... 1,2,3,4", labNum);
                    break;
            }
        }
    }
}
