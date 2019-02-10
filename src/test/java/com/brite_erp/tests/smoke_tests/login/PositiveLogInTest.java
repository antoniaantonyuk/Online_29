package com.brite_erp.tests.smoke_tests.login;



import com.brite_erp.utilities.*;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class PositiveLogInTest extends TestBase {
    @Test()
    public void positiveLoginTest() throws InterruptedException {

        extentLogger = report.createTest("Positive login test");
        extentLogger.info("Login to application");
        pages.chooseERP().rightERP.click();
        Thread.sleep(4000);
        pages.login().login();
        extentLogger.info("Verifying url");
        Thread.sleep(6000);
        assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.APPLICATION_TITLE);

        extentLogger.pass("Passed: Login to application");
    }
}
