package com.poc.crud.api.controllers;

import com.poc.crud.api.services.ReqResService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reqres")
public class ReqResController {

    private static final String getUsersUrl = "https://reqres.in/api/users";
    private static final String getUsersUrl1 = "https://reqres.in/api/users/1";
    Logger logger = LoggerFactory.getLogger(ReqResController.class);

    @Autowired
    private ReqResService reqResService;

    @GetMapping("/users")
    public ResponseEntity<String> getUsers() {
        return reqResService.getAllUsers(getUsersUrl);
    }

    @GetMapping("/user")
    public String getUser() {
        return reqResService.getOneUsers(getUsersUrl1);
    }

    @GetMapping("/post")
    public void postUser() {
        String response = reqResService.createSingleUser();
        logger.info(response);
    }

}
