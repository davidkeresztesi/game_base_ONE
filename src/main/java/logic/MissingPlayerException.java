package logic;

public class MissingPlayerException extends Exception{

    public MissingPlayerException(String message){
        super(message);
    }

    public MissingPlayerException(Throwable cause){
        super(cause);
    }

    public MissingPlayerException(String message, Throwable cause){
        super(message, cause);
    }

}
