package tests;

import base.BaseTest;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Muted;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Test(groups = "all")
public class AntiPatternTest extends BaseTest {

    @Test(enabled = false)
    public void validLoginTest() {
        open();
        $("#user-name1").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $("#inventory_container").shouldBe(Condition.visible);
    }

    @Test()
    public void invalidLoginTest() {
        open();
        $("#user-name").setValue("standard_user");
        $("#password").setValue("invalid_password");
        $("#login-button").click();
        $(".error-message-container").shouldBe(Condition.visible);
    }
}
