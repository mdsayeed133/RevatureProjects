import axios from 'axios';
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

import '../Login/Login.css'
import {UserDTO} from '../../interfaces/users';

const Login: React.FC<any> = () => {

    //temporary default variable to hold logged in user
    // let user = {
    //     id: 0,
    //     username: "",
    //     password: ""
    // }

    // create useState hooks to declare the states
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    // useNavigate() will allow us to "navigate" components
    const navigate = useNavigate();

    const gatherInput = (input: any) => {

        //update based on the input
        if (input.target.name === "username") {
            setUsername(input.target.value)
        } else {
            setPassword(input.target.value)
        }
    }

    /* axios */
    const login = async () => {
        
        const response = await axios.post("localhost:5555/bank/auth/login", {username, password })
        // project2.citpuzbvuzos.us-east-1.rds.amazonaws.com
        //localhost5432
        // const response = await axios.post("localhost:5432")

        /* if login was successful... */
        if (response.status === 200) {
            console.log(response)
            
            //user.id = response.data.id;
            //user.username = response.data.username;
            //user.password = response.data.password;

            // if user logged successfully, id WON'T be 0
            if (user.userId > 0) {
                navigate("/home")
            }
        }
    }

    const reset = async ()=> {
        navigate("/reset")
    }

    return (
        <>
            <div className="Login">
                {/* <div className="image-container">
                <img src="rev-logo_281_29.png" alt="Revature Logo" />
            </div> */}
                <Link to="/home" className="image-container">
                    <img src="rev-logo_281_29.png" alt="Revature Logo" />
                </Link>
                <div className="hero-image-container">
                    <img src="pexels-andrea-piacquadio-3772512.jpg" alt="image of someone left behind" className="img-fluid hero-image" />
                </div>
                <div className="text-container">
                    <h1></h1>
                    <h3>Don't let Revature leave you behind</h3>
                    <div className="input-container">
                        <input type="text" name="username" placeholder="username" onChange={gatherInput} />
                    </div>
                    <div className="input-container">
                        <input type="password" name="password" placeholder="password" onChange={gatherInput} />
                    </div>

                    <button className="login-button" onClick={login}>Login</button>
                    <button className="login-button" onClick={reset}>Reset Password</button>
                </div>
                <div className="disclaimer">
                    <p><em>Results based solely on the amount of effort you put in. Sorry...</em></p>
                </div>
            </div>
        </>
    )
}

export default Login