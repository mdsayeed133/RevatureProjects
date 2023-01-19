import React, {useState, useEffect} from 'react';
import logo from './logo.svg';
import './App.css';
import Login from './components/Login/Login';
import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom';
import Home from './components/Home/Home';
import Account from './components/Account/Account';
import SignUp from './components/Signup/Signup';
import Footer from './components/Footer/Footer';
import Requests from './components/Requests/Requests';
import UserProfile from './components/UserProfile/UserProfile';
import AccountTransactions from './components/AccountTranscation/AccountTransactions';
import Reset from './components/Reset/Reset';

import { User } from './interfaces/users';
import { Account as Ac} from './interfaces/accounts';
import axios from 'axios';
import SendMoney from './components/SendMoney/SendMoney';

function App() {
    // test darkmode here...
    const toggleDarkMode = () => setDarkMode(darkMode ? false : true);
    const storedDarkMode = localStorage.getItem("DARK_MODE");
    const [darkMode, setDarkMode] = React.useState(false);
    
    const [user, setUser] = React.useState<User>();
    const [targetAccount, setTargetAccount] = React.useState<Ac>();
    const [loggedIn, setLoggedStatus] = React.useState(false);

    React.useEffect(() => {
        if (darkMode) {
            document.body.classList.add("dark");
        } 
        else {
            document.body.classList.remove("dark");
        }
    }, [darkMode]);

    //state for guest
    // const [logname, setLogname] = useState("Guest")
    // const [username, setUsername] = useState("")
    // const [password, setPassword] = useState("")
    // /**axios
    //  * funciton to test login
    //  */
    // const login = async () => {
    //   const response = await axios.post("http://localhost:5555/bank/auth/login", {username, password})

    //   if (response.status === 200){
    //     console.log(response.data)
    //     setUsername(response.data.username)
    //   }
    // }

    // test
    // const login = async()=> {
    //   const response = await axios.post("http://localhost:5555/bank/auth/login", {username, password })

    //   if (response.status === 200) {
    //     console.log(response.data);
    //     setFirstName(response.data.firstName);
    //   }
    // }

  return (
    <div className="App">
      {/* testing darkmode */}
      {/* how to add persistance... */}
      <div className="darkmode-switch">
                <button onClick={() => setDarkMode(!darkMode)} className="btn btn-secondary dark-btn">DarkMode</button>
            </div>
      {/* will contain browserrouter */}
      <BrowserRouter>
        <Routes>
          {/* <Route path="" element={<Login/>}/> */}
          <Route path="" element={<Home/>}/>
          <Route path="/login" element={<Login setLoggedIn={setLoggedStatus} setTargetUser={setUser}/>}/>
          <Route path="/home" element={<Home loggedStatus={loggedIn} targetUser={user}/>}/>
          <Route path="/account" element={<Account targetUser={user} setTargetUser={setUser} target={setTargetAccount}/>}/>
          <Route path="/signup" element={<SignUp/>}/>
          <Route path="/requests" element={<Requests/>}/>
          <Route path="/userprofile" element={<UserProfile targetUser={user} setTargetUser={setUser}/>}/>
          <Route path="/accounttransactions" element={<AccountTransactions targetUser={user} AC={targetAccount}/>}/>
          {/*<Route path="/sendmoney" element={<SendMoney/>}/>*/}
          {/* <Route path="/reset" element={<Reset/>}/> */}
        </Routes>
      </BrowserRouter>
      <Footer/>
    </div>
  );
}

export default App;
