import React from 'react'
import Header from '../Header/Header'

import '../Requests/Requests.css'
import { FaArrowLeft, FaArrowRight, FaHandHoldingUsd, FaUser } from "react-icons/fa"
import { Link } from 'react-router-dom'
const Requests = () => {
    // create a button feature
    const buttonStuff = async ()=> {
        console.log("button stuff")
    }
    const otherStuff = async ()=> {
        console.log("OTHER button stuff clicked")
    }
    return (
        <>
        <Header />
            <div className="container request-container">
                <div className="row">
                    <div className="col-6">
                        <div className="money-service d-flex">
                        <h3>Request Money</h3>
                        <div id="requestMoney">
                            <FaHandHoldingUsd size="4em"/>
                            <FaArrowLeft size="4em"/>
                            <FaUser size="4em"/>
                        </div>
                        </div>
                        <p>Please choose account</p>
                        <input type="text" name="amount" placeholder='amount'/>
                        <input type="text" name="amount" placeholder='user account'/>
                        <button>Submit</button>
                    </div>
                    <div className="col-6">
                        <div className="money-service d-flex">
                        <h3>Send Money</h3>
                        <div id="sendMoney">
                            <FaHandHoldingUsd size="4em" />
                            <FaArrowRight size="4em" />
                            <FaUser size="4em" />
                        </div>
                        </div>
                        <p>Please choose account</p>
                        <input type="text" name="amount" placeholder="amount" />
                        <input type="text" name="amount" placeholder="user account" />
                        <button>Submit</button>
                    </div>
                </div>

            </div>
        </>
    )
}

export default Requests