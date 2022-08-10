package com.coffee.model.jwt;

import java.io.Serializable;
import java.util.List;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private List<String> grantList;

    public JwtResponse(String jwttoken, List<String> grantList) {
        this.jwttoken = jwttoken;
        this.grantList = grantList;
    }

    public List<String> getGrantList() {
        return grantList;
    }

    public String getToken() {
        return this.jwttoken;
    }
}
