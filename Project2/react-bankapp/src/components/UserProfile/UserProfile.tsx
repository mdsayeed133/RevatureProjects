import React, { useState } from 'react'
import Header from '../Header/Header'

import "../UserProfile/UserProfile.css"
import { User } from '../../interfaces/users'

const UserProfile: React.FC<any> = (props:any) => {
    const [tempFirst, setFirstName] = useState(props.targetUser.firstName);
    const [tempLast, setLastName] = useState(props.targetUser.lastName);
    const [tempAddress, setAddress] = useState(props.targetUser.address);

    return (
        <>
            <Header/>
            <div className="userprofile-container">
                <h1>User Profile</h1>
                <div className="user-information">
                    <h2>Username: <em>{props.targetUser.username}</em></h2>
                    <h2>First Name: <em>{props.targetUser.firstName}</em></h2>
                    <h2>Last Name: <em>{props.targetUser.lastName}</em></h2>
                    <p>Address: <em>{props.targetUser.address}</em></p>
                </div>
            </div>
        </>
    )
}

export default UserProfile;