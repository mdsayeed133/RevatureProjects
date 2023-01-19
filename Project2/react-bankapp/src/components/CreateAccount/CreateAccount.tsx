import React from 'react'

import '../CreateAccount/CreateAccount.css'
import Header from '../Header/Header'

const CreateAccount: React.FC<any> = () => {
    return (
        <>
            <Header/>
            <div className="create-account-container">
                <h1>Create Account HERE</h1>
            </div>
        </>
    )
}

export default CreateAccount