package com.company;

public class Account {

        private String accountNumber;
        private double balance;
        private String customerNumber;
        private String emailAddress;
        private String customerPhonenumber;




    public void deposit(double depositAmount){
        this.balance+=depositAmount;
        System.out.println("New balance is " + this.balance);
    }
    public void withdrawal(double withdrawalamount){
        if (this.balance -withdrawalamount<=0){
            System.out.println("withdrawal is not possible due to low account balance");

        }else{
           this. balance-=withdrawalamount;
            System.out.println("Remaining balance is " + this.balance);

        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return balance;
    }

    public void setAccountBalance(double accountBalance) {
        this.balance = accountBalance;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCustomerPhonenumber() {
        return customerPhonenumber;
    }

    public void setCustomerPhonenumber(String customerPhonenumber) {
        this.customerPhonenumber = customerPhonenumber;
    }
}
