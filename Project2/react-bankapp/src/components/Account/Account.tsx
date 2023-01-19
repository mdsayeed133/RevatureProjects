import React from 'react'

import '../Account/Account.css'
import Header from '../Header/Header'
import Requests from '../Requests/Requests'

const Account = () => {

    //this is using axios
    // create useState hooks to declare the states
    // const [username, setUsername] = useState("");
    // const [account, setAccount] = useState("");
    // const [balance, setBalance] = useState("");

    return (
        <div>
            <Header />
            <div className="container-fluid main-account-section">
                <div className="row d-flex justify-content-around" id="main">
                    <div className="col-3" id="activity">
                        <div className="recent-activity">
                            <h3 className="subheader">Recent Activity</h3>
                            <p>Recent transactions</p>
                        </div>
                        <div className="requests-container">
                            <h3>Requests</h3>
                            <p>Request Detail</p>
                            <select name="dropdown" id="dropdown">
                                <option value="">autopop</option>
                            </select>
                            <button className="account-btn btn btn-secondary" id="accept-btn">Accept</button>
                            <button className="account-btn btn btn-secondary" id="deny-btn">Deny</button>
                        </div>
                    </div>
                    <div className="col-4" id="accounts">
                        <h3 className="subheader">Account</h3>
                        <div className="accounts-container">
                            <div id="checking-accounts">
                                <h4>Your Checking Accounts</h4>
                            </div>
                            <div id="saving-accounts">
                                <h4>Your Savings Accounts</h4>
                            </div>
                        </div>
                    </div>
                    <div className="col-3" id="user">
                        <div className="user-status d-flex justify-content-around" id="user-log-out-box">
                            <p>User: XXXXXXXXX</p>
                            <button className="account-btn">Log Out</button>
                        </div>
                        <div className="user-profile-container">
                            <h5>Profile</h5>
                            <p>First Name: XXXXXXXX</p>
                            <p>Last Name: XXXXXXXX</p>
                            <p>Address: XXXXXXXXXXX</p>
                            {/* separate component */}
                            <button className="account-btn">View Details</button>
                        </div>
                        <div className="user-account-container">
                            <h5>Open New Account</h5>
                            <button className="account-btn">Checking</button>
                            <button className="account-btn">Savings</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    )
}

export default Account