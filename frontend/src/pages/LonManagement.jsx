import React from "react";
import LoanCard from "../components/LoanCard";

const LoanManagement = () => {
  return (
    <div className="container mx-auto p-6">
      <h1 className="text-3xl font-semibold mb-6">Loan Management</h1>
      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        <LoanCard />
      </div>
      <div className="mt-6">
        <h2 className="text-2xl font-semibold mb-4">Your Loans</h2>
        <div className="bg-white p-4 rounded shadow-lg">
          {/* Replace with dynamic loan data */}
          <p>Loan ID: 12345</p>
          <p>Loan Amount: $10,000</p>
          <p>Loan Status: Approved</p>
          <p>Remaining Balance: $5,000</p>
        </div>
      </div>
    </div>
  );
};

export default LoanManagement;
