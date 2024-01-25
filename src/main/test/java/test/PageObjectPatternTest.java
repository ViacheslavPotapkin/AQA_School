package test;

import base.BaseTest;
import org.testng.annotations.Test;
import page.LoginPage;
import page.ProductsPage;

import static com.codeborne.selenide.Selenide.sleep;

public class PageObjectPatternTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final ProductsPage productsPage = new ProductsPage();

    @Test
    public void invalidLogin() {
        loginPage.setLogin("standard_user")
                .setPassword("secret_sauce")
                .clickLoginButton()
                .checkErrorMessage();
        sleep(10000);
    }

    @Test
    public void validLogin() {
        loginPage.setLogin("standard_user")
                .setPassword("secret_sauce")
                .clickLoginButton();
        productsPage.checkProductList();
    }
}
