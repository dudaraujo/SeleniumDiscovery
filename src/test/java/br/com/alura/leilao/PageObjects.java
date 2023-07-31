package br.com.alura.leilao;

import org.h2.mvstore.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObjects {

    protected WebDriver browser;

    public PageObjects(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        if (browser == null) {
            this.browser = new ChromeDriver();
        } else {
            this.browser = browser;
        }

        this.browser.manage().timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS)
                .pageLoadTimeout(10,TimeUnit.SECONDS);
    }
        public void Fechar() {
            this.browser.quit();
        }


}
