import React from "react";
import LoanCard from "../components/LoanCard";
import TransactionCard from "../components/TransactionCard";

const Dashboard = () => {
  return (
    <div className="container mx-auto p-6">
      <h1 className="text-3xl font-semibold mb-6">Dashboard</h1>
      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        <LoanCard />
        <TransactionCard />
      </div>
    </div>
  );
};

export default Dashboard;
