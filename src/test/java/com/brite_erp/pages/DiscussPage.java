package com.brite_erp.pages;

import com.brite_erp.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DiscussPage {
    public DiscussPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
