package com.revature;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;
import com.revature.doas.ReimbursementDOA;
import com.revature.doas.UserDOA;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        UserDOA userDOA= new UserDOA();
        ReimbursementDOA reimbursementDOA= new ReimbursementDOA();
        UserController userController= new UserController();
        ReimbursementController reimbursementController= new ReimbursementController();
        AuthController authController= new AuthController();
        /*
        //add manager
        User manager= new User("manager","manager",2);
        System.out.println(userDOA.insertUser(manager));

        //add employee
        User emp = new User("employee", "employee",1);
        System.out.println(userDOA.insertUser(emp));

        //new reimbursement
        Reimbursement reimbursement= new Reimbursement("employee",1053.23,"house party",4);
        System.out.println(reimbursementDOA.insertReimbursement(reimbursement));

        */

        Javalin app = Javalin.create(
                config -> {
                    config.enableCorsForAllOrigins(); //This lets us process HTTP Requests from anywhere
                }
        ).start(3000);

        app.post("/user", userController.insertNewUser);

        app.post("/reimb", reimbursementController.insertReimbursement);

        app.get("/reimb", reimbursementController.getAllReimbursement);

        app.get("/reimb/status/{statusId}", reimbursementController.getReimbursementByStatus);

        app.get("/reimb/user", reimbursementController.getReimbursementByUser);

        app.patch("/reimb/status/{reimbId}", reimbursementController.patchReimbursementStatus);

        app.post("/login",authController.loginHandler);

    }
}