package org.bigant.validator

import javax.validation.Validation


class TestParent {

    Validation getValidator(){
        return Validation.buildDefaultValidatorFactory()
                .getValidator() as Validation;
    }

}
