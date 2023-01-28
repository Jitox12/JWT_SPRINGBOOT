package JWT.jwt.utils.emptyInput;

import JWT.jwt.exceptionsConfig.exceptions.BadRequestException;

public class EmptyInput {

    public Boolean emptyInput(String value){
        if(value.isEmpty()) {
            throw new BadRequestException("Role does not exist");
        }
        return false;
    }
}
