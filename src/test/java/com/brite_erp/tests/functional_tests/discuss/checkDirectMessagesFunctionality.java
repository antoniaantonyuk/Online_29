package com.brite_erp.tests.functional_tests.discuss;

import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class checkDirectMessagesFunctionality extends TestBase {
    @Test(priority = 1)
    public void addUserToDirectMessages() throws InterruptedException {


        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Add other user or manager to Direct message list and deleted");
        extentLogger.info("Add other user to the list");
        pages.discussPage().addDirectMessagePlusButton.click();

        extentLogger.info("Write the Other User's Name");
        pages.discussPage().AddOtherUserNameBar.sendKeys(ApplicationConstants.OTHER_USER);
        pages.discussPage().selectOtherUserInDropDownMenu.click();
        Thread.sleep(1000);

        extentLogger.info("Verify that other user Name is displayed in the direct message list on the page");
        Assert.assertTrue(pages.discussPage().OtherUserName.isDisplayed());

        extentLogger.info("Delete other user name from direct message list");
        pages.discussPage().deleteOtherUserNameXButton.click();

        extentLogger.info("Refresh Page to avoid bug.");

        driver.navigate().refresh();

        pages.discussPage().addDirectMessagePlusButton.click();
        extentLogger.info("deleted user name should not be displayed on the list");
        Assert.assertFalse(pages.discussPage().isElementPreset());

        System.out.println(pages.discussPage().isElementPreset());
        System.out.println("Fail is expected.");

        extentLogger.pass("Passed: other user name added and deleted. ");

    }

    @Test(priority = 2)
    public void SendDirectMessages() throws InterruptedException {

        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Add other user or manager to Direct message list and deleted");
        extentLogger.info("Add other user to the list");
        pages.discussPage().addDirectMessagePlusButton.click();
        Thread.sleep(1000);
        extentLogger.info("Type the Other User's Name");

        pages.discussPage().AddOtherUserNameBar.sendKeys(ApplicationConstants.OTHER_USER);
        pages.discussPage().selectOtherUserInDropDownMenu.click();
        Thread.sleep(1000);

        extentLogger.info("Write message 'how are you'");
        pages.discussPage().writeText.sendKeys("how are you" + Keys.ENTER);
        driver.navigate().refresh();
        Thread.sleep(1000);

        String expected = "how are you";
        String actual = pages.discussPage().actualMessage.getText();
        Assert.assertEquals(actual, expected);
        extentLogger.pass("Passed: text successfully sent and displayed. ");



    }

    @Test(priority = 3)
    public void MessageMarkedWithStar() throws InterruptedException {

        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Mark the text message with star mark and remove star mark");
        extentLogger.info("Add star mark");
        pages.discussPage().addDirectMessagePlusButton.click();

        extentLogger.info("Write the Other User's Name");
        pages.discussPage().AddOtherUserNameBar.sendKeys(ApplicationConstants.OTHER_USER);
        pages.discussPage().selectOtherUserInDropDownMenu.click();
        Thread.sleep(1000);

        extentLogger.info("Write message 'how are you Jack'");
        pages.discussPage().writeText.sendKeys("how are you jack" + Keys.ENTER);
        driver.navigate().refresh();
        Thread.sleep(1000);

        extentLogger.info("mark the new massage with star sign");
        pages.discussPage().starMessage.equals("how are you jack");
        pages.discussPage().starMark.click();
        driver.navigate().refresh();
        Thread.sleep(1000);

        extentLogger.info("verify the message starred.");
        pages.discussPage().starred.isDisplayed();


        extentLogger.info("remove star mark and verify");
        pages.discussPage().starMark.click();
        driver.navigate().refresh();
        Thread.sleep(15);
        Thread.sleep(15);


        System.out.println(pages.discussPage().isElementPreset());
        System.out.println("Fail is expected.");




    }
}