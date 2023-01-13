import React from 'react'

import '../Signup/Signup.css'

const SignUp: React.FC<any>= () => {
    return (
        <>
        <div className="Login">
            <div className="image-container">
                <img src="rev-logo_281_29.png" alt="Revature Logo" />
            </div>
            <div className="hero-image-container">
                <img src="gooddecision.jpg" alt="image of someone left behind" className="img-fluid hero-image" />
            </div>
            <div className="text-container">
                <h1></h1>
                <h3>Time to make the right decision</h3>
                <div className="input-container">
                    <input type="text" name="username" placeholder="username" />
                </div>
                <div className="input-container">
                    <input type="password" name="password" placeholder="password" />
                    <br />
                    <input type="password" name="password" placeholder="re-type password"/>
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