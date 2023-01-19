import React, { useState, useEffect } from 'react'
import Header from '../Header/Header'
import axios from 'axios';

import "./AccountTransactions.css";


interface Account{
    accountId: number;
    user: {
      userId: number;
      username: string;
      password: string;
      firstName: string;
      lastName: string;
      address: string;
      email: string;
    };
    amount: number;
    accountType: {
      accountTypeId: number;
      accountTypeName: string;
    }
}
interface Transaction {
  transactionId: number;
  account: {
    accountId: number;
    user: {
      userId: number;
      username: string;
      password: string;
      firstName: string;
      lastName: string;
      address: string;
      email: string;
    };
    amount: number;
    accountType: {
      accountTypeId: number;
      accountTypeName: string;
    }
  },
  amount: number;
  description: string;
  type: {
    transactionTypeId: number;
    transactionTypesName: string;
  }
}


interface Props {
  accountinfo: Account;
}

const AccountTransactions: React.FC<Props> = ({ accountinfo }) => {
    
    /*Example*/
    const [transactions, setTransactions]= useState<Transaction[]>([]);
    const [selectedType, setSelectedType] = useState("${accountId}");
    
    const fillData = async () => {
       const response = await axios.get("http://localhost:5555/bank/transactions/account/${selectedType}");
       setTransactions(response.data);
       if(response.status===200)
       {
            console.log(response.data);
            setTransactions(response.data);

       }
    } 
    /**
     useEffect(() => {
            axios.get("http://localhost:5555/bank/transactions/account/${selectedType}")
            .then(response => {
                setTransactions(response.data);
            })
            .catch(error => {
                console.log(error);
            });
        }, [selectedType]);
     */

    
    return (
        <div>
            <Header/>
            <div id="content-container">
                <div id="column1">
                    <h1>{accountinfo.accountType.accountTypeName} Account Info</h1>
                    <p>Account Number: {accountinfo.accountId}</p>
                    <p>Balance: {accountinfo.amount}</p>
                </div>
                <div id="column2">
                    <h1>Transaction History</h1>
                    <select value={selectedType} onChange={e => setSelectedType(e.target.value)}>
                        <option value="${accountId}">All</option>
                        <option value="${accountId}/type/1">Expense</option>
                        <option value="${accountId}/type/2">Income</option>
                    </select>
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

export default AccountTransactions;


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