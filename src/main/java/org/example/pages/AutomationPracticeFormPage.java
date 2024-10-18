package org.example.pages;

import com.microsoft.playwright.Page;

public class AutomationPracticeFormPage {
    private Page page;

    public AutomationPracticeFormPage(Page page) {
        this.page = page;
    }

    public void navigate() {
        page.navigate("https://demoqa.com/automation-practice-form");
    }

    public void fillFirstName(String firstName) {
        page.fill("#firstName", firstName);
        page.waitForTimeout(1000);
    }

    public void fillLastName(String lastName) {
        page.fill("#lastName", lastName);
        page.waitForTimeout(1000);
    }

    public void fillEmail(String email) {
        page.fill("#userEmail", email);
        page.waitForTimeout(1000);
    }

    public void fillPhone(String phone) {
        page.fill("#userNumber", phone);
        page.waitForTimeout(1000);
    }

    public void selectGender(String gender) {
        // Cinsiyet seçimini yapma (örneğin, "Male" için)
        page.click("label[for='gender-radio-1']");
        page.waitForTimeout(1000);
    }

    public void selectHobby(String hobby) {
        // Hobi seçimini yapma (örneğin, "Sports" için)
        page.check("label[for='hobbies-checkbox-1']");
        page.waitForTimeout(1000);
    }

    public void submit() {
        page.click("#submit");
        page.waitForTimeout(2000);
    }

    public String getSuccessMessage() {
        page.waitForSelector(".modal-title.h4", new Page.WaitForSelectorOptions().setTimeout(10000)); // 10 saniye bekle
        return page.textContent(".modal-title.h4"); // Pop-up içeriğini al
    }

    public boolean isFieldErrorDisplayed(String fieldName) {
        return page.isVisible("div[data-field='" + fieldName + "'] .field-error");
    }

    public String getErrorMessage() {
        return page.textContent(".error-message"); // Genel hata mesajını almak için
    }
}
