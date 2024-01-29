package tests;

import com.google.gson.Gson;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import response.DogResponse;

@Test(groups = "all")
public class ApiTest {

    @Test(description = "testRestAssured")
    public void testRestAssured() {
        var response = getMethod("/api/breeds/image/random", 200);

        var dogResponse = new Gson().fromJson(response, DogResponse.class);

        Assertions.assertThat(dogResponse.status())
                .as("Check status")
                .isEqualTo("success");
    }

    private String getMethod(String url, int status) {
        var baseUri = "https://dog.ceo";
        RequestSpecification specification = new RequestSpecBuilder()
                .setBaseUri(baseUri + url)
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .build();

        return RestAssured
                .given()
                .spec(specification)
                .when()
                .log().all()
                .get()
                .then()
                .log().all()
                .assertThat()
                .statusCode(status)
                .extract()
                .response()
                .getBody()
                .asString();
    }
}
