package declarative.beans;

import lombok.Data;

@Data
public class OpenApiScheme {
    private String api;
    private String method;
    private String request;
    private String sucResponse;
    private String failResponse;
    private String entryPoint;
    private int rateLimit;
    private String failOver;
    private int timeOut;
}
