import React, { useState, useEffect } from 'react'
import { Link, useNavigate } from 'react-router-dom'

import '../Account/Account.css'
import Header from '../Header/Header'
import Requests from '../Requests/Requests'
import axios from 'axios';
import { Transaction } from '../../interfaces/transactions'

const Account = (props:any) => {
    const navigate = useNavigate();
    const accountTrans = async ()=>{
        navigate("/accounttransactions");
    }

    const profile = async ()=>{
        navigate("/userprofile")
    }

    const createAccountBtn = async ()=>{
        navigate("/createaccount")
    }

    //this is using axios
    // create useState hooks to declare the states
    // const [username, setUsername] = useState("");
    // const [account, setAccount] = useState("");
    // const [balance, setBalance] = useState("");


    const [transactions, setTransactions] = useState<Transaction[]>([]);

    const fillTransactions = async () => {
        const response = await axios.get('localhost:5555/bank/transactions/account/${selectedType}');
        setTransactions(response.data);
        if (response.status === 200) {
            console.log(response.data);
            setTransactions(response.data);

        }
    }

    const fillAccounts = async () => {
        const response = await axios.get('localhost:5555/bank/transactions/account/${selectedType}');
        setTransactions(response.data);
        if (response.status === 200) {
            console.log(response.data);
            setTransactions(response.data);

        }
    }

    const fillRequests = async () => {
        const response = await axios.get('localhost:5555/bank/transactions/account/${selectedType}');
        setTransactions(response.data);
        if (response.status === 200) {
            console.log(response.data);
            setTransactions(response.data);

        }
    }

    const logout = async ()=> {
        const response = await axios.post('http://localhost:5555/bank/auth/logout');
        if(response.status==200)
        {
            localStorage.clear();
            window.location.href='/'
            console.log('You logged out')        
        }
    }



    return (
        <div>
            <Header targetUser={props.targetUser}/>
            <div className="container-fluid main-account-section">
                <div className="row d-flex justify-content-around" id="main">
                    <div className="col-3" id="activity">
                        <div className="recent-activity">
                            <h3 className="subheader">Recent Activity</h3>
                            <div id="generated-transaction-entity">
                                <p>To/From: { }</p>
                                <p>Amount: { }</p>
                                <p>Reason: { }</p>
                            </div>
                        </div>
                    </div>
                    <div className="col-4" id="accounts">
                        <h3 className="subheader">Account</h3>
                        <div className="accounts-container">
                            <div id="checking-accounts">
                                <h4>Your Checking Accounts</h4>
                                <div id="generated-account-entity">
                                    <p>placeholder information</p>
                                    {/* <Link to="/accounttransactions">more</Link> */}
                                    <button onClick={accountTrans}>more</button>
                                </div>
                                <div id="generated-account-entity">placeholder2</div>
                            </div>
                            <div id="saving-accounts">
                                <h4>Your Savings Accounts</h4>
                                <div id="generated-account-entity">placeholder1</div>
                                <div id="generated-account-entity">placeholder2</div>
                            </div>
                        </div>
                    </div>
                    <div className="col-3" id="user">
                        <div className="user-status d-flex justify-content-around" id="user-log-out-box">
                            <p>User: {props.targetUser.username}</p>
                            <button className="account-btn" onClick={logout}>Log Out</button>
                        </div>
                        <div className="user-profile-container">
                            <h5>Profile</h5>
                            <p>First Name: {props.targetUser.firstName}</p>
                            <p>Last Name: {props.targetUser.lastName}</p>
                            <p>Address: {props.targetUser.address}</p>
                            {/* separate component */}
                            {/* <Link to="/userprofile" className="account-btn">View Details</Link> */}
                            <button className="account-btn" onClick={profile}>View Details</button>
                        </div>
                        <div className="user-account-container">
                            <h5>Open New Account</h5>
                            <button className="account-btn" onClick={createAccountBtn}>Checking</button>
                            <button className="account-btn">Savings</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Account