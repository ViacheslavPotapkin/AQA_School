package test;

import base.BaseTest;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class AntiPatternTest extends BaseTest {
    @Test
    public void validLoginTest() {
        open();
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $("#inventory_container").shouldBe(Condition.visible, Duration.ofSeconds(8));
        sleep(6000);
    }

    @Test
    public void invalidLoginTest() {
        open();
        $("#user-name").setValue("standard_user");
        $("#password").setValue("invalid_password");
        $("#login-button").click();
        $(".error-message-container").shouldBe(Condition.visible, Duration.ofSeconds(8));
        sleep(6000);
    }
}
