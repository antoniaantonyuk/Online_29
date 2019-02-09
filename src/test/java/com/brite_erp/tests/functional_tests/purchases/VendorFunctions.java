package com.brite_erp.tests.functional_tests.purchases;



import com.brite_erp.utilities.BrowserUtils;
import com.brite_erp.utilities.TestBase;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VendorFunctions extends TestBase {

    @Test
    public void CreateNewVendorTest() throws InterruptedException {

        Faker faker = new Faker();
        String fakeVendor = faker.name().fullName();

        extentLogger = report.createTest("Create a new Vendor");//test case gibi
        pages.chooseERP().rightERP.click();
        //pages.login().login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
        pages.login().login();
        extentLogger.info("Sign in the account"); // bilgi amacli
        Thread.sleep(4000);

        pages.purchasesMain().titlePurchasePage.click();
        extentLogger.info("Click on Purchases Tab");
        Thread.sleep(3000);
        pages.purchasesMain().titleVendors.click();
        extentLogger.info("Click on Vendor");
        Thread.sleep(2000);
        pages.vendors().createVendor.click();
        extentLogger.info("Create a vendor");
        Thread.sleep(3000);

        BrowserUtils.waitForVisibility(pages.vendors().newVendorName,4);


        pages.vendors().newVendorName.sendKeys(fakeVendor);
        extentLogger.info("New vendor");
        Thread.sleep(3000);

        pages.vendors().saveNewVendor.click();
        extentLogger.info("Successfully created new vendor");
        Thread.sleep(3000);

//        String actualValue = fakeVendor;
//        Assert.assertEquals(fakeVendor, actualValue);
        pages.vendors().vendorNameCheck.click();
        extentLogger.info("Passed: Test finished");
    }

    @Test
    public void ImportFileTest() throws InterruptedException {
        extentLogger = report.createTest("Create a new Vendor");//test case gibi
        pages.chooseERP().rightERP.click();
        //pages.login().login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
        pages.login().login();
        extentLogger.info("Sign in the account"); // bilgi amacli
        Thread.sleep(4000);

        pages.purchasesMain().titlePurchasePage.click();
        extentLogger.info("Click on Purchase Order");

        pages.purchasesMain().titleVendors.click();
        extentLogger.info("Click on Vendor");
        Thread.sleep(4000);

        pages.vendors().importVendor.click();
        extentLogger.info("Click on Import button");

        BrowserUtils.verifyElementDisplayed(pages.vendors().loadFile);
        String path= "/Macintosh HD/Users/oibek/Document/SalesTest.xlsx";
        pages.vendors().loadFile.sendKeys(path);

        extentLogger.info("Passed");

    }
    @Test
    public void SearchButton () throws InterruptedException {
        extentLogger =report.createTest("Test search button");
        pages.chooseERP().rightERP.click();
        //pages.login().login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
        pages.login().login();
        extentLogger.info("Sign in the account");
        Thread.sleep(4000);

        pages.purchasesMain().titlePurchasePage.click();
        extentLogger.info("Click on Purchase Tab");
        Thread.sleep(3000);
        pages.purchasesMain().titleVendors.click();
        extentLogger.info("Click on Vendors");
        Thread.sleep(5000);

        pages.vendors().searchVendor.sendKeys("Apex");
        extentLogger.info("Click on search button");
        Thread.sleep(4000);


    }














//    //create a method
//    public void SignIn()
//    {
//        pages.chooseERP().rightERP.click();
//        pages.login().login(ConfigurationReader.getProperty("username"),
//                ConfigurationReader.getProperty("password"));
//        pages.quotationRequest().PurchasesTab.click();//PurchasesMain().titlePurchasePage.click();
//    }
//
//    @Test
//    public void titleCheck() throws InterruptedException // this test case will confirm that we are on quotation for purchase tab
//    {
//        extentLogger=report.createTest("Tab title confirmation test");
//
//        SignIn();
//        extentLogger.info("Sign in the account");
//
//        Thread.sleep(2000);
//        pages.quotationRequest().requestForQuote.click();
//        extentLogger.info("Check the page title");
//
//        String EXPECTEDTABNAME="Requests for Quotation - Odoo"; Thread.sleep(2000);
//        String actualTabName= Driver.getDriver().getTitle();
//        System.out.println(actualTabName);
//
//        Assert.assertEquals(actualTabName,EXPECTEDTABNAME);
//        extentLogger.pass("Test is passed");
//    }
}
