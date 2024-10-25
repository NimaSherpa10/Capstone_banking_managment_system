import React from "react";

const TransactionCard = () => {
  // Dummy transaction details
  const transaction = {
    transactionId: 123456,
    paymentAmount: 200.0,
    paymentStatus: "Completed",
    remainingBalance: 1000.5,
    timestamp: "2024-10-11 14:30:00",
  };

  return (
    <div className="stats bg-primary text-black p-4 rounded-lg shadow-lg">
      {/* Transaction ID */}
      <div className="stat">
        <div className="stat-title text-black">Transaction ID</div>
        <div className="stat-value">{transaction.transactionId}</div>
      </div>

      {/* Payment Amount */}
      <div className="stat">
        <div className="stat-title text-black">Payment Amount</div>
        <div className="stat-value">
          ${transaction.paymentAmount.toFixed(2)}
        </div>
      </div>

      {/* Payment Status */}
      <div className="stat">
        <div className="stat-title text-black">Payment Status</div>
        <div
          className={`stat-value ${
            transaction.paymentStatus === "Completed"
              ? "text-green-500"
              : "text-red-500"
          }`}
        >
          {transaction.paymentStatus}
        </div>
      </div>

      {/* Remaining Balance */}
      <div className="stat">
        <div className="stat-title text-black">Remaining Balance</div>
        <div className="stat-value">
          ${transaction.remainingBalance.toFixed(2)}
        </div>
      </div>

      {/* Transaction Timestamp */}
      <div className="stat">
        <div className="stat-title text-black">Timestamp</div>
        <div className="stat-value">{transaction.timestamp}</div>
      </div>
    </div>
  );
};

export default TransactionCard;
