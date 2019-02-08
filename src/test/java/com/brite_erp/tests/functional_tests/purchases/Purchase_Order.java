package com.brite_erp.tests.functional_tests.purchases;

import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class Purchase_Order extends TestBase {

    @Test
    public void ResearchItemsTest() throws InterruptedException {

    extentLogger=report.createTest("Printing Test");
    pages.chooseERP().rightERP.click();
    pages.login().login();
    extentLogger.info("Sign in the account");
    pages.purchasesMain().purchaseInMenu.click();
    Thread.sleep(11000);
    pages.purchasesMain().titlePurchaseOrders.click();
    Thread.sleep(7000);
    extentLogger.info("click on a Purchase Order");
    pages.purchasesMain().titlePurchaseOrders.click();
    extentLogger.info("Click on total price");
    Assert.assertTrue(pages.purchasesMain().PurchaseOrders_Untaxed.getText().contains("$ 200"));
    extentLogger.info("Test is done");
}
    @Test
    public void ReceiveProductTest() throws InterruptedException {

        extentLogger=report.createTest("Printing Test");
        pages.chooseERP().rightERP.click();
        pages.login().login();
        extentLogger.info("Sign in the account");
        pages.purchasesMain().purchaseInMenu.click();
        Thread.sleep(11000);
        pages.purchasesMain().titlePurchaseOrders.click();
        Thread.sleep(7000);
        extentLogger.info("click on a Vendor Name");
        pages.purchasesMain().VendorName_Asus.click();
        Thread.sleep(7000);
        extentLogger.info("Verify that a Vendor Name");
        Assert.assertTrue(pages.purchasesMain().VendorName_AsusTeK.getText().contains("ASUSTeK, Julia Rivero"));
        extentLogger.info("Test is done");
    }

    @Test
    public void IncomingProductsFiltersTest() throws InterruptedException {

        extentLogger=report.createTest("Printing Test");
        pages.chooseERP().rightERP.click();
        pages.login().login();
        extentLogger.info("Sign in the account");
        pages.purchasesMain().purchaseInMenu.click();
        Thread.sleep(11000);
        pages.purchasesMain().IncomingProducts.click();
        Thread.sleep(11000);
        pages.purchasesMain().searchButton.click();
        Thread.sleep(2000);
        pages.purchasesMain().ButtonFilters.click();
        Thread.sleep(2000);
        pages.purchasesMain().Today.click();
        Thread.sleep(4000);
        extentLogger.info("Verify that a Alert");
        Assert.assertTrue(pages.purchasesMain().AlertRegister.getText().contains("Click to register a product receipt."));
        extentLogger.info("Test is done");
    }

}


