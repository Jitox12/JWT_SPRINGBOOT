package JWT.jwt.exceptionsConfig.exceptions;

public class ConflictException extends RuntimeException{

    private static final String DESCRIPTION = "Bad Request ";

    public ConflictException(String detail){
        super(DESCRIPTION.concat(detail));
    }
}
