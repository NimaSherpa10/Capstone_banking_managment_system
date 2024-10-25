import React from "react";

const LoanCard = () => {
  // Dummy loan details
  const loan = {
    remainingBalance: 1200.5,
    totalPaidAmount: 5000.0,
    totalLoanAmount: 10000.0,
    paymentCounter: 12,
  };

  return (
    <div className="stats bg-primary text-black p-4 rounded-lg shadow-lg">
      {/* Loan Account Balance */}
      <div className="stat">
        <div className="stat-title text-black">Account Balance</div>
        <div className="stat-value">${loan.remainingBalance.toFixed(2)}</div>
        <div className="stat-actions">
          <button className="btn btn-sm btn-success">Add funds</button>
        </div>
      </div>

      {/* Loan Current Balance */}
      <div className="stat">
        <div className="stat-title text-black">Total Paid</div>
        <div className="stat-value">${loan.totalPaidAmount.toFixed(2)}</div>
        <div className="stat-actions">
          <button className="btn btn-sm">Add Payments</button>
          <button className="btn btn-sm mx-10">View Transactions</button>
        </div>
      </div>

      {/* Loan Details */}
      <div className="stat">
        <div className="stat-title text-black">Total Loan Amount</div>
        <div className="stat-value">${loan.totalLoanAmount.toFixed(2)}</div>
      </div>

      <div className="stat">
        <div className="stat-title text-black">Number of Payments Made</div>
        <div className="stat-value">{loan.paymentCounter}</div>
      </div>
    </div>
  );
};

export default LoanCard;
