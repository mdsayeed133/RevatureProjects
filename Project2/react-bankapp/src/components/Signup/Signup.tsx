import React, {useState} from 'react'
import { Link } from 'react-router-dom'

import '../Signup/Signup.css'

const SignUp: React.FC<any> = (props:any) => {
    const [tempUsername, setUsername] = useState("");
    const [tempFirst, setFirst] = useState("");
    const [tempLast, setLast] = useState("");
    const [tempPassword, setPassword] = useState("");
    const [tempEmail, setEmail] = useState("");
    const [tempAddress, setAddress] = useState("");
    //create useState hooks
    
    const gatherInput = (input:any) =>
    {
        switch(input.target.name)
        {
            case "firstName":
                setFirst(input.target.value);
                console.log(tempFirst);
                break;
            case "lastName":
                setLast(input.target.value);
                console.log(tempLast);
                break;
            case "email":
                setEmail(input.target.value);
                console.log(tempEmail);
                break;
            case "username":
                setUsername(input.target.value);
                console.log(tempUsername);
                break;
            case "password":
                setPassword(input.target.value);
                console.log(tempPassword);
                break;
            case "address":
                setAddress(input.target.value);
                console.log(tempAddress);
                break;
            default: break;
        }
    }

    const attemptSubmit = (input:any) =>
    {
        console.log("You have pushed the button!");
        if(tempFirst==""||tempLast==""||tempAddress==""||tempPassword==""||tempEmail==""||tempUsername=="")
        {
            alert("You have not filled in all of the information.");
            return;
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