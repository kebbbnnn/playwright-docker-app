package org.kebbbnnn;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CookieService {
    @Transactional
    public void fetchAndStoreCookies() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(true));
            Page page = browser.newPage();
            page.navigate("https://google.com");
            String cookies = page.context().cookies().toString();

            CookieEntity cookieEntity = new CookieEntity();
            cookieEntity.setCookies(cookies);
            cookieEntity.persist();
        }
    }
}

