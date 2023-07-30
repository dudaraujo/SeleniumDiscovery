package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {

    private WebDriver browser;

    public CadastroLeilaoPage(WebDriver browser) {
        this.browser = browser;
    }

    public void Fechar() {
        this.browser.quit();
    }

    public void CadastraLeilao(String nome, String valor, String hoje) {
        browser.findElement(By.id("nome")).sendKeys(nome);
        browser.findElement(By.id("valorInicial")).sendKeys(valor);
        browser.findElement(By.id("dataAbertura")).sendKeys(hoje);
    }

    public LeiloesPage SalvaLeilao() {
        browser.findElement(By.id("button-submit")).submit();
        return new LeiloesPage(browser);
    }

}
