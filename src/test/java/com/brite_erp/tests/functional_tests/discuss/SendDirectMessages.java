package com.brite_erp.tests.functional_tests.discuss;

import com.brite_erp.utilities.*;
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
        BrowserUtils.waitForVisibility(pages.discussPage().selectOtherUserInDropDownMenu,5);

        pages.discussPage().selectOtherUserInDropDownMenu.click();

        extentLogger.info("Verify that other user Name is displayed in the direct message list on the page");
       // System.out.println(pages.discussPage().OtherUserName.isDisplayed());
        Assert.assertTrue(pages.discussPage().OtherUserName.isDisplayed());
        Thread.sleep(3000);
       // driver.navigate().refresh();
        extentLogger.info("Delete other user name from direct message list");
      BrowserUtils.hover(Driver.getDriver().findElement(By.xpath("//i[@title='Offline']")));

       BrowserUtils.waitForClickablility(pages.discussPage().deleteOtherUserNameXButton,10);
  //      BrowserUtils.verifyElementDisplayed(pages.discussPage().deleteOtherUserNameXButton);
       pages.discussPage().deleteOtherUserNameXButton.click();
        extentLogger.info("Refresh Page to avoid bug.");
        Driver.getDriver().navigate().refresh();
        //Thread.sleep(10000);

        extentLogger.info("deleted user name should not be displayed on the list");
        try {
            Assert.assertFalse(pages.discussPage().OtherUserName.isDisplayed(), "could not remove the user");
        }
        catch (Exception e)
        {
            System.out.println("Item is removed successfully");
        }

       // System.out.println("Fail is expected.");
     extentLogger.pass("Passed: other user name added and deleted. ");

    }



}
