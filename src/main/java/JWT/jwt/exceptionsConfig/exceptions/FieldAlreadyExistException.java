package JWT.jwt.exceptionsConfig.exceptions;

public class FieldAlreadyExistException extends ConflictException{

    private static final String DESCRIPTION = "this value already exist ";

    public FieldAlreadyExistException(String detail) {
        super(DESCRIPTION.concat(detail));
    }
}
