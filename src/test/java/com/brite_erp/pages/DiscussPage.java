package com.brite_erp.pages;

import com.brite_erp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.brite_erp.utilities.ApplicationConstants.NEW_CHANNEL;

public class DiscussPage extends Menu {
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

    @FindBy(xpath = "//span[@title='Leave this channel']")
    public WebElement deletePrivateChannelXButton;

    @FindBy(xpath = "//button[@title='Invite people']")
    public WebElement clickInviteButton;

    @FindBy(xpath = "(//input[@type='text'])[7]")
    public WebElement selectUsersInDropDownMenu;

    @FindBy(id = "o_chat_fileupload3")
    public WebElement iframeInInvitationWindow;

    @FindBy(xpath= "//button[@class='btn btn-sm btn-primary']")
    public WebElement inviteButtonInFrame;

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement avatar;

    @FindBy(xpath = "//*[@data-menu='logout']" )
    public WebElement logOut;








}
