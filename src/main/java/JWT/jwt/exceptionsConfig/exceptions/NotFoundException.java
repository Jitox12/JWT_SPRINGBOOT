package JWT.jwt.exceptionsConfig.exceptions;

public class NotFoundException extends RuntimeException{
    private static final String DESCRIPTION = "Not Found ";

    public NotFoundException(String detail){
        super(DESCRIPTION.concat(detail));
    }
}
