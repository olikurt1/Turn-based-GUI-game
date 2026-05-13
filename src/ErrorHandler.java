import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class ErrorHandler{
    public static void handleInputError(Exception e){
        if(e instanceof InputMismatchException){
            System.out.println("Wrong input type, try again.");
        }
        else if(e instanceof NumberFormatException){
            System.out.println("Invalid number format, try again.");
        }
        else if(e instanceof NoSuchElementException){
            System.out.println("No input found, try again.");
        }
        else if(e instanceof IOException){
            System.out.println("Input error occurred, please try again.");
        }
        else{
            System.out.println("Invalid input, try again.");
        }
    }
}