import React, {useState} from 'react'
import { Link, useNavigate } from 'react-router-dom'

import '../Signup/Signup.css'

import axios from 'axios'

const SignUp: React.FC<any> = (props:any) => {
    const [username, setUsername] = useState("");
    const [firstName, setFirst] = useState("");
    const [lastName, setLast] = useState("");
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const [address, setAddress] = useState("");
    //create useState hooks
    const navigate = useNavigate();
    const gatherInput = (input:any) =>
    {
        switch(input.target.name)
        {
            case "firstName":
                setFirst(input.target.value);
                console.log(firstName);
                break;
            case "lastName":
                setLast(input.target.value);
                console.log(lastName);
                break;
            case "email":
                setEmail(input.target.value);
                console.log(email);
                break;
            case "username":
                setUsername(input.target.value);
                console.log(username);
                break;
            case "password":
                setPassword(input.target.value);
                console.log(password);
                break;
            case "address":
                setAddress(input.target.value);
                console.log(address);
                break;
            default: break;
        }
    }

    const attemptSubmit = async (input:any) =>
    {
        console.log("You have pushed the button!");
        if(firstName==""||lastName==""||address==""||password==""||email==""||username=="")
        {
            alert("You have not filled in all of the information.");
            return;
        }
        else
        {
            const response = await axios.post("http://localhost:5555/bank/users/register", {username, password, firstName, lastName, address, email})
            if(response.status==200)
            {
                const response2 = await axios.post("http://localhost:5555/bank/auth/login", {username, password })
                if(response2.status==200)
                {
                    props.setTargetUser(response2.data);
                    props.setLoggedIn(true);
                    navigate("/home")
                }
            }
        }
    }
    
    return (
        <>
            <div className="Login">
                <Link to="/home" className="image-container">
                    <img src="rev-logo_281_29.png" alt="Revature Logo" />
                </Link>
                <div className="hero-image-container">
                    <img src="gooddecision.jpg" alt="image of someone NOT left behind" className="img-fluid hero-image" />
                </div>
                <div className="text-container">
                    <h1></h1>
                    <h3>Time to make the right decision</h3>
                    {/* firstname, lastname, username, password, address */}
                    <div className="input-container">
                        <input type="text" name="firstName" placeholder="first name" onChange={gatherInput}/>
                        <input type="text" name="lastName" placeholder="last name" onChange={gatherInput}/>
                        <input type="text" name="username" placeholder="username" onChange={gatherInput}/>
                        <input type="password" name="password" placeholder="password" onChange={gatherInput}/>
                        <input type="text" name="email" placeholder="email" onChange={gatherInput} id="emailInput"/>
                        <br />
                        <input type="text" name="address" placeholder="address" onChange={gatherInput} id="addressInput" />
                    </div>
                    {/* <div className="input-container">
                        <br />
                        <input type="text" name="address" placeholder="address" id="addressbox" />
                    </div> */}

                    <button className="login-button" onClick={attemptSubmit}>Create</button>
                </div>
                <div className="disclaimer">
                    <p><em>Results based solely on the amount of effort you put in. Sorry...</em></p>
                </div>
            </div>
        </>
    )
}

export default SignUp