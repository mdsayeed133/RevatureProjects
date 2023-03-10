import React, { useState, useEffect } from 'react'
import Header from '../Header/Header'
import axios from 'axios';

import "./AccountTransactions.css";
import{User} from '../../interfaces/users'
import { Account } from '../../interfaces/accounts';
import { Transaction } from '../../interfaces/transactions'
import { setEnvironmentData } from 'worker_threads';
import SendMoney from '../SendMoney/SendMoney';




const AccountTransactions: React.FC<any> = (props:any) => {
    console.log(props.user);
    console.log(props.account);
    const accountId:number= props.account.accountId; //props.accountId
    const accountType: string = props.account.accountType.accountTypeName; 
    const [amount, setAmount] = useState<number>(props.account.amount);
    const targetUser:User= props.user;

//const AccountTransactions: React.FC<any> = (any) => {
    //const accountId :number= 2; //props.accountId
    //const accountType: string = "saving"; 
    //const [amount, setAmount] = useState<number>(200);
    //const targetUser :any= undefined;


    const [transactions, setTransactions] = useState<Transaction[]>([]);
    
    React.useEffect(() => {
        const url = `http://localhost:5555/bank/transactions/account/${accountId}`;
        fetch(url).then(res => res.json()).then(item => (item));
        initialLoad()},[])

    const initialLoad = async () =>
    {
        const response = await axios.get(`http://localhost:5555/bank/transactions/account/${accountId}`);
        setTransactions(response.data);
        if (response.status === 200) {
            console.log(response.data);
            setTransactions(response.data);

        }
    }
    const loadIncome = async () =>
    {
        const response = await axios.get(`http://localhost:5555/bank/transactions/account/${accountId}/type/2`);
        setTransactions(response.data);
        if (response.status === 200) {
            console.log(response.data);
            setTransactions(response.data);

        }
    }
    
    const loadExpense = async () =>
    {
        const response = await axios.get(`http://localhost:5555/bank/transactions/account/${accountId}/type/1`);
        setTransactions(response.data);
        if (response.status === 200) {
            console.log(response.data);
            setTransactions(response.data);

        }
    }
    return (
        <div>
            {/* <body onload="initialLoad();"></body> */}
            <Header targetUser={targetUser}/>
            <div id="content-container">
                <div id="column1">
                    <h1>{accountType} Account Info</h1>
                    <p>Account Number: {accountId}</p>
                    <p>Balance: {amount}</p>
                    <SendMoney accountId={accountId} accountAmount={amount} setAmount={setAmount} />
                </div>
                <div id="column2">
                    <h1>Transaction History</h1>
                    <button onClick={()=>initialLoad()}>All</button>
                    <button onClick={()=>loadIncome()}>Income</button>
                    <button onClick={()=>loadExpense()}>Expense</button>
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
  /*
    const fillData = async (e:any) => {
        console.log(e.target.value);
        setSelectedType(e.target.value);
        if(selectedType=='0')
        {
           const response = await initialLoad();
        }
        else{
        console.log(selectedType); //not being set properly...
        console.log(`http://localhost:5555/bank/transactions/account/${accountId}/type/${selectedType}`);
        const response = await axios.get(`http://localhost:5555/bank/transactions/account/${accountId}/type/${selectedType}`);
        setTransactions(response.data);
        if (response.status === 200) {
            console.log(response.data);
            setTransactions(response.data)
        }
        }
    }
     useEffect(() => {
            axios.get('http://localhost:5555/bank/transactions/account/${selectedType}')
            .then(response => {
                setTransactions(response.data);
            })
            .catch(error => {
                console.log(error);
            });
        }, [selectedType]);
     */
    // React.useEffect(() => {initialLoad()},[])
    // const [transactions, setTransactions] = useState([]);
