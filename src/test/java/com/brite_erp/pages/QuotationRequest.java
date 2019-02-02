package com.brite_erp.pages;

import com.brite_erp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class QuotationRequest {

    public QuotationRequest(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@data-menu='518']")
    public WebElement requestForQuote;

    @FindBy(xpath = "//a[@data-menu='504']")
    public WebElement PurchasesTab;

    @FindBy(xpath = "//td[@title='Total amount']")
    public WebElement totalAmount;

    @FindBy(xpath = "//table//tbody//tr")
    public List<WebElement> requestCount;

    @FindBy(xpath = "(//div[@class='btn-group']//button)[1]")
    public WebElement printTab;
    @FindBy(xpath = "(//div[@class='btn-group']//button)[2]")
    public WebElement actionTab;

    @FindBy(xpath = "(//div[@class='btn-group']//ul//li)[1]")
    public WebElement purchaseOrderPrint;

    @FindBy(xpath = "(//div[@class='btn-group']//ul)[2]//li[1]")
    public WebElement export;

    @FindBy(xpath = "//span[.='Company']")
    public WebElement companyadd;

    @FindBy(xpath = "//span[.='Currency']")
    public WebElement currency;

    @FindBy(xpath = "//span[.='Order Date']")
    public WebElement orderDateadd;

    @FindBy(xpath = "//span[.='Export To File']")
    public WebElement exportToFile;

    @FindBy(xpath = "//div[@class='o_notification_content']")
    public WebElement printMessage;


    public WebElement PickAQuote(int row)
    {
        Driver.getDriver().findElement(By.xpath("//table//tbody//tr["+row+"]//td[1]")).click();
        return Driver.getDriver().findElement(By.xpath("//table//tbody//tr["+row+"]//td[7]"));
    }
}
