package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$;

@Accessors(fluent = true)
@NoArgsConstructor
public class LoginPage {

    private final SelenideElement userNameField = $("#user-name");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement loginButton = $("#login-button");
    private final SelenideElement errorMessage = $(".error-message-container");

    @Step("Set login")
    public LoginPage setLogin(String username) {
        userNameField.setValue(username);
        return this;
    }

    @Step("Set password")
    public LoginPage setPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Click login button")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Check error message")
    public LoginPage checkErrorMessage() {
        errorMessage.shouldBe(Condition.visible);
        return this;
    }
}
