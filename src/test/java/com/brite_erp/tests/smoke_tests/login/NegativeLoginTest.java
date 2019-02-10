package com.brite_erp.tests.smoke_tests.login;

import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NegativeLoginTest extends TestBase {

    @Test()
    public void negativeLoginTest1() throws InterruptedException {

        extentLogger = report.createTest("Wrong Password login test");
        extentLogger.info("Login to application");
        pages.chooseERP().rightERP.click();
        Thread.sleep(4000);
        pages.login().username.sendKeys(ConfigurationReader.getProperty("username"));
        pages.login().password.sendKeys("wrong");

        extentLogger.info("Verifying alert");
        Thread.sleep(6000);
        String alert1= pages.purchasesMain().WrongCredentialsAlert.getText();
        assertEquals(alert1, ApplicationConstants.WRONG_CREDENTIALS_ALERT);

        extentLogger.pass("Passed: Wrong Password Login");
    }

    @Test()
    public void negativeLoginTest2() throws InterruptedException {

        extentLogger = report.createTest("Wrong Username login test");
        extentLogger.info("Login to application");
        pages.chooseERP().rightERP.click();
        Thread.sleep(4000);
        pages.login().username.sendKeys("Wrongusername");
        pages.login().password.sendKeys(ConfigurationReader.getProperty("password"));
        extentLogger.info("Verifying alert");
        Thread.sleep(6000);
        String alert1= pages.purchasesMain().WrongCredentialsAlert.getText();
        assertEquals(alert1, ApplicationConstants.WRONG_CREDENTIALS_ALERT);

        extentLogger.pass("Passed: Negative Login");
    }
}