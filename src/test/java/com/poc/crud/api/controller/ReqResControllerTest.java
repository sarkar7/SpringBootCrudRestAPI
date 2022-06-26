package com.poc.crud.api.controller;

import com.poc.crud.api.services.ReqResService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestClientException;

@SpringBootTest
public class ReqResControllerTest {

    @MockBean
    private ReqResService reqResService;

    @Test
    public void getAllUsers() {
        Mockito.when(reqResService.getOneUsers("https://reqres.in/api/users/1"))
                .thenThrow(RestClientException.class)
                .thenReturn(null);
    }

}
