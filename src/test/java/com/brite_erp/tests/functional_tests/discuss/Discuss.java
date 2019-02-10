package com.brite_erp.tests.functional_tests.discuss;

import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Discuss extends TestBase{

    @Test
    public void checkCreateChannel() throws Exception{
        pages.chooseERP().rightERP.click();
        pages.login().login();
        pages.createChannelPage().channelTab.click();
        Thread.sleep(3000);
        pages.createChannelPage().createBtn.click();
        Thread.sleep(3000);
        pages.createChannelPage().channelName.sendKeys("AutomationTest1");
        pages.createChannelPage().channelDescription.sendKeys("Automation test desc");
        pages.createChannelPage().emailCheckbox.click();
        pages.createChannelPage().saveBtn.click();
        Thread.sleep(5000);
        Assert.assertTrue(pages.createChannelPage().channelName.getText().equals("AutomationTest1"));
    }
}
