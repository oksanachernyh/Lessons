package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class TestConfig {
    public static final String BASE_URL = "https://postman-echo.com";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URL;

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }
}
