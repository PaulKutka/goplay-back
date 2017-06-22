package Exception;

public class UserAlreadyExistsException extends Exception{

    String message = "User already exist";
    public UserAlreadyExistsException() {
    }

    public String getMessage()
    {
        return message;
    }


}
