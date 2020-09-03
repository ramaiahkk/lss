package com.takoit.utils.lss.validation;

import com.takoit.utils.lss.request.SetOfString;
import org.springframework.stereotype.Component;


import javax.validation.*;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LCSRequestValidator implements ConstraintValidator<ValidateLCS, List<SetOfString>> {


    @Override
    public boolean isValid(List<SetOfString> setOfStrings, ConstraintValidatorContext constraintValidatorContext) {
        return setOfStrings.stream().filter(x -> x == null || x.getValue() == null || x.getValue().length() == 0).map(x -> x.getValue()).collect(Collectors.toSet()).size() != setOfStrings.size();
    }

}
