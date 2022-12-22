package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.doas.UserDOA;
import com.revature.models.User;
import io.javalin.http.Handler;

public class UserController {
    UserDOA userDOA = new UserDOA();
    //AuthController authController = new AuthController();

    public Handler insertNewUser = (ctx) -> {
        String body = ctx.body();
        Gson gson = new Gson();
        
        
        User jsonBody = gson.fromJson(body, User.class);
        String username= jsonBody.getErs_username();
        String password= jsonBody.getErs_password();
        String firstName =jsonBody.getUser_first_name();
        String lastName = jsonBody.getUser_last_name();

        User newUser= new User(username,password, firstName,lastName);



        if(userDOA.insertUser(newUser) != null){
           // authController.newLogin(newUser,ctx);
            ctx.status(201); //201 "created"
            String result = gson.toJson(newUser);
            ctx.result(result); //send back the user
        } else {
            ctx.status(406); //406 "not acceptable"
            ctx.result("Insert user failed!");
        }
    };

}
