package com.brite_erp.utilities;

import com.brite_erp.pages.ChooseERP;
import com.brite_erp.pages.DiscussPage;
import com.brite_erp.pages.LoginPage;
import com.brite_erp.pages.PurchasesMain;

public class Pages {
    private LoginPage loginPage;
    private ChooseERP chooseERP;
    private DiscussPage discussPage;
    private PurchasesMain purchasesMain;

    public LoginPage login() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public ChooseERP chooseERP() {
        if (chooseERP == null) {
            chooseERP = new ChooseERP();
        }
        return chooseERP;
    }
    public DiscussPage discussPage() {
        if (discussPage == null) {
            discussPage = new DiscussPage();
        }
        return discussPage;
    }
    public PurchasesMain purchasesMain() {
        if (purchasesMain == null) {
            purchasesMain = new PurchasesMain();
        }
        return purchasesMain;
    }
}
