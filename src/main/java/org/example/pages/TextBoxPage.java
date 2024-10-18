package org.example.pages;

import com.microsoft.playwright.Page;

public class TextBoxPage {
    private Page page;

    // Constructor
    public TextBoxPage(Page page) {
        this.page = page;
    }

    // Sayfayı aç
    public void navigate() {
        page.navigate("https://demoqa.com/text-box");
        page.waitForTimeout(1000);
    }

    // Ad, e-posta, adres gibi alanları doldurma yöntemleri
    public void fillName(String name) {
        page.fill("#userName", name);
        page.waitForTimeout(1000);
    }

    public void fillEmail(String email) {
        page.fill("#userEmail", email);
        page.waitForTimeout(1000);
    }

    public void fillCurrentAddress(String address) {
        page.fill("#currentAddress", address);
        page.waitForTimeout(1000);
    }

    public void fillPermanentAddress(String address) {
        page.fill("#permanentAddress", address);
        page.waitForTimeout(1000);
    }

    public void submit() {
        page.click("#submit");
        page.waitForTimeout(1000);
    }

    public String getOutput() {
        return page.textContent("#output");

    }
}
