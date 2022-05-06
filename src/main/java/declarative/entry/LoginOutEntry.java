package declarative.entry;

import declarative.OpenApi;

public class LoginOutEntry implements OpenApi {

    @Override
    public String call(String request) {
        return "login out";
    }
}
