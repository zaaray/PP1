import java.util.InputMismatchException;

public class InvalidInfoException extends InputMismatchException {
     /*
    Method that throws InvalidSeatException messages
    no param
    no return value
    */
    public InvalidInfoException(){
        super("Invalid Rating.");
    }
     /*
    Method that throws InvalidSeatException messages
    @param message for the specific message 
    no return value
    */
    public InvalidInfoException(String message){
        super(message);
    }

}