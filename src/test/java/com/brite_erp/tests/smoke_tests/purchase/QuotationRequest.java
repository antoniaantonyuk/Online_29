package com.brite_erp.tests.smoke_tests.purchase;

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
        pages.login().login(ConfigurationReader.getProperty("username"),
                ConfigurationReader.getProperty("password"));
        pages.quotationRequest().PurchasesTab.click();//urchasesMain().titlePurchasePage.click();
    }

    @Test
    public void titleCheck() throws InterruptedException // this test case will confirm that we are on quotation for purchase tab
    {
        SignIn();
        Thread.sleep(2000);
        pages.quotationRequest().requestForQuote.click();

        String EXPECTEDTABNAME="Requests for Quotation - Odoo"; Thread.sleep(2000);
        String actualTabName=Driver.getDriver().getTitle();
        System.out.println(actualTabName);

        Assert.assertEquals(actualTabName,EXPECTEDTABNAME);

    }
    @Test
    public void amountCheck()
    {
        SignIn();
        Random rndm=new Random();
        //System.out.println("random number row"+pages.purchase().requestCount.size());
        int randomRow=rndm.nextInt(pages.quotationRequest().requestCount.size());
        String quoteAmount=pages.quotationRequest().PickAQuote(randomRow).getText().substring(2);
        String totalAmount=pages.quotationRequest().totalAmount.getText();
        System.out.println(quoteAmount);
        System.out.println("total price "+totalAmount);
        Assert.assertEquals(quoteAmount,totalAmount);
    }
    @Test
    public void printTest()
    {
        SignIn();
        Random rndm=new Random();
        //System.out.println("random number row"+pages.purchase().requestCount.size());
        int randomRow=rndm.nextInt(pages.quotationRequest().requestCount.size());
        pages.quotationRequest().PickAQuote(randomRow);
        pages.quotationRequest().printTab.click();
        pages.quotationRequest().purchaseOrderPrint.click();
        Assert.assertTrue(pages.quotationRequest().printMessage.getText().contains("Enable"));
    }
}
