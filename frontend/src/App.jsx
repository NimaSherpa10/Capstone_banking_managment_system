import React from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
} from "react-router-dom";

import Dashboard from "./pages/Dashboard";
import ApplyLoan from "./pages/ApplyLoan";
import Settings from "./pages/Settings";
import Navbar from "./Headers/Navbar";
import LoanManagement from "./pages/LonManagement";
import Transactions from "./pages/Transaction";
import Login from "./pages/Login";

function App() {
  const isAuthenticated = localStorage.getItem("token") !== null; // Check if token exists

  return (
    <Router>
      <div className="min-h-screen bg-gray-100">
        <Navbar />
        <Routes>
          <Route
            path="/"
            element={isAuthenticated ? <Dashboard /> : <Navigate to="/login" />}
          />
          <Route
            path="/apply-loan"
            element={isAuthenticated ? <ApplyLoan /> : <Navigate to="/login" />}
          />
          <Route
            path="/loans"
            element={
              isAuthenticated ? <LoanManagement /> : <Navigate to="/login" />
            }
          />
          <Route
            path="/transactions"
            element={
              isAuthenticated ? <Transactions /> : <Navigate to="/login" />
            }
          />
          <Route
            path="/settings"
            element={isAuthenticated ? <Settings /> : <Navigate to="/login" />}
          />
          <Route path="/login" element={<Login />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
