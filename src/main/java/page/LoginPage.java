package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

@Getter
@Accessors(fluent = true)
@NoArgsConstructor
public class LoginPage {

    private final SelenideElement loginField = $("#user-name");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement loginButton = $("#login-button");
    private final SelenideElement errorMessage = $(".error-message-container");

    public void setLogin(String login) {
        loginField.setValue(login);
    }

    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void checkErrorMessageAfterInvalidLogin() {
        errorMessage.shouldBe(Condition.visible, Duration.ofSeconds(8));
    }
}
