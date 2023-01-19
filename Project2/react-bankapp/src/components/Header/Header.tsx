import axios from 'axios'
import React, { useState } from 'react'
import { Link } from 'react-router-dom'
import '../Header/Header.css'
import Login from '../Login/Login'
const Header: React.FC<any> = (login:any) => {

    return (
        <div className="header-container container-fluid">
            <div className="row d-flex justify-content-around">
                <div className="col-md-2">
                    <img src="rev-logo_281_29.png" alt="Revature logo" />
                </div>
                <div className="col-md-4">
                    <ul className="nav top-nav-list">
                        {/* links to "navigate" components */}
                        <Link to="/Home" className="nav-item btn">Home</Link>
                        <Link to="/Account" className="nav-item btn">Account</Link>
                        {/* <Link to="/Requests" className="nav-item btn-secondary btn">Requests</Link> */}
                    </ul>
                </div>
                <div className="col-md-2 login-status">
                    {/* will change dynamically with useState,useEffect */}
                    {/* <p className="login-name" id="nameDisplay">Hello, {login.user.firstName}</p> */}
                </div>
            </div>
        </div>
    )
}

export default Header