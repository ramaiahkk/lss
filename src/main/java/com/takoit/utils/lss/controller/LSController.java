package com.takoit.utils.lss.controller;

import com.takoit.utils.lss.request.LCSRequest;
import com.takoit.utils.lss.response.LCSResponse;
import com.takoit.utils.lss.response.LSValue;
import com.takoit.utils.lss.request.SetOfString;
import com.takoit.utils.lss.service.LCSService;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
public class LSController {
    @Autowired
    @Getter
    @Setter
    private LCSService lcsService;

    @PostMapping(value = "/lcs", produces = "application/json")
    public LCSResponse getLcs(@Valid @RequestBody  LCSRequest request) {
        LCSResponse response = new LCSResponse();
        response.setLcs(new ArrayList<>());
        List<String> resp = lcsService.getLongestSubstrings(request.getSetOfStrings().stream().map(SetOfString::getValue).collect(Collectors.toList()));
        if (resp != null && resp.size() > 0) {
            resp.forEach(x -> response.getLcs().add(new LSValue(x)));
        }
        return response;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
