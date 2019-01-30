package com.brite_erp.tests.smoke_tests.login;



import com.brite_erp.utilities.BrowserUtils;
import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class PositiveLogInTest extends TestBase {
    @Test()
    public void positiveLoginTest() {
        extentLogger = report.createTest("Positive login test");
        extentLogger.info("Login to application");
        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"),
                ConfigurationReader.getProperty("password"));
        extentLogger.info("Verifying url");
        assertEquals(driver.getTitle(),
                ApplicationConstants.APPLICATION_TITLE);

        extentLogger.pass("Passed: Cart Icon Delete Test");
    }
}
