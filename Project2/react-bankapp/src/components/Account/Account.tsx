import React from 'react'

import '../Account/Account.css'
import Header from '../Header/Header'
import Requests from '../Requests/Requests'

const Account = () => {

    //this is using axios

    return (
        <div>
            <Header/>
            <div className="container main-account-section">
                <div className="account-details">
                    <h2>Account Details:</h2>
                    <p>Name: Guest</p>
                    <p>Account Number: 123456789 </p>
                    <p>Account Type: Checking/Savings</p>
                    <p><strong>Balance: 500.00</strong></p>
                </div>
                {/* auto create cards here */}
                <div className="account-entry d-flex justify-content-around">
                    <p>Date: 1/6/2023</p>
                    <p>Description: Food</p>
                    <p>Amount: $67.35</p>
                    <p><em>Pending balance: 500 - 67.35 </em></p>
                    <hr />
                </div>
                <div className="account-entry d-flex justify-content-around">
                    <p>Date: 1/4/2023</p>
                    <p>Description: Entertainment</p>
                    <p>Amount: $93.78</p>
                    <p><em>Pending balance: 693.78 - 93.78</em></p>
                    <hr />
                </div>
            </div>
        </div>
    )
}

export default Account