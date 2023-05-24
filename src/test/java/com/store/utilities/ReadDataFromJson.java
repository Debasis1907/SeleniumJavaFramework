package com.store.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.Pojo.LoginPojo;

public class ReadDataFromJson {

    public void readData() throws JsonProcessingException {

        String loginPayload = System.getProperty("user.dir") + "//src//test//resources//TestData//testData.json";

        ObjectMapper objectMapper = new ObjectMapper();
        LoginPojo login = objectMapper.readValue(loginPayload, LoginPojo.class);

        String email = login.getEmail();
        String password = login.getPassword();
    }


}
