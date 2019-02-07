package com.brite_erp.tests.functional_tests.discuss;

//Elnur Bairamov's 3 Functional Tests

import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.brite_erp.utilities.Driver.getDriver;


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
        extentLogger.info("Private Channel created");


        pages.discussPage().clickInviteButton.click();
        pages.discussPage().selectUsersInDropDownMenu.sendKeys("InventoryUser4" + Keys.ENTER);
        pages.discussPage().inviteButtonInFrame.click();
        extentLogger.info("New user invited");


        Thread.sleep(3000);
        pages.discussPage().avatar.click();
        pages.discussPage().logOut.click();

        pages.login().login(ConfigurationReader.getProperty("username2"), ConfigurationReader.getProperty("password2"));
        Assert.assertTrue(pages.discussPage().privateChannelNameNewInvitation.isDisplayed());
        extentLogger.info("Logged in as a new user");

        pages.discussPage().deletePrivateChannelXButton.click();

        Thread.sleep(5000);
        pages.discussPage().avatar.click();
        pages.discussPage().logOut.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        pages.discussPage().deletePrivateChannelXButton.click();


    }

    @Test
    public void checkMessageInPrivateChannel() throws InterruptedException {
        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Invitation to Private Channel other users");

        pages.discussPage().addPrivateChannelPlusButton.click();
        pages.discussPage().privateChannelCreatorBar.sendKeys(ApplicationConstants.NEW_CHANNEL_FOR_INVITATION + Keys.ENTER);
        extentLogger.info("Private Channel created");

        pages.discussPage().clickInviteButton.click();
        pages.discussPage().selectUsersInDropDownMenu.sendKeys("InventoryUser4" + Keys.ENTER);
        pages.discussPage().inviteButtonInFrame.click();
        pages.discussPage().privateChannelMessageField.sendKeys("Welcome new user to our Private Channel" + Keys.ENTER);
        extentLogger.info("Old user sent a message to new user");

        Thread.sleep(3000);
        pages.discussPage().avatar.click();
        pages.discussPage().logOut.click();

        pages.login().login(ConfigurationReader.getProperty("username2"), ConfigurationReader.getProperty("password2"));
        Assert.assertTrue(pages.discussPage().privateChannelNameNewInvitation.isDisplayed());
        extentLogger.info("Logged in as a new user");

        pages.discussPage().privateChannelNameNewInvitation.click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Welcome new user to our Private Channel')]")).isDisplayed());
        pages.discussPage().privateChannelMessageField.sendKeys("Nice to see you!" + Keys.ENTER);
        Thread.sleep(3000);
        extentLogger.info("New user typed messagein new private channel");


        pages.discussPage().deletePrivateChannelXButton.click();

        Thread.sleep(3000);
        pages.discussPage().avatar.click();
        pages.discussPage().logOut.click();



        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        pages.discussPage().privateChannelNameNewInvitation.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Welcome new user to our Private Channel')]")).isDisplayed());
        extentLogger.info("Old user asserted old message");

        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Nice to see you!')]")).isDisplayed());
        extentLogger.info("Old user asserted new message");


        pages.discussPage().deletePrivateChannelXButton.click();

    }
}