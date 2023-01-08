import React from 'react'

import '../Account/Account.css'
import Header from '../Header/Header'

const Account = () => {
    return (
        <div>
            <Header/>
            <div className="container main-account-section">
                <div className="account-details">
                    <h2>Account Details:</h2>
                    <p>Name:</p>
                    <p>Account Number:</p>
                    <p><strong>Balance:</strong></p>
                </div>

                <div className="account-entry">
                    <p>Date: 1/6/2023</p>
                    <p>Description: Food</p>
                    <p>Amount: $67.35</p>
                    <hr />
                </div>
                <div className="account-entry">
                    <p>Date: 1/4/2023</p>
                    <p>Description: Entertainment</p>
                    <p>Amount: $93.78</p>
                    <hr />
                </div>
            </div>
        </div>
    )
}

export default Account