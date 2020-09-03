package com.takoit.utils.lss.controller;

import com.takoit.utils.lss.request.LCSRequest;
import com.takoit.utils.lss.request.SetOfString;
import com.takoit.utils.lss.response.LCSResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.util.ArrayList;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LSControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getResponse() throws Exception {

        LCSRequest request= new LCSRequest();
        request.setSetOfStrings(new ArrayList<>());
        request.getSetOfStrings().add(new SetOfString("comcast"));
        request.getSetOfStrings().add(new SetOfString("comcastic"));
        request.getSetOfStrings().add(new SetOfString("broadcaster"));
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accepts", "application/json");
        headers.set("Content-Type", "application/json");

        HttpEntity<LCSRequest> lcsRequestHttpEntity = new HttpEntity<>(request, headers);
        System.out.println(restTemplate.postForEntity("http://localhost:" + port + "/lcs", lcsRequestHttpEntity, LCSResponse.class));


        LCSResponse lcsResponse = restTemplate.postForEntity("http://localhost:" + port + "/lcs", lcsRequestHttpEntity, LCSResponse.class).getBody();
        Assertions.assertTrue(lcsResponse != null);
        Assertions.assertTrue(lcsResponse .getLcs().get(0)!=null);
        Assertions.assertTrue(lcsResponse .getLcs().get(0).getValue().equals("cast"));

    }
}
