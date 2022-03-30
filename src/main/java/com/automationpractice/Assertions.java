package com.automationpractice;

import com.automationpractice.pages.StudentRegistrationFormPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Assertions extends Driver {

    public Assertions() {
        super();
    }

    public static StudentRegistrationFormPage st = new StudentRegistrationFormPage();

    public static void assertLandingPage() {
        Assert.assertEquals(st.getPageTitle(), "ToolsQA", "User failed to navigate on Student form");
        System.out.println("User landed on Student form");
    }


    public static void isElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            System.out.println("Command completion takes more than the wait time for element" + by);
        } catch (NoSuchElementException e) {

            System.out.println(e + "Element is not available on the page for" + by);
        } catch (ElementNotVisibleException e) {

            System.out.println(e + "Element is not visible on the page for" + by);
        } catch (Exception e) {

            System.out.println(e + "Exception");
        }
    }


}
