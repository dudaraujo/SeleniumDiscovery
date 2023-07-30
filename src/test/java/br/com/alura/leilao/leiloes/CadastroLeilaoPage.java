package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {

    private WebDriver browser;
    public static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";

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

    public boolean VerificaPaginaCadastro() {
        return browser.getCurrentUrl().equals(URL_CADASTRO_LEILAO);
    }

    public boolean VerificaMensagensValidacao() {
        String pageSource = browser.getPageSource();
        return pageSource.contains("não deve estar em branco")
                && pageSource.contains("minimo 3 caracteres")
                && pageSource.contains("deve ser um valor maior de 0.1")
                && pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
    }

}
