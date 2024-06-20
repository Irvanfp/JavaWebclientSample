package com.irvan.WebclientExample.Rest;

import com.irvan.WebclientExample.Service.ProcessWebclient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    ProcessWebclient processWebclient;
    @RequestMapping(value = {"/random"},
            method = {RequestMethod.GET}
    )
    public ResponseEntity<String> getRandom() {
        ResponseEntity<String> response = null;
        response = processWebclient.processRandom();
        return response;
    }
}
