package steps;

import io.cucumber.java.pt.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

public class DogApiSteps {

    private static String baseUri;
    private Response response;

    @Dado("que a URL base da Dog API é {string}")
    public void setBaseUrl(String url) {
        baseUri = url;
        RestAssured.baseURI = baseUri;
    }

    @Quando("eu faço uma requisição GET para {string}")
    public void requisicaoGet(String path) {
        response = RestAssured
                .given()
                .header("Accept", "application/json")
                .when()
                .get(path)
                .then()
                .extract()
                .response();
    }

    @Então("o código de status da resposta deve ser {int}")
    public void validarStatus(int status) {
        Assertions.assertEquals(status, response.getStatusCode());
    }


}
