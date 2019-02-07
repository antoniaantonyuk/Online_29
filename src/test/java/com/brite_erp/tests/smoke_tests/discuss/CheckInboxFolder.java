package com.brite_erp.tests.smoke_tests.discuss;

import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckInboxFolder extends TestBase {
    @Test
    public void CheckIfInboxExist() {
        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Check If Inbox Link is Exist");
        extentLogger.info("Find Inbox");
        Assert.assertTrue(pages.discussPage().inboxLink.isDisplayed());
        extentLogger.pass("Passed: Inbox Link is exist");
    }

    @Test
    public void InboxIsCkickable(){
        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Check If Inbox Link is Clickable");
        extentLogger.info("Click on Inbox");
        pages.discussPage().inboxLink.click();
        extentLogger.pass("Passed: Inbox Link is clickable");
    }

    @Test
    public  void CheckInboxTitle(){
        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Check If Inbox Page Title is #Inbox");
        extentLogger.info("Click on Inbox");
        pages.discussPage().inboxLink.click();
        extentLogger.info("Check if the Title of page is #Inbox");
        Assert.assertEquals(pages.discussPage().InboxTitle.getText(), "#Inbox");
        extentLogger.info("Check if the Title of page is #Inbox - Odoo");
        Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.INBOX_TITLE);
        extentLogger.pass("Passed: Inbox Link is clickable");
    }
}

