package test;

import base.BaseTest;
import com.codeborne.selenide.CollectionCondition;
import org.testng.annotations.Test;
import page.LoginPage;
import page.ProductsPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

public class PageObjectPatternTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final ProductsPage productsPage = new ProductsPage();

    @Test
    public void validLoginTest() {
        loginPage.setLogin("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.productList().shouldHave(CollectionCondition.size(6));
    }

    @Test
    public void invalidLoginTest() {
        open();
        loginPage.setLogin("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        loginPage.checkErrorMessageAfterInvalidLogin();
    }
}
