package com.revature;

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
        /*
        //new user
        User user= new User("user1","password",1);
        System.out.println(userDOA.insertUser(user));

        //new reimbursement
        Reimbursement reimbursement= new Reimbursement("user1",100.34,"dinner with client", 2,1);
        System.out.println(reimbursementDOA.insertReimbursement(reimbursement));

        //testing getAllReimbursement()
        ArrayList<Reimbursement>  allReimbursement =reimbursementDOA.getAllReimbursement();
        for (Reimbursement r: allReimbursement) {
            System.out.println(r);
        }

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

        app.get("/reimb/{username}", reimbursementController.getReimbursementByUser);

        app.patch("/reimb/status/{reimbId}", reimbursementController.patchReimbursementStatus);

    }
}

