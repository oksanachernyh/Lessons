package utils;

import models.BaseResponse;
import models.RequestBodyResponse;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

public class ResponseValidator {
    public static void validateBaseResponse(BaseResponse response, String expectedUrlPart) {
        Assertions.assertNotNull(response, "Response should not be null");
        Assertions.assertNotNull(response.getArgs(), "Args should not be null");
        Assertions.assertNotNull(response.getHeaders(), "Headers should not be null");
        Assertions.assertNotNull(response.getUrl(), "URL should not be null");
        Assertions.assertTrue(response.getUrl().contains(expectedUrlPart),
                "URL should contain: " + expectedUrlPart);
    }

    public static void validateRequestBodyResponse(RequestBodyResponse response,
                                                   String expectedUrlPart,
                                                   Object expectedData) {
        validateBaseResponse(response, expectedUrlPart);

        if (expectedData != null) {
            Assertions.assertEquals(expectedData, response.getData(),
                    "Data should match request body");
        }

        Assertions.assertNotNull(response.getFiles(), "Files should not be null");
        Assertions.assertNotNull(response.getForm(), "Form should not be null");

        if (expectedData instanceof Map) {
            Assertions.assertNotNull(response.getJson(), "Json should not be null");
        }
    }

    public static void validateStatusCode(int actualStatusCode, int expectedStatusCode) {
        Assertions.assertEquals(expectedStatusCode, actualStatusCode,
                "Status code should be " + expectedStatusCode);
    }
}
