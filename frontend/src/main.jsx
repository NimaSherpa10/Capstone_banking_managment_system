import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import App from "./App.jsx";
import Login from "./pages/Login";
import "./index.css";
import LoanCard from "./components/LoanCard.jsx";
import TransactionCard from "./components/TransactionCard.jsx";
import Navbar from "./Headers/Navbar.jsx";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <Navbar />
    <LoanCard />
    <TransactionCard />
  </StrictMode>
);
