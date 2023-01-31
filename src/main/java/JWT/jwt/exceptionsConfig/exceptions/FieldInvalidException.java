package JWT.jwt.exceptionsConfig.exceptions;

public class FieldInvalidException extends BadRequestException{

    private static final String DESCRIPTION = "this field is invalid: ";

    public FieldInvalidException(String detail) {
        super(DESCRIPTION.concat(detail));
    }
}
