package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class BaseResponse {
    @JsonProperty("args")
    private Map<String, String> args;

    @JsonProperty("headers")
    private Map<String, String> headers;

    @JsonProperty("url")
    private String url;
}
