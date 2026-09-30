package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class DogApiSteps {

    private String baseUri;
    private Response response;

    @Dado("que a URL base da Dog API é {string}")
    public void setBaseUrl(String url) {
        baseUri = url;
    }

    @Quando("eu faço uma requisição GET para {string}")
    public void requisicaoGet(String path) {
        response = RestAssured
                .given()
                .baseUri(baseUri)
                .accept("application/json")
                .when()
                .get(path)
                .then()
                .extract()
                .response();
    }

    @Entao("o código de status da resposta deve ser {int}")
    public void validarStatus(int status) {
        Assertions.assertEquals(status, response().getStatusCode());
    }

    @Entao("o status da API deve ser {string}")
    public void validarStatusApi(String status) {
        Assertions.assertEquals(status, response().jsonPath().getString("status"));
    }

    @Entao("a resposta deve conter uma lista não vazia em {string}")
    public void validarListaNaoVazia(String caminho) {
        List<?> lista = response().jsonPath().getList(caminho);
        Assertions.assertNotNull(lista, "A lista não foi encontrada em " + caminho);
        Assertions.assertFalse(lista.isEmpty(), "A lista está vazia em " + caminho);
    }

    @Entao("a mensagem da resposta deve ser uma URL de imagem válida")
    public void validarUrlDaImagem() {
        String url = response().jsonPath().getString("message");
        Assertions.assertNotNull(url, "A URL da imagem não foi encontrada");
        Assertions.assertTrue(
                url.startsWith("https://images.dog.ceo/breeds/"),
                "A URL da imagem tem formato inesperado: " + url
        );
    }

    private Response response() {
        Assertions.assertNotNull(response, "Nenhuma resposta foi recebida");
        return response;
    }
}
