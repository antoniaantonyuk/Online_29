package com.brite_erp.tests.smoke_tests.discuss;

import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.BrowserUtils;
import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.TestBase;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.brite_erp.utilities.ApplicationConstants.NEW_CHANNEL;


public class AddPrivateChannels extends TestBase {
    @Test
    public void checkPrivateChannel() throws InterruptedException {


        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Click on plus button to add new Private Channel");
        extentLogger.info("Create new Channel");
        pages.discussPage().addPrivateChannelPlusButton.click();

        extentLogger.info("Write the  Channel Name");
        pages.discussPage().privateChannelCreatorBar.sendKeys(NEW_CHANNEL+ Keys.ENTER);
        Thread.sleep(10000);


        extentLogger.info("Verify that new Channel Name is displayed on the page");
        Assert.assertTrue(pages.discussPage().privateChannelNameNew.isDisplayed());

        extentLogger.pass("Passed: New Channel Name created");







}


}