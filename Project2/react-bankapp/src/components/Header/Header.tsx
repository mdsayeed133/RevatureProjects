import React from 'react'
import { Link } from 'react-router-dom'
import '../Header/Header.css'
const Header = () => {
    return (
        <div className="header-container container-fluid">
                <div className="darkmode-switch">
                    <p>light/dark</p>
                </div>
                <div className="row d-flex justify-content-around">
                    <div className="col-md-2">
                        <img src="rev-logo_281_29.png" alt="Revature logo" />
                    </div>
                    <div className="col-md-4">
                        <ul className="nav top-nav-list">
                            {/* links to "navigate" components */}
                            <Link to="/Home" className="nav-item">Home</Link>
                            <li className="nav-item"><a href="#About">About</a></li>
                            <Link to="/Account" className="nav-item">Account</Link>
                        </ul>
                    </div>
                    <div className="col-md-2 login-status">
                        <p className="login-name">Hello, GUEST</p>
                    </div>
                </div>
            </div>
    )
}

export default Header