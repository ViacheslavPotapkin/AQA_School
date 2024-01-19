package test;

import base.BaseTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class PatternTest extends BaseTest {

    @Test
    public void test() {
        open("https://www.saucedemo.com/");
        sleep(6000);
    }
}
