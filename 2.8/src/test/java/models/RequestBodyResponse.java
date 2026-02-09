package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class RequestBodyResponse extends BaseResponse {
    @JsonProperty("data")
    private Object data;

    @JsonProperty("files")
    private Map<String, String> files;

    @JsonProperty("form")
    private Map<String, String> form;

    @JsonProperty("json")
    private Map<String, Object> json;
}
