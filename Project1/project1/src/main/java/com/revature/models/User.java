package com.revature.models;

public class User {
    private String ers_username;
    private String ers_password;
    private String user_first_name;
    private String user_last_name;
    private String ers_user_roles_id_fk;

    public User() {
    }

    public User(String ers_username, String ers_password, String user_first_name, String user_last_name, String ers_user_roles_id_fk) {
        this.ers_username = ers_username;
        this.ers_password = ers_password;
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.ers_user_roles_id_fk = ers_user_roles_id_fk;
    }

    public User(String ers_username, String ers_password, String ers_user_roles_id_fk) {
        this.ers_username = ers_username;
        this.ers_password = ers_password;
        this.ers_user_roles_id_fk = ers_user_roles_id_fk;
    }

    public String getErs_username() {
        return ers_username;
    }

    public void setErs_username(String ers_username) {
        this.ers_username = ers_username;
    }

    public String getErs_password() {
        return ers_password;
    }

    public void setErs_password(String ers_password) {
        this.ers_password = ers_password;
    }

    public String getUser_first_name() {
        return user_first_name;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    public String getUser_last_name() {
        return user_last_name;
    }

    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }

    public String getErs_user_roles_id_fk() {
        return ers_user_roles_id_fk;
    }

    public void setErs_user_roles_id_fk(String ers_user_roles_id_fk) {
        this.ers_user_roles_id_fk = ers_user_roles_id_fk;
    }
}
