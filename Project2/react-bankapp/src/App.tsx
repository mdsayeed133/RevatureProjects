import React, {useState, useEffect} from 'react';
import logo from './logo.svg';
import './App.css';
import Login from './components/Login/Login';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
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

function App() {
    // test darkmode here...
    const toggleDarkMode = () => setDarkMode(darkMode ? false : true);
    const storedDarkMode = localStorage.getItem("DARK_MODE");
    const [darkMode, setDarkMode] = React.useState(false);
    
    const [user, setUser] = React.useState<User>();
    const [targetAccount, setTargetAccount] = React.useState<Ac>();

    React.useEffect(() => {
        if (darkMode) {
            document.body.classList.add("dark");
        } 
        else {
            document.body.classList.remove("dark");
        }
    }, [darkMode]);


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
          <Route path="/login" element={<Login setUser={setUser}/>}/>
          <Route path="/home" element={<Home/>}/>
          <Route path="/account" element={<Account target={setTargetAccount}/>}/>
          <Route path="/signup" element={<SignUp/>}/>
          <Route path="/requests" element={<Requests/>}/>
          <Route path="/userprofile" element={<UserProfile/>}/>
          <Route path="/accounttransactions" element={<AccountTransactions AC={targetAccount}/>}/>
          {/* <Route path="/reset" element={<Reset/>}/> */}
        </Routes>
      </BrowserRouter>
      <Footer/>
    </div>
  );
}

export default App;
