import React, { useState, useEffect } from 'react'
import { Link, useNavigate } from 'react-router-dom'

import '../Account/Account.css'
import Header from '../Header/Header'
import Requests from '../Requests/Requests'
import axios from 'axios';

import { Transaction } from '../../interfaces/transactions';
import{User} from '../../interfaces/users'
import { Account as Ac } from '../../interfaces/accounts';
import { setEnvironmentData } from 'worker_threads';
import CreateAccount from '../CreateAccount/CreateAccount'

const Account = (props:any) => {
    const navigate = useNavigate();
    
    //
    const accountTrans = async () => {
        //console.log(this.name + this.value);
        navigate("/accounttransactions");
    }

    const profile = async ()=>{
        navigate("/userprofile")
    }

    // const createAccountBtn = async ()=>{
    //     navigate("/createaccount")
    // }

    //this is using axios
    // create useState hooks to declare the states
    // const [username, setUsername] = useState("");
    // const [account, setAccount] = useState("");
    // const [balance, setBalance] = useState("");


    const [checkingAccounts, setCheckingAccounts] = useState<Ac[]>([]);
    const [savingsAccounts, setSavingsAccounts] = useState<Ac[]>([]);
    

    const fillCheckAccounts = async () => 
    {
        const response = await axios.get(`http://localhost:5555/bank/accounts/user/${props.targetUser.userId}/type/1`);
        setCheckingAccounts(response.data);
        if (response.status === 200) {
            console.log(response.data);
            setCheckingAccounts(response.data);
        }
    }

    const fillSavingsAccounts = async () => 
    {
        const response = await axios.get(`http://localhost:5555/bank/accounts/user/${props.targetUser.userId}/type/2`);
        setSavingsAccounts(response.data);
        if (response.status === 200) {
            console.log(response.data);
            setSavingsAccounts(response.data);
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


    React.useEffect(()=>{
        fillCheckAccounts();
        fillSavingsAccounts();
    },[])


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
                                <p>Future Implementation</p>
                            </div>
                        </div>
                    </div>
                    <div className="col-4" id="accounts">
                        <h3 className="subheader">Account</h3>
                        <div className="accounts-container">
                            <div id="checking-accounts">
                                <h4>Your Checking Accounts</h4>
                                {
                                    checkingAccounts.map((Ac, index) =>
                                    (
                                        <div id="generated-account-entity" key={index}>
                                            <p>Account ID: {Ac.accountId}</p>
                                            <p>Account Balance: {Ac.amount}</p>
                                            <button onClick={()=>
                                                 props.setTargetAc(Ac);
                                                 accountTrans();
                                            } name="checking" value={index}>More</button>
                                        </div>
                                    ))
                                }
                            </div>
                            <div id="saving-accounts">
                                <h4>Your Savings Accounts</h4>
                                {
                                    savingsAccounts.map((Ac, index) =>
                                    (
                                        <div id="generated-account-entity" key={index}>
                                            <p>Account ID: {Ac.accountId}</p>
                                            <p>Account Balance: {Ac.amount}</p>
                                            <button onClick={()=>{
                                                //console.log(Ac);
                                                props.setTargetAc(Ac);
                                                //console.log("This is our target:"+props.targetAc)
                                                accountTrans();
                                            }
                                                } name="savings" value={index}>More</button>
                                        </div>
                                    ))
                                }
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
                          <CreateAccount userId={props.targetUser.userId}/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Account