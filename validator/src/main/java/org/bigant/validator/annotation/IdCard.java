package org.bigant.validator.annotation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.bigant.validator.constraints.IdCardConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * 验证身份证是否合法，默认验证多个国家的证件（具体支持多少国家参照{@link IdCardType}）
 */
@Target({ElementType.FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = IdCardConstraint.class)
public @interface IdCard {

    /**
     * 默认支持 {@link IdCardType} 所有类型
     * 优先级小于 {@link #idCardPatterns()}
     */
    IdCardType[] value() default {};

    /**
     * 自定义身份证表达式
     * 如果该数组不为空则 {@link #value()} 不生效
     */
    String[] idCardPatterns() default {};

    String message() default "{org.bigant.validator.constraints.IdCard.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 身份证类型
     */
    public static enum IdCardType{
        CHINA("(?:[16][1-5]|2[1-3]|3[1-7]|4[1-6]|5[0-4])\\d{4}(?:19|20)\\d{2}(?:(?:0[469]|11)(?:0[1-9]|[12][0-9]|30)|(?:0[13578]|1[02])(?:0[1-9]|[12][0-9]|3[01])|02(?:0[1-9]|[12][0-9]))\\d{3}[\\dX])\n");
        private final String pattern;

        IdCardType(String pattern) {
            this.pattern = pattern;
        }

        public String getPattern() {
            return pattern;
        }
    }

}
