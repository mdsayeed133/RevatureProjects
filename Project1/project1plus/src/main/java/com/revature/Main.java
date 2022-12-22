package com.revature;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;

import io.javalin.Javalin;


public class Main {
    public static void main(String[] args) {

        UserController userController= new UserController();
        ReimbursementController reimbursementController= new ReimbursementController();
        AuthController authController= new AuthController();


        Javalin app = Javalin.create(
                config -> {
                    config.enableCorsForAllOrigins(); //This lets us process HTTP Requests from anywhere
                }
        ).start(3000);

        app.post("/user", userController.insertNewUser);

        app.patch("/user/address", userController.patchUserAddress);

        app.patch("/user/role/{username}", userController.patchUsersRole);

        app.post("/reimb", reimbursementController.insertReimbursement);

        app.get("/reimb", reimbursementController.getAllReimbursement);

        app.get("/reimb/status/{statusId}", reimbursementController.getReimbursementByStatus);

        app.get("/reimb/user", reimbursementController.getReimbursementByUser);

        app.get("/reimb/user/type/{typeId}", reimbursementController.getReimbursementByType);

        app.patch("/reimb/status/{reimbId}", reimbursementController.patchReimbursementStatus);

        app.post("/login",authController.loginHandler);

    }
}