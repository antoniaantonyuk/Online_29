package com.brite_erp.pages;

import com.brite_erp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.brite_erp.utilities.ApplicationConstants.NEW_CHANNEL;

public class DiscussPage {
    public DiscussPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@title='Add'])[3]")
    public WebElement addPrivateChannelPlusButton;

    @FindBy(xpath = "//input[@placeholder='Add a private channel']" )
    public  WebElement privateChannelCreatorBar;

    @FindBy(xpath = "//span[@class='o_channel_name']")
    public  WebElement privateChannelName;

    @FindBy(partialLinkText = NEW_CHANNEL)
    public  WebElement privateChannelNameNew;

    @FindBy(linkText = "Purchases")
    public WebElement purchaseInMenu;



}
