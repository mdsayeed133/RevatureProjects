import React, {useState, useEffect} from 'react';
import logo from './logo.svg';
import './App.css';
import Login from './components/Login/Login';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './components/Home/Home';
import Account from './components/Account/Account';
import SignUp from './components/Signup/Signup';
import Footer from './components/Footer/Footer';



function App() {
    // test darkmode here...
    const toggleDarkMode = () => setDarkMode(darkMode ? false : true);
    const storedDarkMode = localStorage.getItem("DARK_MODE");
    const [darkMode, setDarkMode] = React.useState(false);


    React.useEffect(() => {
        if (darkMode) {
            document.body.classList.add("dark");
        } 
        else {
            document.body.classList.remove("dark");
        }
    }, [darkMode]);



  return (
    <div className="App">
      {/* testing darkmode */}
      {/* how to add persistance... */}
      <div className="darkmode-switch">
                <button onClick={() => setDarkMode(!darkMode)} className="btn btn-secondary">DarkMode</button>
            </div>
      {/* will contain browserrouter */}
      <BrowserRouter>
        <Routes>
          {/* <Route path="" element={<Login/>}/> */}
          <Route path="" element={<Home/>}/>
          <Route path="/login" element={<Login/>}/>
          <Route path="/home" element={<Home/>}/>
          <Route path="/account" element={<Account/>}/>
          <Route path="/signup" element={<SignUp/>}/>
        </Routes>
      </BrowserRouter>
      <Footer/>
    </div>
  );
}

export default App;
