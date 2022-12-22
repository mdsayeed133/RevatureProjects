package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.doas.ReimbursementDOA;
import com.revature.models.Reimbursement;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class ReimbursementController {
    ReimbursementDOA reimbursementDOA = new ReimbursementDOA();

    public Handler insertReimbursement = (ctx) -> {
        if(AuthController.ses != null && (int)AuthController.ses.getAttribute("ers_user_roles_id_fk")==1) {
            String body = ctx.body();
            Gson gson = new Gson();
            Reimbursement jsonBody = gson.fromJson(body, Reimbursement.class);
            //String reimbUsernameFk = jsonBody.getReimb_username_fk();
            String reimbUsernameFk1 = (String) AuthController.ses.getAttribute("ers_username");
            double reimbAmount = jsonBody.getReimb_amount();
            String reimbDescription = jsonBody.getReimb_description();
            //if type not provided set it to other
            int reimbTypeIdFk = jsonBody.getErs_reimbursement_type_id_fk()==0? 4:jsonBody.getErs_reimbursement_type_id_fk();

            Reimbursement newReimbursement= new Reimbursement(reimbUsernameFk1,reimbAmount,reimbDescription,reimbTypeIdFk);

            if (reimbursementDOA.insertReimbursement(newReimbursement)!=null) {
                ctx.status(201); //201 "created"
                String result = gson.toJson(newReimbursement);
                ctx.result(result);
            } else {
                ctx.status(406); //406 "not acceptable"
                ctx.result("Insert Reimbursement failed!");
            }
        } else { //if the user is NOT logged in:
            ctx.result("YOU ARE UNAUTHORIZED TO ACCESS THIS FUNCTION");
            ctx.status(401); //401 "unauthorized"
        }
    };

    public Handler getAllReimbursement= (ctx)-> {
        if(AuthController.ses != null && (int)AuthController.ses.getAttribute("ers_user_roles_id_fk")==2) {

            Gson gson = new Gson();

            ArrayList<Reimbursement> reimbursements= reimbursementDOA.getAllReimbursement();
            String jsonReimb = gson.toJson(reimbursements);

            ctx.result(jsonReimb);
            //we can set status code with ctx.status()
            ctx.status(202);
        } else { //if the user is NOT logged in:
            ctx.result("YOU ARE UNAUTHORIZED TO ACCESS THIS FUNCTION");
            ctx.status(401); //401 "unauthorized"
        }
    };

    public Handler getReimbursementByStatus= (ctx)-> {
        if(AuthController.ses != null && (int)AuthController.ses.getAttribute("ers_user_roles_id_fk")==2) {
            Gson gson = new Gson();
            int statusId;
            String parameter= ctx.pathParam("statusId");
            switch (parameter){
                case "1":
                case "pending":
                    statusId= 1;
                    break;
                case "2":
                case "approve":
                    statusId=2;
                    break;
                case "3":
                case "deny":
                    statusId=3;
                    break;
                default:
                    statusId = Integer.parseInt(ctx.pathParam("statusId"));
            }

            ArrayList<Reimbursement> reimbursements= reimbursementDOA.getReimbursementByStatus(statusId);
            String jsonReimb = gson.toJson(reimbursements);

            ctx.result(jsonReimb);
            //we can set status code with ctx.status()
            ctx.status(202);
        } else { //if the user is NOT logged in:
            ctx.result("YOU ARE UNAUTHORIZED TO ACCESS THIS FUNCTION");
            ctx.status(401); //401 "unauthorized"
        }
    };

    public Handler getReimbursementByUser= (ctx)-> {
        if(AuthController.ses != null && (int)AuthController.ses.getAttribute("ers_user_roles_id_fk")==1) {
            Gson gson = new Gson();
            String userName= (String) AuthController.ses.getAttribute("ers_username");
            ArrayList<Reimbursement> reimbursements= reimbursementDOA.getReimbursementByUsername(userName);
            String jsonReimb = gson.toJson(reimbursements);

            ctx.result(jsonReimb);
            //we can set status code with ctx.status()
            ctx.status(202);
        } else { //if the user is NOT logged in:
            ctx.result("YOU ARE UNAUTHORIZED TO ACCESS THIS FUNCTION");
            ctx.status(401); //401 "unauthorized"
        }
    };

    public Handler patchReimbursementStatus= (ctx)->{
        if(AuthController.ses != null && (int)AuthController.ses.getAttribute("ers_user_roles_id_fk")==2) {
            Gson gson = new Gson();
            int reimbId= Integer.parseInt(ctx.pathParam("reimbId"));
            String body = ctx.body();
            int statusId;
            switch (body){
                case "2":
                case "approve":
                case "yes":
                case "y":
                    statusId=2;
                    break;
                case "3":
                case "deny":
                case "no":
                case "n":
                    statusId=3;
                    break;
                default:
                    statusId=1;
                    break;
            }
            if(reimbursementDOA.updateReimbursementStatus(reimbId,statusId)){
                ctx.status(202); //202 "accepted"
                String status= statusId==2? "approved":"denied";
                ctx.result("Reimbursement "+reimbId+" is "+status);
            } else {
                ctx.status(406); //406 "not acceptable"
                ctx.result("This reimbursement has already been processed");
            }
        } else { //if the user is NOT logged in:
            ctx.result("YOU ARE UNAUTHORIZED TO ACCESS THIS FUNCTION");
            ctx.status(401); //401 "unauthorized"
        }
    };
}
