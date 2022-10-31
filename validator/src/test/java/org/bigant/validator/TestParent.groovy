package org.bigant.validator

import javax.validation.Validation
import javax.validation.Validator


class TestParent {

    static Validator getValidator(){
        return Validation.buildDefaultValidatorFactory()
                .getValidator();
    }

}
