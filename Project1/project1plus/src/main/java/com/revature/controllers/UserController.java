package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.doas.UserDOA;
import com.revature.models.User;
import io.javalin.http.Handler;

public class UserController {
    UserDOA userDOA = new UserDOA();

    public Handler insertNewUser = (ctx) -> {
        String body = ctx.body();
        Gson gson = new Gson();
        
        
        User jsonBody = gson.fromJson(body, User.class);
        String username= jsonBody.getErs_username();
        String password= jsonBody.getErs_password();
        String firstName =jsonBody.getUser_first_name();
        String lastName = jsonBody.getUser_last_name();
        String address= jsonBody.getUser_address();

        User newUser= new User(username,password, firstName,lastName,address);



        if(userDOA.insertUser(newUser) != null){
           // authController.newLogin(newUser,ctx);
            ctx.status(201); //201 "created"
            String result = gson.toJson(newUser);
            ctx.result(result);
        } else {
            ctx.status(406); //406 "not acceptable"
            ctx.result("Insert user failed!");
        }
    };

    public Handler patchUserAddress= (ctx)->{
        if(AuthController.ses != null ) {
            String userName= (String) AuthController.ses.getAttribute("ers_username");
            String address = ctx.body();

            if(userDOA.updateUsersAddress(userName,address)){
                ctx.status(202); //202 "accepted"
                ctx.result(userName+" address is now "+ address);
            } else {
                ctx.status(406); //406 "not acceptable"
                ctx.result("Address failed to update");
            }
        } else { //if the user is NOT logged in:
            ctx.result("YOU ARE UNAUTHORIZED TO ACCESS THIS FUNCTION");
            ctx.status(401); //401 "unauthorized"
        }
    };

    public Handler patchUsersRole= (ctx)->{
        if(AuthController.ses != null && (int)AuthController.ses.getAttribute("ers_user_roles_id_fk")==2) {
            String userName= ctx.pathParam("username");
            User currentUser= userDOA.getUserByUserName(userName);
            String body = ctx.body();
            int roleId;
            switch (body){
                case "1":
                case "employee":
                case "Employee":
                case "emp":
                    roleId= 1;
                    break;
                case "2":
                case "manager":
                case "Manager":
                case "man":
                    roleId=2;
                    break;
                default:
                    roleId= currentUser.getErs_user_roles_id_fk();
            }


            if(userDOA.updateUsersRole(userName,roleId)){
                ctx.status(202); //202 "accepted"
                String role = roleId== 1? "Employee":"Manager";
                ctx.result(userName+" role is now "+ role);
            } else {
                ctx.status(406); //406 "not acceptable"
                ctx.result("role failed to update");
            }
        } else { //if the user is NOT logged in:
            ctx.result("YOU ARE UNAUTHORIZED TO ACCESS THIS FUNCTION");
            ctx.status(401); //401 "unauthorized"
        }
    };

}
