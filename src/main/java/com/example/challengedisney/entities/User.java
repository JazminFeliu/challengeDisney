package com.example.challengedisney.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private String name;
    private String email;
    private Integer api_calls_available; //200
    private Integer api_call_limit; //1000
    private String token; //nombre+numero aleatorio(jazmin654)
    private String tokenTemporal;
    private String justificacion;



    public User() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getApi_calls_available() {
        return api_calls_available;
    }

    public void setApi_calls_available(Integer api_calls_available) {
        this.api_calls_available = api_calls_available;
    }

    public Integer getApi_call_limit() {
        return api_call_limit;
    }

    public void setApi_call_limit(Integer api_call_limit) {
        this.api_call_limit = api_call_limit;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenTemporal() {
        return tokenTemporal;
    }

    public void setTokenTemporal(String tokenTemporal) {
        this.tokenTemporal = tokenTemporal;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }
}
