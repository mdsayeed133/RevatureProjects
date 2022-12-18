package com.revature;

import com.revature.doas.ReimbursementDOA;
import com.revature.doas.UserDOA;
import com.revature.models.Reimbursement;
import com.revature.models.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        UserDOA userDOA= new UserDOA();
        ReimbursementDOA reimbursementDOA= new ReimbursementDOA();
        /*
        //new user
        User user= new User("user1","password",1);
        System.out.println(userDOA.insertUser(user));

        //new reimbursement
        Reimbursement reimbursement= new Reimbursement("user1",100.34,"dinner with client", 2,1);
        System.out.println(reimbursementDOA.insertReimbursement(reimbursement));
         */
        //testing getAllReimbursement()
        ArrayList<Reimbursement>  allReimbursement =reimbursementDOA.getAllReimbursement();
        for (Reimbursement r: allReimbursement) {
            System.out.println(r);
        }



    }
}

