package page;

import com.codeborne.selenide.ElementsCollection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$$x;

@Getter
@Accessors(fluent = true)
@NoArgsConstructor
public class ProductsPage {

    private final ElementsCollection productList = $$x(".inventory_list");
}
