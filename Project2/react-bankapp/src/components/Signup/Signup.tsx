import React from 'react'
import { Link } from 'react-router-dom'

import '../Signup/Signup.css'

const SignUp: React.FC<any> = () => {
    return (
        <>
            <div className="Login">
                <Link to="/home" className="image-container">
                    <img src="rev-logo_281_29.png" alt="Revature Logo" />
                </Link>
                <div className="hero-image-container">
                    <img src="gooddecision.jpg" alt="image of someone left behind" className="img-fluid hero-image" />
                </div>
                <div className="text-container">
                    <h1></h1>
                    <h3>Time to make the right decision</h3>
                    {/* firstname, lastname, username, password, address */}
                    <div className="input-container">
                        <input type="text" name="first_name" placeholder="first name" />
                        <input type="text" name="last_name" placeholder="last name" />
                        <input type="text" name="username" placeholder="username" />
                        <input type="password" name="password" placeholder="password" />
                    </div>
                    <div className="input-container">
                        <br />
                        <input type="text" name="address" placeholder="address" id="addressbox" />
                    </div>

                    <button className="login-button">Create</button>
                </div>
                <div className="disclaimer">
                    <p><em>Results based solely on the amount of effort you put in. Sorry...</em></p>
                </div>
            </div>
        </>
    )
}

export default SignUp