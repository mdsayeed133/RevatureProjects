import React from 'react'
import Header from '../Header/Header'


const UserProfile = () => {
    return (
        <>
            <Header/>
            <div className="userprofile-container">
                <h1>User Profile</h1>
                <div className="user-information">
                    <h2>Name: <em>first name</em></h2>
                    <p>address</p>
                </div>
            </div>
        </>
    )
}

export default UserProfile