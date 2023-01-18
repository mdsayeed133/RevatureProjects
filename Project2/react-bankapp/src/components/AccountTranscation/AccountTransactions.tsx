import React, { useState, useEffect } from 'react'
import Header from '../Header/Header'
import axios from 'axios';

import "./AccountTransactions.css";

const AccountTransactions: React.FC<any> = ({ accountId, accountType, accountNumber, balance }) => {
    
    /*Example*/
    const [transactions, setTransactions]= useState<any[]>([]);
    
    const fillData = async () => {
       const response = await axios.get('localhost:5555/bank/transactions/account/${accountId}');
       setTransactions(response.data);
       if(response.status===200)
       {
            console.log(response.data);
            setTransactions(response.data);

       }
    } 

    
    return (
        <div>
            <Header/>
            <div id="content-container">
                <div id="column1">
                    <h1>Account Info</h1>
                    <p>Account Number: {accountNumber}/ {accountType}</p>
                    <p>Balance: {balance}</p>
                </div>
                <div id="column2">
                    <h1>Transaction History</h1>
                    {transactions.map((transaction, index) => (
                        <div id="transaction" key={index}>
                            <p>Transaction ID: {transaction.transactionId}</p>
                            <p>Amount: {transaction.amount}</p>
                            <p>Description: {transaction.description}</p>
                            <p>Type: {transaction.type.transactionTypesName}</p>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    )
}


/*
import React from 'react'

import "./Pokemon.css"

const Pokemon: React.FC<any> = (props:any) => {
  return (
    <div className="pokemon-container">
        <img className="pokemon-pic" src={props.sprite} alt={"An image of a shiny "+props.name}/>
        <br/>
        <h3>{props.name}</h3>
    </div>
  )
}

export default Pokemon */


/*axios login function

const login = async () =>
{
    //send an http post request with axios, and store the response in a variable that we can use.
    const response = await axios.post("http://localhost:5000/auth", {username,password})

    if(response.status === 202) //if the user successfully logged in.
    {
        console.log(response);
        //populate our user object from above with the data incoming from the server.
        user.id = response.data.id;
        user.username = response.data.username;
        user.password = response.data.password;

        //if the user logged in successfully, their id won't be 0.
        if(user.id > 0)
        {
            navigate("/home") //thanks to navigate, we can route to the home component automatically.
        }
    }
}

*/