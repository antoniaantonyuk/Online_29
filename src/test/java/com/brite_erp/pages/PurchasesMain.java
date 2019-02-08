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

    @FindBy(xpath = "(//li[@class='active'])[3]")
    public WebElement titlePurchasePage;

    @FindBy(xpath = "//a[@data-menu='519']")
    public WebElement titlePurchaseOrders;

    @FindBy(xpath = "//a[@data-menu='514']")
    public WebElement IncomingProducts;

    @FindBy(xpath = "//span[contains(@title,'Advanced Search...')]")
    public WebElement searchButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div/span")
    public WebElement ButtonFilters;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[5]")
    public WebElement Today;

    @FindBy(xpath = "//p[@class='oe_view_nocontent_create']")
    public WebElement AlertRegister;

    @FindBy(xpath = "//span[contains(.,'Vendor Bills')]")
    public WebElement PurchaseOrders_check;

    @FindBy(xpath = "(//span[@name='amount_untaxed'])[1]")
    public WebElement PurchaseOrders_Untaxed;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/table/tfoot/tr/td[7]")
    public WebElement PurchaseOrders_total;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/table/tbody/tr[8]/td[4]")
    public WebElement VendorName_Asus;

    @FindBy(xpath = "//a[@class='o_form_uri o_field_widget o_readonly_modifier o_required_modifier']")
    public WebElement VendorName_AsusTeK;

    @FindBy(xpath = "//a[@data-menu='506']")
    public WebElement titleVendors;

    @FindBy(xpath = "//a[@data-menu='516']")
    public WebElement titleProducts;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
            public WebElement titleProducts_search;

    @FindBy(xpath = "//strong[@class='o_kanban_record_title']")
    public WebElement titleProducts_AppleWatch;

    @FindBy(xpath = "//a[@data-menu='514']")
    public WebElement titleIncomingProducts;

    @FindBy(xpath = "//a[@data-menu='515']")
    public WebElement titleVendorBills;

    @FindBy(xpath = "//a[@data-menu='521']")
    public WebElement titleReporting;

    @FindBy(xpath = "//p[@class='alert alert-danger']")
    public WebElement WrongCredentialsAlert;
}


