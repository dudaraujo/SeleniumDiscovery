package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginTest {

   private LoginPage loginPage;

    @BeforeEach
    public void BeforeEach() {
        this.loginPage = new LoginPage();
    }

    @AfterEach
    public void AfterEach() {
        loginPage.Fechar();
    }

    @Test
    public void DeveriaRealizarLoginComDadosValidos() {

        loginPage.PreencheFormularioLogin("fulano", "pass");
        loginPage.EnviaFormularioLogin();

        Assert.assertFalse(loginPage.VerificaPaginaLogin());
        Assert.assertEquals("fulano", loginPage.VerificaNomeUsuarioLogado());

    }

    @Test
    public void NaoDeveriaLogarComDadosInvalidos() {

        loginPage.PreencheFormularioLogin("usuarioInvalido", "pass");
        loginPage.EnviaFormularioLogin();

        Assert.assertTrue(loginPage.VerificaPaginaErroLogin());
        Assert.assertTrue(loginPage.VerificaSeContemTexto("Usuário e senha inválidos."));
        Assert.assertNull(loginPage.VerificaNomeUsuarioLogado());

    }

    @Test
    public void NaoDeveriaAcessarPaginaRestritaSemEstarLogado() {

        loginPage.NavegaParaPagianDeLances();
        Assert.assertTrue(loginPage.VerificaPaginaLogin());
        Assert.assertFalse(loginPage.VerificaSeContemTexto("Dados do leilão"));

    }

}
