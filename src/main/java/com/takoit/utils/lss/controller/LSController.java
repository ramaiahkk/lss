package com.takoit.utils.lss.controller;

import com.takoit.utils.lss.request.LCSRequest;
import com.takoit.utils.lss.response.LCSResponse;
import com.takoit.utils.lss.response.LSValue;
import com.takoit.utils.lss.request.SetOfString;
import com.takoit.utils.lss.service.LCSService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Data
public class LSController {
    @Autowired
    private LCSService lcsService;

    public LCSService getLcsService() {
        return lcsService;
    }

    public void setLcsService(LCSService lcsService) {
        this.lcsService = lcsService;
    }

    @PostMapping(value = "/lcs", produces = "application/json")
    public LCSResponse getLcs(@RequestBody LCSRequest request) {
        LCSResponse response = new LCSResponse();
        response.setLcs(new ArrayList<>());
        List<String> resp = lcsService.getLongestSubstrings(request.getSetOfStrings().stream().map(SetOfString::getValue).collect(Collectors.toList()));
        if (resp != null && resp.size() > 0) {
            resp.forEach(x -> response.getLcs().add(new LSValue(x)));
        }
        return response;
    }
}
