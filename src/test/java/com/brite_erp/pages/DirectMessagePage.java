package com.brite_erp.pages;

import com.brite_erp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DirectMessagePage {

    public DirectMessagePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//span[@data-type=\"dm\"]")
    public WebElement dmAddIcon;

    @FindBy(xpath="//div[@data-type='dm']/input")
    public WebElement dmInputBox;

    @FindBy(xpath  ="//li[@class='ui-menu-item']/a")
    public WebElement dmDropDownList;

    @FindBy(xpath  ="//div[@class='o_mail_chat_content']")
    public WebElement chatSection;


}
