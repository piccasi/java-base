package declarative.requests;

import lombok.Data;

@Data
public class LoginReq {
    private String name;
    private String passwd;
}
