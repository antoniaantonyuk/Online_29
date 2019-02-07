package com.brite_erp.pages;

import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasesMain extends Menu {
    public PurchasesMain() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[@data-menu='504']")
    public WebElement titlePurchasePage;

    @FindBy(xpath = "//a[@data-menu='519']")
    public WebElement titlePurchaseOrders;

    @FindBy(xpath = "//a[@data-menu='506']")
    public WebElement titleVendors;

    @FindBy(xpath = "//a[@data-menu='516']")
    public WebElement titleProducts;

    @FindBy(xpath = "//a[@data-menu='514']")
    public WebElement titleIncomingProducts;

    @FindBy(xpath = "//a[@data-menu='515']")
    public WebElement titleVendorBills;

    @FindBy(xpath = "//a[@data-menu='521']")
    public WebElement titleReporting;

    @FindBy(xpath = "//p[@class='alert alert-danger']")
    public WebElement WrongCredentialsAlert;
}