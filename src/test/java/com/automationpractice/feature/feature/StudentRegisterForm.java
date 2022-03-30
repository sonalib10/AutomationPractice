package com.automationpractice.feature.feature;
import com.automationpractice.Assertions;
import com.automationpractice.Driver;
import com.automationpractice.Utils;
import com.automationpractice.dto.UserDataResults;
import com.automationpractice.pages.StudentRegistrationFormPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.automationpractice.pages.StudentRegistrationFormPage.*;
import static io.restassured.RestAssured.given;

public class StudentRegisterForm extends Driver {

    private UserDataResults userDataResults;
    StudentRegistrationFormPage studentRegistrationFormPage;

    @Given("^User navigate to Student Registration Form page")
    public  void userNavigateToStudentRegistrationFormPage() throws IOException {
        initializeBrowser("Firefox");
        studentRegistrationFormPage = new StudentRegistrationFormPage();
        // Call API to get user data
           Response userDetailsResponse = given().when().get(properties.getProperty("APIHOST"));
        // Deserialise response
         userDataResults = Utils.getUserDetails(userDetailsResponse);
        // Navigate to URL
        StudentRegistrationFormPage.navigateToURL();
        Assertions.assertLandingPage();
    }

    @When("^Enter Student details")
    public void enterStudentDetails() throws IOException {
        studentRegistrationFormPage.enterFirstName(userDataResults.getResults().get(0).getName().getFirst());
        studentRegistrationFormPage.enterLastName(userDataResults.getResults().get(0).getName().getLast());
        studentRegistrationFormPage.enterEmailAddress(userDataResults.getResults().get(0).getEmail());
        studentRegistrationFormPage.selectGender(userDataResults.getResults().get(0).getGender());

        String cellNumber = userDataResults.getResults().get(0).getCell();
        String strNew = cellNumber.replace("-", "");
        studentRegistrationFormPage.enterMobileNumber(strNew);
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String date  = userDataResults.getResults().get(0).getDob().getDate();
       studentRegistrationFormPage.enterDateOfBirth(date);
        studentRegistrationFormPage.uploadFile(userDataResults.getResults().get(0).getPicture().getLarge());
        String streetNumber =  Integer.toString(userDataResults.getResults().get(0).getLocation().getStreet().getNumber());
        String streetName = userDataResults.getResults().get(0).getLocation().getStreet().getName();
        String finalAddress = streetNumber.concat(" ").concat(streetName);
        studentRegistrationFormPage.enterAddress(finalAddress);
        studentRegistrationFormPage.enterSubject();
        studentRegistrationFormPage.scrollDown();
        studentRegistrationFormPage.selectState();
       studentRegistrationFormPage.selectCity();
        studentRegistrationFormPage.selectHobbies();
        studentRegistrationFormPage.submit();




    }

    @Then("^Verify user details")
    public void verifyUserDetails(){

        String name = studentRegistrationFormPage.readNameFromPopup();
        Assert.assertEquals(name, "Britney Sims", "Username is incorrect");
        String email = studentRegistrationFormPage.readEmailAddress();
        Assert.assertEquals(email, "britney.sims@example.com", "Email Address is incorrect");
       studentRegistrationFormPage.clickClose();
       driver.close();


    }
}
