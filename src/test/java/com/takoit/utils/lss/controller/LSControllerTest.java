package com.takoit.utils.lss.controller;

import com.takoit.utils.lss.response.LCSResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LSControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        String req = "{\n" +
                "\"setOfStrings\": [\n" +
                "{\"value\": \"comcast\"}, {\"value\": \"comcastic\"}, {\"value\": \"broadcaster\"}\n" +
                "] }";
        LCSResponse lcsResponse = restTemplate.postForEntity("http://localhost:" + port + "/lcs", req, LCSResponse.class).getBody();
        Assertions.assertTrue(lcsResponse != null);
    }
}
