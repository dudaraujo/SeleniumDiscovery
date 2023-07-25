package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class LeiloesTest {

    private LeiloesPage leilaoPage;

    @AfterEach
    public void AfterEach() {
        this.leilaoPage.Fechar();
    }

    @Test
    public void DeveriaCriarLeilao() {
        LoginPage loginPage = new LoginPage();
        loginPage.PreencheFormularioLogin("fulano", "pass");
        this.leilaoPage = loginPage.EnviaFormularioLogin();
        CadastroLeilaoPage cadastroLeilaoPage = leilaoPage.AbreFormulario();

    }




}
