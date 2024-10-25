// src/services/apiService.js

import axios from "axios";

const API_URL = "http://localhost:8080/api"; // Change this to your backend URL if needed

// User Service
export const userService = {
  register: (userData) => {
    return axios.post(`${API_URL}/register`, userData);
  },
  login: (userData) => {
    return axios.post(`${API_URL}/login`, userData);
  },
  getUserById: (userId) => {
    return axios.get(`${API_URL}/users/${userId}`); // Adjust path as necessary
  },
  updateUserProfile: (userId, userDetails) => {
    return axios.put(`${API_URL}/users/${userId}`, userDetails);
  },
  deleteUser: (userId) => {
    return axios.delete(`${API_URL}/users/${userId}`);
  },
  getAllUsers: () => {
    return axios.get(`${API_URL}/users`);
  },
};

// Loan Service
export const loanService = {
  applyForLoan: (userId, loanData) => {
    return axios.post(`${API_URL}/loans/apply/${userId}`, loanData);
  },
  getLoanById: (loanId) => {
    return axios.get(`${API_URL}/loans/${loanId}`);
  },
  getAllLoansByUserId: (userId) => {
    return axios.get(`${API_URL}/loans/user/${userId}`);
  },
  getLoanStatus: (loanId) => {
    return axios.get(`${API_URL}/loans/${loanId}/status`);
  },
  updateLoanStatus: (loanId, status) => {
    return axios.put(`${API_URL}/loans/${loanId}/status?status=${status}`);
  },
  calculateMonthlyPayment: (loanId) => {
    return axios.get(`${API_URL}/loans/${loanId}/monthly-payment`);
  },
  getAllPendingLoans: () => {
    return axios.get(`${API_URL}/loans/pending`);
  },
  getAllLoans: () => {
    return axios.get(`${API_URL}/loans/view`);
  },
};

// Transaction Service
export const transactionService = {
  makeLoanPayment: (loanId, paymentAmount) => {
    return axios.post(`${API_URL}/payments`, {
      loanId,
      paymentAmount,
    });
  },
  getAllTransactionsByLoanId: (loanId) => {
    return axios.get(`${API_URL}/loans/${loanId}/transactions`);
  },
  calculateRemainingBalance: (loanId) => {
    return axios.get(`${API_URL}/loans/${loanId}/remaining-balance`);
  },
};
