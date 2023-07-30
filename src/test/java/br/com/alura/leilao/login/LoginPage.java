package br.com.alura.leilao.login;

import br.com.alura.leilao.PageObjects;
import br.com.alura.leilao.leiloes.LeiloesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends PageObjects {
    public static final String URL_LOGIN = "http://localhost:8080/login";

    public LoginPage() {
        super(null);
        this.browser.navigate().to(URL_LOGIN);
    }

    public void PreencheFormularioLogin(String usuario, String senha) {
        browser.findElement(By.id("username")).sendKeys(usuario);
        browser.findElement(By.id("password")).sendKeys(senha);
    }

    public LeiloesPage EnviaFormularioLogin() {
        browser.findElement(By.id("login-form")).submit();
        //browser.findElement(By.xpath("//button")).click();
        return new LeiloesPage(browser);
    }

    public boolean VerificaPaginaLogin() {
        return browser.getCurrentUrl().equals(URL_LOGIN);
    }

    public boolean VerificaPaginaErroLogin() {
        return browser.getCurrentUrl().equals("http://localhost:8080/login?error");
    }

    public String VerificaNomeUsuarioLogado() {

        try {
            return browser.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }

    }

    public void NavegaParaPagianDeLances() {
        this.browser.navigate().to("http://localhost:8080/leiloes/2");
    }

    public boolean VerificaSeContemTexto(String texto) {
        return browser.getPageSource().contains(texto);
    }


}
