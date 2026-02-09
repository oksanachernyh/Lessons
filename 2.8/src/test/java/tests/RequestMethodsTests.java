package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import config.TestConfig;
import io.restassured.response.Response;
import models.BaseResponse;
import models.RequestBodyResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ResponseValidator;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestMethodsTests extends TestConfig {
    @Test
    @DisplayName("GET Request - Basic GET request")
    public void testGetRequest() {
        Response response = given()
                .spec(getRequestSpec())
                .when()
                .get("/get")
                .then()
                .extract()
                .response();

        // Проверка статус кода
        ResponseValidator.validateStatusCode(response.statusCode(), 200);

        // Проверка тела ответа
        BaseResponse responseBody = response.as(BaseResponse.class);
        ResponseValidator.validateBaseResponse(responseBody, "/get");

    }

    @Test
    @DisplayName("GET Request - With query parameters")
    public void testGetRequestWithParams() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("foo1", "bar1");
        queryParams.put("foo2", "bar2");

        Response response = given()
                .spec(getRequestSpec())
                .queryParams(queryParams)
                .when()
                .get("/get")
                .then()
                .extract()
                .response();

        // Проверка статус кода
        ResponseValidator.validateStatusCode(response.statusCode(), 200);

        // Проверка тела ответа
        BaseResponse responseBody = response.as(BaseResponse.class);
        ResponseValidator.validateBaseResponse(responseBody, "/get");

        // Дополнительная проверка query параметров
        assertEquals("bar1", responseBody.getArgs().get("foo1"));
        assertEquals("bar2", responseBody.getArgs().get("foo2"));
    }

    @Test
    @DisplayName("POST Request - Raw JSON")
    public void testPostRequestRawJson() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "John Doe");
        requestBody.put("email", "john@example.com");
        requestBody.put("age", 30);

        Response response = given()
                .spec(getRequestSpec())
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .extract()
                .response();

        // Проверка статус кода
        ResponseValidator.validateStatusCode(response.statusCode(), 200);

        // Проверка тела ответа
        RequestBodyResponse responseBody = response.as(RequestBodyResponse.class);
        ResponseValidator.validateRequestBodyResponse(responseBody, "/post", requestBody);
    }

    @Test
    @DisplayName("POST Request - Form data")
    public void testPostRequestFormData() throws JsonProcessingException {
        Map<String, String> jsonData = new HashMap<>();
        jsonData.put("username", "testuser");
        jsonData.put("password", "testpass");
        String jsonBody = new ObjectMapper().writeValueAsString(jsonData);

        Response response = given()
                .baseUri("https://postman-echo.com")
                .basePath("/post")
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .post()
                .then()
                .statusCode(200) // Проверка, что статус 200
                .extract()
                .response();

        // Проверка статус кода
        ResponseValidator.validateStatusCode(response.statusCode(), 200);

        // Проверка тела ответа
        RequestBodyResponse responseBody = response.as(RequestBodyResponse.class);
        ResponseValidator.validateBaseResponse(responseBody, "/post");
    }

    @Test
    @DisplayName("PUT Request")
    public void testPutRequest() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", 123);
        requestBody.put("title", "Updated Title");
        requestBody.put("completed", true);

        Response response = given()
                .spec(getRequestSpec())
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .extract()
                .response();

        // Проверка статус кода
        ResponseValidator.validateStatusCode(response.statusCode(), 200);

        // Проверка тела ответа
        RequestBodyResponse responseBody = response.as(RequestBodyResponse.class);
        ResponseValidator.validateRequestBodyResponse(responseBody, "/put", requestBody);
    }

    @Test
    @DisplayName("PATCH Request")
    public void testPatchRequest() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("status", "active");
        requestBody.put("updated", true);

        Response response = given()
                .spec(getRequestSpec())
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .extract()
                .response();

        // Проверка статус кода
        ResponseValidator.validateStatusCode(response.statusCode(), 200);

        // Проверка тела ответа
        RequestBodyResponse responseBody = response.as(RequestBodyResponse.class);
        ResponseValidator.validateRequestBodyResponse(responseBody, "/patch", requestBody);
    }

    @Test
    @DisplayName("DELETE Request")
    public void testDeleteRequest() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", 456);
        requestBody.put("reason", "no longer needed");

        Response response = given()
                .spec(getRequestSpec())
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .extract()
                .response();

        // Проверка статус кода
        ResponseValidator.validateStatusCode(response.statusCode(), 200);

        // Проверка тела ответа
        RequestBodyResponse responseBody = response.as(RequestBodyResponse.class);
        ResponseValidator.validateRequestBodyResponse(responseBody, "/delete", requestBody);
    }

    @Test
    @DisplayName("GET Request - With headers")
    public void testGetRequestWithHeaders() {
        Response response = given()
                .spec(getRequestSpec())
                .header("Custom-Header", "CustomValue")
                .header("X-Request-ID", "12345")
                .when()
                .get("/get")
                .then()
                .extract()
                .response();

        // Проверка статус кода
        ResponseValidator.validateStatusCode(response.statusCode(), 200);

        // Проверка тела ответа
        BaseResponse responseBody = response.as(BaseResponse.class);
        ResponseValidator.validateBaseResponse(responseBody, "/get");

        // Проверка заголовков в ответе
        Assertions.assertTrue(responseBody.getHeaders().containsKey("custom-header"));
        assertEquals("CustomValue", responseBody.getHeaders().get("custom-header"));
    }
}
