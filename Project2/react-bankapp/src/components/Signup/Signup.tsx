import React from 'react'

const SignUp: React.FC<any>= () => {
    return (
        <div className="SignUp">
            <div className="image-container">
                <img src="rev-logo_281_29.png" alt="Revature Logo"/>
            </div>
            <div className="signup-box-container container">
                <h2>Sign up for your account here</h2>
                <table>
                    <thead>Name:</thead>
                    <tr>First Name:</tr>
                    <tr>Last Name:</tr>
                    <tr>Account:</tr>
                </table>
            </div>
        </div>
    )
}

export default SignUp