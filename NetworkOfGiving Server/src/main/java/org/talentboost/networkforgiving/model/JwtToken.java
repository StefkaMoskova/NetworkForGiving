package org.talentboost.networkforgiving.model;

public class JwtToken {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtToken(String token) {
        this.token = token;
    }
}
