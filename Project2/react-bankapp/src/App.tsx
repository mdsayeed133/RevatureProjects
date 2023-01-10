import React from 'react';
import logo from './logo.svg';
import './App.css';
import Login from './components/Login/Login';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './components/Home/Home';
import Account from './components/Account/Account';

function App() {
  return (
    <div className="App">
      {/* will contain browserrouter */}
      <BrowserRouter>
        <Routes>
          <Route path="" element={<Login/>}/>
          <Route path="/home" element={<Home/>}/>
          <Route path="/account" element={<Account/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
