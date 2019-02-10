package com.brite_erp.tests.smoke_tests.discuss;

import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PublicChannelsBlock extends TestBase {
    @Test
    public void ChannelsLinkIsVisibleAndClickable() {
        pages.chooseERP().rightERP.click();
        pages.login().login();
        extentLogger =report.createTest("Check If Channels Link is Exist");
        extentLogger.info("Find CHANNELS");
        Assert.assertTrue(pages.discussPage().channelsLink.isDisplayed());
        extentLogger.info("CHANNELS link is clickable");
        pages.discussPage().channelsLink.click();
        extentLogger.pass("Passed: CHANNELS is visible and clickable");
}
@Test
    public void CheckTitleOfPageChannels() throws InterruptedException{
    pages.chooseERP().rightERP.click();
    pages.login().login();
    extentLogger =report.createTest("Check The Title Of Page Channels");
    extentLogger.info("Open CHANNELS page");
    pages.discussPage().channelsLink.click();
    Thread.sleep(3000);
    extentLogger.info("Check if the Title of page is Public Channels - Odoo");
    Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.CHANNELS_TITLE);
    extentLogger.pass("Passed: CHANNELS Page has title as expected");
}

    @Test
    public void GeneralChannelIsVisible() throws InterruptedException{
        pages.chooseERP().rightERP.click();
        pages.login().login();
        extentLogger =report.createTest("Check if at least General Channel is presented in Public Channels");
        extentLogger.info("Open CHANNELS page");
        pages.discussPage().channelsLink.click();
        Thread.sleep(3000);
        extentLogger.info("Find general channel" );
        Assert.assertTrue(pages.discussPage().generalChannelBlock.isDisplayed());
        extentLogger.pass("Passed: General channel is presented in public channels page");
    }




}
