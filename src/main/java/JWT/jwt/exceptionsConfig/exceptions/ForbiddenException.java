package JWT.jwt.exceptionsConfig.exceptions;

public class ForbiddenException extends RuntimeException{

    private static final String DESCRIPTION = "Forbidden instance ";

    public ForbiddenException(String detail){
        super(DESCRIPTION.concat(detail));
    }
}
