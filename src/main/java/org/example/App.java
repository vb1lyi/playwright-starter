package org.example;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://playwright.dev/");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/main/resources/example.png")));
        }
    }
}