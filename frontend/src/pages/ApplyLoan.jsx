// src/pages/ApplyLoan.jsx

import React, { useState } from "react";
import Title from "../Headers/Tittle";
import apiService from "../services/apiService";

function ApplyLoan() {
  const [amount, setAmount] = useState(0);
  const [duration, setDuration] = useState(0);
  const [message, setMessage] = useState("");

  const handleApply = async (e) => {
    e.preventDefault();
    const loanData = { amount, duration }; // Prepare loan data

    try {
      const response = await apiService.applyLoan(loanData); // Call the apply loan API
      if (response.success) {
        setMessage("Loan application successful!");
      } else {
        setMessage(response.message || "Loan application failed.");
      }
    } catch (error) {
      console.error("Error applying for loan:", error);
      setMessage("An error occurred while applying for the loan.");
    }
  };

  return (
    <>
      <Title />
      <div className="hero bg-base-200 min-h-screen">
        <div className="hero-content flex-col lg:flex-row">
          <div className="text-center lg:text-left">
            <h1 className="text-5xl font-bold">Apply for a Loan</h1>
            <p className="py-6">{message}</p>
          </div>
          <div className="card bg-base-100 w-full max-w-sm shrink-0 shadow-2xl">
            <form className="card-body" onSubmit={handleApply}>
              <div className="form-control">
                <label className="label">
                  <span className="label-text">Loan Amount</span>
                </label>
                <input
                  type="number"
                  placeholder="Enter loan amount"
                  className="input input-bordered"
                  required
                  value={amount}
                  onChange={(e) => setAmount(e.target.value)} // Update state
                />
              </div>
              <div className="form-control">
                <label className="label">
                  <span className="label-text">Duration (in months)</span>
                </label>
                <input
                  type="number"
                  placeholder="Enter duration"
                  className="input input-bordered"
                  required
                  value={duration}
                  onChange={(e) => setDuration(e.target.value)} // Update state
                />
              </div>
              <div className="form-control mt-6">
                <button className="btn btn-primary">Apply</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </>
  );
}

export default ApplyLoan;
