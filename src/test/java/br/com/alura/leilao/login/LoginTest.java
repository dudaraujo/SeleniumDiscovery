package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static final String URL_LOGIN = "http://localhost:8080/login?error";
    private WebDriver browser;

    @BeforeAll
    public static void BeforeAll() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    }

    @BeforeEach
    public void BeforeEach() {
        this.browser = new ChromeDriver();
        browser.navigate().to(URL_LOGIN);
    }

    @AfterEach
    public void AfterEach() {
        browser.quit();
    }

    @Test
    public void DeveriaRealizarLoginComDadosValidos() {

        browser.findElement(By.id("username")).sendKeys("fulano");
        browser.findElement(By.id("password")).sendKeys("pass");
        browser.findElement(By.id("login-form")).submit();

        Assert.assertFalse(browser.getCurrentUrl().equals("http://localhost:8080/login"));
        Assert.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());

    }

    @Test
    public void NaoDeveriaLogarComDadosInvalidos() {

        browser.findElement(By.id("username")).sendKeys("userInvalido");
        browser.findElement(By.id("password")).sendKeys("pass");
        browser.findElement(By.xpath("//button")).click();

        Assert.assertTrue(browser.getCurrentUrl().equals(URL_LOGIN));
        Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
        Assert.assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("usuario-logado")));

    }

}
