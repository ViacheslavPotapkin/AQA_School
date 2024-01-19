package test;

import base.BaseTest;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import page.LoginPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class PageObjectPatternTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage();

    @Test
    public void validLoginTest() {
        loginPage.setLogin("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        $("#inventory_container").shouldBe(Condition.visible, Duration.ofSeconds(8));
        sleep(6000);
    }

    @Test
    public void invalidLoginTest() {
        open();
        loginPage.setLogin("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        loginPage.checkErrorMessageAfterInvalidLogin();
        sleep(6000);
    }
}
