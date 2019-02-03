package com.brite_erp.tests.smoke_tests.purchase;

import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class PageHeaderTest extends TestBase {

    @Test
    public void CheckTitle() throws InterruptedException {
        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Check the Title Name");
        extentLogger.info("Open Purchases Module");
        pages.purchasesMain().purchaseInMenu.click();
        Thread.sleep(3000);
        extentLogger.info("Verify Purchases page Title");

        Thread.sleep(3000);
        Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.PURCHASES_TITLE);
        extentLogger.pass("Passed: Verification Title of Purchases Page");

    }

    @Test
    public void Purchase_Orders_Title() throws InterruptedException {

        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Check the Title Name");
        extentLogger.info("Open Purchases Module");
        pages.purchasesMain().purchaseInMenu.click();
        Thread.sleep(3000);
        pages.purchasesMain().titlePurchaseOrders.click();
        extentLogger.info("Verify Purchase Orders Page Title");
        System.out.println(Driver.getDriver().getTitle());
        Thread.sleep(3000);
        Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.PURCHASES_ORDERS_TITLE);

        extentLogger.pass("Passed: Verification Title of Purchase Orders Page");

    }

    @Test
    public void Vendors_Title() throws InterruptedException {

        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Check the Title Name");
        extentLogger.info("Open Purchases Module");
        pages.purchasesMain().purchaseInMenu.click();
        Thread.sleep(11000);
        pages.purchasesMain().titleVendors.click();
        extentLogger.info("Verify Vendors Page Title");
        Thread.sleep(11000);
        Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.VENDORS_TITLE);
        extentLogger.pass("Passed: Verification Title of Vendors Page");
    }
    @Test
    public void Products_Title() throws InterruptedException {

        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Check the Title Name");
        extentLogger.info("Open Purchases Module");
        pages.purchasesMain().purchaseInMenu.click();
        Thread.sleep(11000);
        pages.purchasesMain().titleProducts.click();
        extentLogger.info("Verify Products Page Title");
        Thread.sleep(11000);
        Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.PRODUCTS_TITLE);
        extentLogger.pass("Passed: Verification Title of Products Page");
}
    @Test
    public void IncomingProducts_Title() throws InterruptedException {

        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Check the Title Name");
        extentLogger.info("Open Purchases Module");
        pages.purchasesMain().purchaseInMenu.click();
        Thread.sleep(11000);
        pages.purchasesMain().titleIncomingProducts.click();
        extentLogger.info("Verify Incoming Products Page Title");
        Thread.sleep(11000);
        Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.INCOMING_PRODUCTS_TITLE);
        extentLogger.pass("Passed: Verification Title of Incoming Products Page");

}
    @Test
    public void VendorBills_Title() throws InterruptedException {

        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Check the Title Name");
        extentLogger.info("Open Purchases Module");
        pages.purchasesMain().purchaseInMenu.click();
        Thread.sleep(11000);
        pages.purchasesMain().titleVendorBills.click();
        extentLogger.info("Verify Vendor Bills Page Title");
        Thread.sleep(11000);
        Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.VENDOR_BILLS_TITLE);
        extentLogger.pass("Passed: Verification Title of Vendor Bills Page");

    }
    @Test
    public void Reporting_Title() throws InterruptedException {

        pages.chooseERP().rightERP.click();
        pages.login().login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        extentLogger = report.createTest("Check the Title Name");
        extentLogger.info("Open Purchases Module");
        pages.purchasesMain().purchaseInMenu.click();
        Thread.sleep(11000);
        pages.purchasesMain().titleReporting.click();
        extentLogger.info("Verify Reporting Page Title");
        Thread.sleep(11000);
        Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.REPORTING_TITLE);
        extentLogger.pass("Passed: Verification Title of Reporting Page");

    }

}