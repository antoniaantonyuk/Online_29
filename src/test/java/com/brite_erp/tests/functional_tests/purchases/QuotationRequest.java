package com.brite_erp.tests.functional_tests.purchases;

import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.Pages;
import com.brite_erp.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class QuotationRequest extends TestBase {


    public void SignIn()
    {
        pages.chooseERP().rightERP.click();

        pages.login().login();//gin(ConfigurationReader.getProperty("username"),
              //  ConfigurationReader.getProperty("password"));
        pages.quotationRequest().PurchasesTab.click();//urchasesMain().titlePurchasePage.click();

    }

    @Test
    public void titleCheck() throws InterruptedException // this test case will confirm that we are on quotation for purchase tab
    {
        extentLogger=report.createTest("Tab title confirmation test");

        SignIn();
        extentLogger.info("Sign in the account");

        Thread.sleep(2000);
        pages.quotationRequest().requestForQuote.click();
        extentLogger.info("Check the page title");

        String EXPECTEDTABNAME="Requests for Quotation - Odoo"; Thread.sleep(2000);
        String actualTabName=Driver.getDriver().getTitle();
        System.out.println(actualTabName);

        Assert.assertEquals(actualTabName,EXPECTEDTABNAME);
extentLogger.pass("Test is passed");
    }
    @Test
    public void amountCheck()
    {
        extentLogger=report.createTest("Amount Check Test");

        SignIn();
        extentLogger.info("Sign in the account");

        Random rndm=new Random();
        //System.out.println("random number row"+pages.purchase().requestCount.size());
        int randomRow=rndm.nextInt(pages.quotationRequest().requestCount.size());
        extentLogger.info("choose a random quotation");
        extentLogger.info("Get the quote amount");
        String quoteAmount=pages.quotationRequest().PickAQuote(randomRow).getText().substring(2);
        String totalAmount=pages.quotationRequest().totalAmount.getText();
        extentLogger.info("Compare the quote amount with total amount section");
        System.out.println(quoteAmount);
        System.out.println("total price "+totalAmount);
        Assert.assertEquals(quoteAmount,totalAmount);
        extentLogger.pass("Test is passed");
    }
    @Test
    public void printTest()
    {
        extentLogger=report.createTest("Printing Test");
        SignIn();
        extentLogger.info("Sign in the account");
        Random rndm=new Random();
        //System.out.println("random number row"+pages.purchase().requestCount.size());
        int randomRow=rndm.nextInt(pages.quotationRequest().requestCount.size());
        extentLogger.info("choose a random quotation");
        pages.quotationRequest().PickAQuote(randomRow);
        extentLogger.info("click on print tab and select purchase order option");
        pages.quotationRequest().printTab.click();
        pages.quotationRequest().purchaseOrderPrint.click();
        extentLogger.info("Confirm if successfully printed");
      //  extentLogger.fail("failed");
        Assert.assertTrue(pages.quotationRequest().printMessage.getText().contains("Successfully Printed"));
        extentLogger.info("Test is done");
    }

    @Test
    public void ExportTest()
    {
        extentLogger=report.createTest("Printing Test");
        SignIn();
        extentLogger.info("Sign in the account");
        Random rndm=new Random();
        //System.out.println("random number row"+pages.purchase().requestCount.size());
        int randomRow=rndm.nextInt(pages.quotationRequest().requestCount.size());
        extentLogger.info("choose a random quotation");
        pages.quotationRequest().PickAQuote(randomRow);
        extentLogger.info("click on action tab and select export option");
        pages.quotationRequest().actionTab.click();
        pages.quotationRequest().export.click();
        pages.browserUtils().doubleClick(pages.quotationRequest().companyadd);
        pages.browserUtils().doubleClick(pages.quotationRequest().currency);
        pages.browserUtils().doubleClick(pages.quotationRequest().orderDateadd);
        extentLogger.info("Add a random fields to exporting file");
        pages.quotationRequest().exportToFile.click();
        extentLogger.info("Click on export to File option");
        String path = "E:\\Downloads";
        //  extentLogger.fail("failed");
        extentLogger.info("Check if the file is downloaded onto computer");
        Assert.assertTrue(pages.quotationRequest().isFileDownloaded(path, "purchase.order"));
        extentLogger.info("Test is done");
    }

    @Test
    public void downCheck() {

        //pages.quotationRequest().isFileDownloaded(path,"ww.pdf");
        System.out.println();

    }
}
