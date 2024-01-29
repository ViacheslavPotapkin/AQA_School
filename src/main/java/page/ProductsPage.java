package page;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$$x;

@Accessors(fluent = true)
@NoArgsConstructor
public class ProductsPage {

    private final ElementsCollection productList = $$x("//div[@class='inventory_container']/div/div");

    @Step("Check product list")
    public void checkProductList(int expectedSize) {
        productList.shouldHave(CollectionCondition.size(expectedSize));
    }
}
