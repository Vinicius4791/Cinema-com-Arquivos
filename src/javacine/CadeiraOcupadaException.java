package javacine;

public class CadeiraOcupadaException extends Exception{
    
    @Override
    public String getMessage() {
        return "Essa cadeira já está ocupada";
    }
}
