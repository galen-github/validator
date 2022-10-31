package org.bigant.validator.constraints

import org.bigant.validator.TestParent
import org.bigant.validator.annotation.IdCard
import org.junit.Test

import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator

class IdCardConstraintTest extends TestParent {

    @Test
    void defaultTest() {

        def bean = new TestBean()
        bean.setIdCard("123")
        Set<ConstraintViolation<TestBean>> validate = getValidator().validate(bean)
        println(validate.size())
        for (final def vio in validate) {
            println vio.getMessage()
        }

    }

    class TestBean {
        @IdCard()
        String idCard;
    }

}
