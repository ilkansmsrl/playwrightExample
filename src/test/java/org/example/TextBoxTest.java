package org.example;

import com.microsoft.playwright.*;
import org.example.pages.TextBoxPage;
import org.junit.jupiter.api.*;

public class TextBoxTest {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private TextBoxPage textBoxPage;

    @BeforeEach
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        textBoxPage = new TextBoxPage(page);
    }

    @Test
    public void testFillTextBox() {
        textBoxPage.navigate();
        textBoxPage.fillName("John Doe");
        textBoxPage.fillEmail("john.doe@example.com");
        textBoxPage.fillCurrentAddress("123 Elm Street");
        textBoxPage.fillPermanentAddress("456 Oak Avenue");
        textBoxPage.submit();

        String output = textBoxPage.getOutput();
        System.out.println(output); // Çıktıyı konsola yazdır
    }

    @AfterEach
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
