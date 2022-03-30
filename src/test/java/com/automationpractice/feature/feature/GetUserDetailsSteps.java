package com.automationpractice.feature.feature;

import com.automationpractice.Utils;
import com.automationpractice.dto.UserDataResults;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class GetUserDetailsSteps {

    private Response response;
    private JsonPath jsonPath;
    private RequestSpecification request;
    Properties properties;


    @cucumber.api.java.en.Given("Load the property file")
    public void loadThePropertyFile() throws IOException {
        properties = new Properties();
        InputStream inputStream = getClass()
                .getClassLoader().getResourceAsStream("env.properties");
        properties.load(inputStream);

    }

    @cucumber.api.java.en.When("Call the API")
    public void callTheAPI() {
        response = given().when().get(properties.getProperty("APIHOST"));
    }

    @cucumber.api.java.en.Then("Verify the response")
    public void verifyTheResponse() throws IOException {
        response = response.then().statusCode(200).and().contentType(ContentType.JSON).extract().response();
        UserDataResults userDataResults = Utils.getUserDetails(response);
        System.out.println(userDataResults.getInfo().getSeed());
        String info = userDataResults.getInfo().getSeed();
        assertEquals(info, "foobar");
    }



}
