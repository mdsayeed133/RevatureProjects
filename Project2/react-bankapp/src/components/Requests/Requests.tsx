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
            <div className="container">
                <div className="row d-flex justify-content-around">
                    <div className="col-6 money-service d-flex">
                        <h3>Request Money</h3>
                        <div id="requestMoney">
                            <FaHandHoldingUsd size="4em"/>
                            <FaArrowLeft size="4em"/>
                            <FaUser size="4em"/>
                        </div>
                        <Link to="/ReceiveMoney" className="btn btn-secondary">Request</Link>
                    </div>
                    <div className="col-6 money-service d-flex">
                        <h3>Send Money</h3>
                        <div id="sendMoney">
                            <FaHandHoldingUsd size="4em" />
                            <FaArrowRight size="4em" />
                            <FaUser size="4em" />
                        </div>
                        <Link to="/ReceiveMoney" className="btn btn-secondary">Request</Link>
                    </div>
                </div>

            </div>
        </>
    )
}

export default Requests