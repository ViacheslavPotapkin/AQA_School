package tests;

import base.BaseTest;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.awaitility.AllureAwaitilityListener;
import lombok.NonNull;
import org.awaitility.Awaitility;
import org.testng.annotations.Test;
import page.LoginPage;
import page.ProductsPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


@Test(groups = "all")
public class PageObjectPatternTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final ProductsPage productsPage = new ProductsPage();

    @Test()
    public void invalidLogin() {
        loginPage.setLogin("standard_user")
                .setPassword("secret_saucerrr")
                .clickLoginButton()
                .checkErrorMessage();
    }

    @Test()
    public void validLogin() {
        loginPage.setLogin("standard_user")
                .setPassword("secret_sauce")
                .clickLoginButton();
        productsPage.checkProductList(6);
    }


    @Step("Wait load page")
    private void waitForPage(@NonNull String url) {
        Awaitility.await()
                .alias("Wait open url: " + url)
                .conditionEvaluationListener(new AllureAwaitilityListener())
                .pollInSameThread()
                .pollDelay(Duration.ofSeconds(1))
                .atMost(Duration.ofSeconds(10))
                .pollInterval(1, TimeUnit.SECONDS)
                .until(() -> currentUrl().contains(url));
    }

    @Step("Get current URL")
    private String currentUrl() {
        var url = WebDriverRunner.url();
        Allure.addAttachment("Current URL", url);
        return url;
    }
}
