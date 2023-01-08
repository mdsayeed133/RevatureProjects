import React from 'react'
import '../Header/Header.css'
const Header = () => {
    return (
        <div className="header-container container">
                <div className="darkmode-switch">
                    <p>light/dark</p>
                </div>
                <div className="row d-flex justify-content-between">
                    <div className="col-md-2">
                        <img src="rev-logo_281_29.png" alt="Revature logo" />
                    </div>
                    <div className="col-md-4">
                        <ul className="nav top-nav-list">
                            <li className="nav-item"><a href="#link">Home</a></li>
                            <li className="nav-item"><a href="#About">About</a></li>
                            <li className="nav-item"><a href="#link">Account</a></li>
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