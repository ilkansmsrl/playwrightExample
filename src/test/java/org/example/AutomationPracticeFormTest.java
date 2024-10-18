package org.example;

import com.microsoft.playwright.*;
import org.example.pages.AutomationPracticeFormPage;
import org.junit.jupiter.api.*;

public class AutomationPracticeFormTest {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private AutomationPracticeFormPage formPage;

    @BeforeEach
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        formPage = new AutomationPracticeFormPage(page);
    }

    @Test
    public void testFillAutomationPracticeForm() {
        // Form sayfasına git
        formPage.navigate();

        // Formu doldur
        formPage.fillFirstName("John");
        formPage.fillLastName("Doe");
        formPage.fillEmail("john.doe@example.com");
        formPage.fillPhone("1234567890");
        formPage.selectGender("Male");
        formPage.selectHobby("Sports");

        // Formu gönder
        formPage.submit();

        // Başarı mesajını kontrol et
        String successMessage = formPage.getSuccessMessage();
        System.out.println("Success Message: " + successMessage);
        Assertions.assertEquals("Thanks for submitting the form", successMessage.trim()); // trim() ile boşlukları kaldır
    }

    @AfterEach
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
