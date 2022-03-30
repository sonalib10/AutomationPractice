package com.automationpractice;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import com.automationpractice.dto.UserDataResults;

import java.io.IOException;

public class Utils {

    public static JsonPath rawToJSON(Response res){
        String responseString = res.asString();
        JsonPath x = new JsonPath(responseString);
        return x;
    }

    public static UserDataResults getUserDetails(Response response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(response.asString(), UserDataResults.class);
    }
}
