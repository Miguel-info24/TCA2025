package com.miguel.vannucci.models;

public class User {

    private String name;
    private String email;
    private String password;
    private String cpf;
    private String phone;
    private int id;
    private String type;

    public User(String name, String email, String password, String cpf, String phone, String type) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.phone = phone;
        this.id = 0;
        this.type = type;
    }

    public User() {}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPhone() {
        return phone;
    }
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", email='" + email + '\''
                + ", cpf='" + cpf + '\''
                + ", phone='" + phone + '\''
                +  ", id='" + id + '\'' 
                + ", type='" + type + '\'' + '}';
    }
}
