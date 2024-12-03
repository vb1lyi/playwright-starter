package org.example;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@UsePlaywright
public class PlaywrightFixturesTest {
    @Test
    void shouldClickButton(Page page) {
        page.navigate("data:text/html,<script>var result;</script><button onclick='result=\"Clicked\"'>Go</button>");
        page.locator("button").click();
        assertEquals("Clicked", page.evaluate("result"));
    }

    @Test
    void shouldCheckTheBox(Page page) {
        page.setContent("<input id='checkbox' type='checkbox'></input>");
        page.locator("input").check();
        assertEquals(true, page.evaluate("window['checkbox'].checked"));
    }

    @Test
    void shouldSearchWiki(Page page) {
        page.navigate("https://www.wikipedia.org/");
        page.locator("input[name=\"search\"]").click();
        page.locator("input[name=\"search\"]").fill("playwright");
        page.locator("input[name=\"search\"]").press("Enter");
        assertThat(page).hasURL("https://en.wikipedia.org/wiki/Playwright");
    }
}
