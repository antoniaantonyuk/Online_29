package com.brite_erp.utilities;

import com.brite_erp.pages.*;

public class Pages {
    private LoginPage loginPage;
    private ChooseERP chooseERP;
    private DiscussPage discussPage;
    private PurchasesMain purchasesMain;
private QuotationRequest quotationRequest;
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
    public QuotationRequest quotationRequest() {
        if (quotationRequest == null) {
            quotationRequest = new QuotationRequest();
        }
        return quotationRequest;
    }

}
