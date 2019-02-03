package com.brite_erp.tests.functional_tests.discuss;

//Elnur Bairamov's 3 Functional Tests

import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;




public class AddPrivateChannels extends TestBase {
    @Test
    public void checkPrivateChannel() throws InterruptedException {


        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Private Channel creation and removing");
        extentLogger.info("Create new Channel");
        pages.discussPage().addPrivateChannelPlusButton.click();

        extentLogger.info("Write the  Channel Name");
        pages.discussPage().privateChannelCreatorBar.sendKeys(ApplicationConstants.NEW_CHANNEL + Keys.ENTER);
        Thread.sleep(3000);


        extentLogger.info("Verify that new Channel Name is displayed on the page");
        Assert.assertTrue(pages.discussPage().privateChannelNameNew.isDisplayed());

        extentLogger.info("Delete current Private Channel");
        pages.discussPage().deletePrivateChannelXButton.click();

        extentLogger.info("Refresh Page to avoid bug.");

        driver.navigate().refresh();
        Thread.sleep(10000);

        extentLogger.info("Deleted Private Channel should not be displayed");
        Assert.assertFalse(pages.discussPage().privateChannelNameNew.isDisplayed());
        System.out.println("Fail is expected,there is a BUG founded by Elnur");


        extentLogger.pass("Passed: New Channel Name created and removed");

    }


    @Test
    public void checkInvitationToOtherUsers() throws InterruptedException {


        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Invitation to Private Channel other users");

        pages.discussPage().addPrivateChannelPlusButton.click();
        pages.discussPage().privateChannelCreatorBar.sendKeys(ApplicationConstants.NEW_CHANNEL_FOR_INVITATION + Keys.ENTER);

        pages.discussPage().clickInviteButton.click();


        pages.discussPage().selectUsersInDropDownMenu.sendKeys("InventoryUser4" + Keys.ENTER);

        pages.discussPage().inviteButtonInFrame.click();





    }
}