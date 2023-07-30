package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilão do dia" + hoje;
        String valor = "500.00";

        cadastroLeilaoPage.CadastraLeilao(nome, valor, hoje);
        this.leilaoPage = cadastroLeilaoPage.SalvaLeilao();

        Assert.assertTrue(leilaoPage.VerificaLeilaoCadastrado(nome, valor, hoje));

    }




}
