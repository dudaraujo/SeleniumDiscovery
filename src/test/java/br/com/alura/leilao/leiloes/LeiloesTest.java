package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeiloesTest {

    private LeiloesPage leilaoPage;
    private CadastroLeilaoPage cadastroLeilaoPage;

    @BeforeEach
    public void BeforeEach() {
        LoginPage loginPage = new LoginPage();
        loginPage.PreencheFormularioLogin("fulano", "pass");
        this.leilaoPage = loginPage.EnviaFormularioLogin();
        this.cadastroLeilaoPage = leilaoPage.AbreFormulario();
    }

    @AfterEach
    public void AfterEach() {
        this.leilaoPage.Fechar();
    }

    @Test
    public void DeveriaCriarLeilao() {

        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilão do dia" + hoje;
        String valor = "500.00";

        cadastroLeilaoPage.CadastraLeilao(nome, valor, hoje);
        this.leilaoPage = cadastroLeilaoPage.SalvaLeilao();

        Assert.assertTrue(leilaoPage.VerificaLeilaoCadastrado(nome, valor, hoje));

    }

    @Test
    public void DeveriaValidarCamposObrigatórios() {

        cadastroLeilaoPage.CadastraLeilao("", "", "");
        this.leilaoPage = cadastroLeilaoPage.SalvaLeilao();

        Assert.assertFalse(this.cadastroLeilaoPage.VerificaPaginaCadastro());
        Assert.assertTrue(this.cadastroLeilaoPage.VerificaMensagensValidacao());

    }




}
