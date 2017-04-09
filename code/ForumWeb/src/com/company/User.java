package com.company;

/**
 * Created by jerieshasmith on 3/2/17.
 */
public class User {
    int id;
    String name;
    String password;

    public User(String name) {
        this.name = name;
    }

    public User(int id, String name, String password ){
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
