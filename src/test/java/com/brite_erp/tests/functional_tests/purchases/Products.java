package com.brite_erp.tests.functional_tests.purchases;

import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Products extends TestBase {


    @Test
    public void addMessage() throws InterruptedException {
        //Selecting Iphone8 and adding a message under the product. Then verify that the message added successfully.
        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Check the Title Name");
        extentLogger.info("Open Purchases Module");
        pages.purchasesMain().purchaseInMenu.click();
        Thread.sleep(11000);
        pages.purchasesMain().titleProducts.click();
        extentLogger.info("Verify Products Page Title");
        Thread.sleep(11000);
        extentLogger.info("Click on iphone 8");
        pages.purchasesMain().Ipone8.click();
        Thread.sleep(3000);

        pages.purchasesMain().addAMessage.click();
        pages.purchasesMain().typingBox.sendKeys(ApplicationConstants.MESSAGE_TO_IPHONE8);
        pages.purchasesMain().messageButton.click();
        WebElement writtenMessage = Driver.getDriver().findElement(By.xpath("//div[@class='o_thread_message_content']"));
        extentLogger.info("Verify the message added under the product successfully");
        Assert.assertEquals(writtenMessage.getText(), ApplicationConstants.MESSAGE_TO_IPHONE8);
        extentLogger.pass("Passed: Verification for adding a message");

    }

    @Test
    public void updateQuantity() throws InterruptedException {
        //Selecting Datacard and updating quantity on hand. Then verify that the quantity is updated.
        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Check the Title Name");
        extentLogger.info("Open Purchases Module");
        pages.purchasesMain().purchaseInMenu.click();
        Thread.sleep(11000);
        pages.purchasesMain().titleProducts.click();
        extentLogger.info("Verify Products Page Title");
        Thread.sleep(11000);
        extentLogger.info("Click on Datacard");
        pages.purchasesMain().datacard.click();
        Thread.sleep(3000);
        pages.purchasesMain().updateQuantityButton.click();
        Thread.sleep(3000);

        pages.purchasesMain().enterNewQuantity.clear();
        Thread.sleep(3000);
        String qua = "11.000";


        pages.purchasesMain().enterNewQuantity.sendKeys(qua);
        Thread.sleep(3000);
        pages.purchasesMain().applyButtonenterQua.click();
        Thread.sleep(6000);



        String updatedQua = pages.purchasesMain().updatedQuantity.getText();
        extentLogger.info("Verify that updated quantity is displayed on the product page");

         Assert.assertEquals(updatedQua, qua);
        extentLogger.pass("Passed: Verification for updated quantity is visible");

     }
        @Test
        public void printAProductDetails() throws InterruptedException{
            //Select Apple watch series 3 and confirm the label to print.
                pages.chooseERP().rightERP.click();
                pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
                extentLogger = report.createTest("Check the Title Name");
                extentLogger.info("Open Purchases Module");
                pages.purchasesMain().purchaseInMenu.click();
                Thread.sleep(15000);
                pages.purchasesMain().titleProducts.click();
                extentLogger.info("Verify Products Page Title");
                Thread.sleep(11000);
                extentLogger.info("Click on Apple Watch series 3");
                pages.purchasesMain().appleWatch3.click();
                Thread.sleep(6000);
                pages.purchasesMain().printButton.click();
            Thread.sleep(3000);

            pages.purchasesMain().printLabelButton.click();
        WebElement iframe = Driver.getDriver().findElement(By.className("o_report_iframe"));
        Driver.getDriver().switchTo().frame(iframe);

            String appleTitleActual= pages.purchasesMain().appleTitle.getText();
            extentLogger.info("Verify that label is ready to print");

    Assert.assertEquals(appleTitleActual, ApplicationConstants.APPLE_TITLE);


            extentLogger.pass("Passed: Verification for product label is visible");







    }
}