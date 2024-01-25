package page;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$$x;

@Accessors(fluent = true)
@NoArgsConstructor
public class ProductsPage {

    private final ElementsCollection productList = $$x("//div[@class='inventory_container']/div/div");

    public void checkProductList(){
        productList.shouldHave(CollectionCondition.size(6));
    }
}
