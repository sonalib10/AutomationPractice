package com.automationpractice.pages;

import com.automationpractice.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import com.automationpractice.Driver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.UUID;
import org.openqa.selenium.Keys;


public class StudentRegistrationFormPage extends Driver {

    public static Properties properties;

    static {
        try {
            properties = new Properties();
            InputStream fileInputStream = StudentRegistrationFormPage.class.getClassLoader().getResourceAsStream("env.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("env.properties file not found");
        }
    }

    public StudentRegistrationFormPage() {
        super();

    }

    public String getPageTitle() {
        String title = driver.getTitle();
        return title;
    }


    public static void navigateToURL() {
        driver.get(properties.getProperty("HOST"));
    }

    public void enterFirstName(String name) {
        driver.findElement(By.id("firstName")).sendKeys(name);
    }

    public static void enterLastName(String lastname) {
        driver.findElement(By.id("lastName")).sendKeys(lastname);
    }

    public static void enterEmailAddress(String email) {
        driver.findElement(By.id("userEmail")).sendKeys(email);
    }


    public static void selectGender(String gender) {
        if (gender.equals("female")) {

            driver.findElement(By.xpath("//form/div[3]/div[2]/div[2]/label")).click();
        }

    }


    public static void enterMobileNumber(String mobile) {
        driver.findElement(By.id("userNumber")).sendKeys(mobile);
    }

    public static void enterDateOfBirth(String dob) {

        WebElement element = driver.findElement(By.id("dateOfBirthInput"));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(dob);
        element.sendKeys(Keys.chord(Keys.ENTER));
    }

    public static void uploadFile(String url) throws IOException {
        String filePath = properties.getProperty("FILE_DOWNLOAD_PATH").concat(UUID.randomUUID().toString().concat(".jpg"));
        FileUtils.copyURLToFile(new URL(url), new File(filePath));
        WebElement uploadFileElement = driver.findElement(By.xpath("//input[@type='file']"));
        uploadFileElement.sendKeys(filePath);
    }

    public static void enterAddress(String address) {
        driver.findElement(By.id("currentAddress")).sendKeys(address);
    }

    public static void selectState(){

        driver.findElement(By.xpath("//html/body/div[1]/div/div[1]/a/img")).click();
        WebElement element = driver.findElement(By.id("state"));
        element.click();
        driver.findElement(By.xpath("//div[contains(@class, 'menu')]")).click();

    }

    public static void selectCity(){
        WebElement element = driver.findElement(By.id("city"));
        element.click();
        driver.findElement(By.xpath("//div[contains(@class, 'menu')]")).click();

    }


 public static void enterSubject(){


     WebElement element = driver.findElement(By.id("subjectsInput"));
     element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
     element.sendKeys("Maths");
     element.sendKeys(Keys.chord(Keys.ENTER));

 }

 public static void selectHobbies(){
        driver.findElement(By.xpath("//form/div[7]/div[2]/div[2]/label")).click();
        driver.findElement(By.xpath("//form/div[7]/div[2]/div[3]/label")).click();
 }

 public static void submit(){

        driver.findElement(By.id("submit")).click();
 }

 public static String readNameFromPopup(){
        Assertions.isElementVisible(By.xpath("//table/tbody/tr[1]/td[2]"));
        return driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();

 }

 public static String readEmailAddress(){
     Assertions.isElementVisible(By.xpath("//table/tbody/tr[2]/td[2]"));
        return driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
 }

 public static void scrollDown(){
     JavascriptExecutor js = (JavascriptExecutor) driver;
     WebElement element  = driver.findElement(By.id("submit"));
     js.executeScript("arguments[0].scrollIntoView();", element);
 }

 public static void clickClose(){

        driver.findElement(By.id("closeLargeModal")).click();
 }
}
