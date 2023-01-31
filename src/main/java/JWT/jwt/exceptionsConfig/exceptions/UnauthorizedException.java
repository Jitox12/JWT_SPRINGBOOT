package JWT.jwt.exceptionsConfig.exceptions;

public class UnauthorizedException extends RuntimeException{

    private static final String DESCRIPTION = "User do not have authorization ";

    public UnauthorizedException(String detail){
        super(DESCRIPTION.concat(detail));
    }
}
