package com.brite_erp.tests.functional_tests.discuss;

import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendDirectMessages extends TestBase {
    @Test
    public void SendDirectMessages() throws InterruptedException {


        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Add other user or manager to Direct message list and deleted");
        extentLogger.info("Add other user to the list");
        pages.discussPage().addDirectMessagePlusButton.click();

        extentLogger.info("Write the Other User's Name");
        pages.discussPage().AddOtherUserNameBar.sendKeys(ApplicationConstants.OTHER_USER );
        Thread.sleep(1500);

        //check
        pages.discussPage().selectOtherUserInDropDownMenu.click();

       // WebElement select= Driver.getDriver().findElement(By.id("ui-id-15"));
      // Select(driver.findElement(By.id("payment_plan_id")));
      // select.selectByIndex(1);


        //Thread.sleep(1000);


        extentLogger.info("Verify that other user Name is displayed in the direct message list on the page");
        Assert.assertTrue(pages.discussPage().OtherUserName.isDisplayed());
        Thread.sleep(3000);


        extentLogger.info("Delete other user name from direct message list");
        pages.discussPage().deleteOtherUserNameXButton.click();

        extentLogger.info("Refresh Page to avoid bug.");

        driver.navigate().refresh();
        Thread.sleep(10000);

        extentLogger.info("deleted user name should not be displayed on the list");
        Assert.assertFalse(pages.discussPage().OtherUserName.isDisplayed());
        System.out.println("Fail is expected.");


        extentLogger.pass("Passed: other user name added and deleted. ");

    }



}
