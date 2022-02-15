package ru.mai.zaharix.cinemaapplastest.security.payload.response;

public class AuthResponse {
    private String token;
    private String type = "Bearer";
    private long id;
    private String name;
    private String surname;
    private String email;
    private String role;

    public AuthResponse(String accessToken, long id, String name, String surname, String email, String role) {
        this.token = accessToken;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }
}
