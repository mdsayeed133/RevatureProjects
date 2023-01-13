import React from 'react'
import Header from '../Header/Header'

import '../Requests/Requests.css'
import {FaArrowLeft, FaArrowRight, FaHandHoldingUsd, FaUser} from "react-icons/fa"
const Requests = () => {
    // create a button feature
    // function moneyMoney(s: string){
    //     return "something clicked"
    // }
    return (
        <>
            <div className="money-service d-flex" id="requestMoney">
                <h3>Request Money</h3>
                <FaHandHoldingUsd size="4em"/>
                <FaArrowLeft size="4em"/>
                <FaUser size="4em"/>
                <button>Request</button>
            </div>
            <div className="money-service d-flex" id="sendMoney">
                <h3>Send Money</h3>
                <FaHandHoldingUsd size="4em"/>
                <FaArrowRight size="4em"/>
                <FaUser size="4em"/>
                <button>Send</button>
            </div>
        </>
    )
}

export default Requests