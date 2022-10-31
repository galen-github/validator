package org.bigant.validator.constraints;

import org.bigant.validator.annotation.IdCard;
import org.bigant.validator.util.VF;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 身份证校验实现，此类型支持多个国家的身份证
 */
public class IdCardConstraint implements ConstraintValidator<IdCard, String> {

    private IdCard idCard;

    /**
     * 默认的身份证表达式
     */
    private static final String[] DEFAULT_PATTERNS ;

    static {
        DEFAULT_PATTERNS = Arrays.stream(IdCard.IdCardType.values())
                .map(IdCard.IdCardType::getPattern)
                .collect(Collectors.toSet())
                .toArray(new String[IdCard.IdCardType.values().length]);
    }

    @Override
    public void initialize(IdCard idCard) {
        this.idCard = idCard;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        String[] patterns = VF.isEmpty(idCard.idCardPatterns())
                ? idCard.idCardPatterns()
                : DEFAULT_PATTERNS;

        return VF.matchesAny(patterns,value);
    }
}
