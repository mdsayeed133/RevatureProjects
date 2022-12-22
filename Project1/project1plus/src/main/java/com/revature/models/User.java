package com.revature.models;

import com.revature.doas.RoleDOA;

public class User {
    private String ers_username;
    private String ers_password;
    private String user_first_name;
    private String user_last_name;
    private String user_address;
    private int ers_user_roles_id_fk;
    private Role role;


    public User() {
    }

    public User(String ers_username, String ers_password, String user_first_name, String user_last_name, int ers_user_roles_id_fk) {
        RoleDOA roleDOA= new RoleDOA();

        this.ers_username = ers_username;
        this.ers_password = ers_password;
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.ers_user_roles_id_fk = ers_user_roles_id_fk;
        this.role= roleDOA.getRoleById(ers_user_roles_id_fk);
    }

    public User(String ers_username, String ers_password, String user_first_name, String user_last_name, String user_address, int ers_user_roles_id_fk) {
        RoleDOA roleDOA= new RoleDOA();

        this.ers_username = ers_username;
        this.ers_password = ers_password;
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.user_address = user_address;
        this.ers_user_roles_id_fk = ers_user_roles_id_fk;
        this.role= roleDOA.getRoleById(ers_user_roles_id_fk);
    }

    //if create without role set default to employee
    public User(String ers_username, String ers_password, String user_first_name, String user_last_name) {
        RoleDOA roleDOA= new RoleDOA();

        this.ers_username = ers_username;
        this.ers_password = ers_password;
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.ers_user_roles_id_fk = 1;
        this.role= roleDOA.getRoleById(1);
    }

    public User(String ers_username, String ers_password, String user_first_name, String user_address,String user_last_name) {
        RoleDOA roleDOA= new RoleDOA();

        this.ers_username = ers_username;
        this.ers_password = ers_password;
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.user_address= user_address;
        this.ers_user_roles_id_fk = 1;
        this.role= roleDOA.getRoleById(1);
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

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public int getErs_user_roles_id_fk() {
        return ers_user_roles_id_fk;
    }

    public void setErs_user_roles_id_fk(int ers_user_roles_id_fk) {
        RoleDOA roleDOA= new RoleDOA();
        this.role= roleDOA.getRoleById(ers_user_roles_id_fk);
        this.ers_user_roles_id_fk = ers_user_roles_id_fk;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
        this.ers_user_roles_id_fk= role.getRole_id();
    }

    @Override
    public String toString() {
        return "User{" +
                "ers_username='" + ers_username + '\'' +
                ", ers_password='" + ers_password + '\'' +
                ", user_first_name='" + user_first_name + '\'' +
                ", user_last_name='" + user_last_name + '\'' +
                ", user_address='"+user_address+'\''+
                ", role=" + role +
                '}';
    }
}
