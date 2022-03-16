package com.spring.springmvcxml.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        ConstraintValidator.super.initialize(courseCode);
        coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext arg1) {
        boolean result;
        if(code!=null) {
            result = code.startsWith(coursePrefix);
        } else {
            result = true;
        }
        return result;
    }
    // https://gist.github.com/darbyluv2code/0275ddb6e70e085a10fd464e36a42739 - for multiple sequences
}
