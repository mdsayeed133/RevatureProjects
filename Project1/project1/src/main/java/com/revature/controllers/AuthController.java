package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.doas.AuthDAO;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import javax.servlet.http.HttpSession;

public class AuthController {
    AuthDAO aDAO = new AuthDAO();

    //empty HttpSession object that will be filled upon successful login
    public static HttpSession ses;
    //to prevent functionalities from running until login, have them check whether this Session is null;

    //login will be a POST request, since the user is expected to send some data in the HTTP Request
    public Handler loginHandler = (ctx) -> {

        //ctx.body() to grab the HTTP Request data
        String body = ctx.body();

        //GSON for the JSON -> Java conversion
        Gson gson = new Gson();

        //take the incoming data, instantiate a LoginDTO class
        LoginDTO lDTO = gson.fromJson(body, LoginDTO.class); //.class means "turn this into a LoginDTO object"

        //if the login is successful, this Employee object will be populated. otherwise, null
        User loginUser = aDAO.login(lDTO.getErs_username(), lDTO.getErs_password());

        if(loginUser != null){

            //This is how we create sessions in Javalin 4
            ses = ctx.req.getSession();

            //we can use setAttribute() to set certain values to certain keys
            //THIS IS HOW WE CAN SAVE DATA IN A SESSION
            ses.setAttribute("ers_user_roles_id_fk", loginUser.getErs_user_roles_id_fk());
            ses.setAttribute("ers_username", loginUser.getErs_username());

            //newLogin(loginUser,ctx);

            //turn the employee back into JSON, so we can send it in the HTTP Response
            String userJSON = gson.toJson(loginUser);

            //ctx.result(userJSON);
            String name= (String) ses.getAttribute("ers_username");
            String role= (int) ses.getAttribute("ers_user_roles_id_fk") == 1?"employee":"manager";
            ctx.result("The user "+name+" is logged in as "+ role);
            ctx.status(202); //202 "accepted"
        } else {
            ctx.status(401); //401 "unauthorized"
            ctx.result("The UserName or Password is invalid");
        }

    };
    public void newLogin(User user, Context ctx){
        ses = ctx.req.getSession();

        ses.setAttribute("ers_user_roles_id_fk", user.getErs_user_roles_id_fk());
        ses.setAttribute("ers_username", user.getErs_username());
    }
}
