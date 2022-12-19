package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.doas.ReimbursementDOA;
import com.revature.models.Reimbursement;
import io.javalin.http.Handler;

public class ReimbursementController {
    ReimbursementDOA reimbursementDOA = new ReimbursementDOA();

    public Handler insertReimbursement = (ctx) -> {
        String body = ctx.body();
        Gson gson = new Gson();
        Reimbursement jsonBody = gson.fromJson(body, Reimbursement.class);
        String reimbUsernameFk = jsonBody.getReimb_username_fk();
        double reimbAmount = jsonBody.getReimb_amount();
        String reimbDescription = jsonBody.getReimb_description();
        //if type not provided set to other
        int reimbTypeIdFk = jsonBody.getErs_reimbursement_type_id_fk()==0? 4:jsonBody.getErs_reimbursement_type_id_fk();

        Reimbursement newReimbursement= new Reimbursement(reimbUsernameFk,reimbAmount,reimbDescription,reimbTypeIdFk);

        if (reimbursementDOA.insertReimbursement(newReimbursement)!=null) {
            ctx.status(201); //201 "created"
            ctx.result(body);
        } else {
            ctx.status(406); //406 "not acceptable"
            ctx.result("Insert employee failed!");
        }
    };

}
