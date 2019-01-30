package com.brite_erp.tests.smoke_tests.purchase;

import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class PageHeaderTest extends TestBase  {
    @Test
    public void CheckTitle() throws InterruptedException   {
        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Check the Title Name");
        extentLogger.info("Open Purchases Module");
        pages.discussPage().purchaseInMenu.click();
        Thread.sleep(10000);
        extentLogger.info("Verify Purchases page Title");
        Assert.assertEquals(pages.purchasesMain().titlePurchasePage.getText(), ApplicationConstants.PURCHASES_TITLE);
        extentLogger.pass("Passed: Verification Title of Purchases Page");

    }
}
