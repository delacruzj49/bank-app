/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author m_f_s
 */
public class Account {

              // attributes

              private int acctNumber;

              private String name;

              private double balance;

              // constructor to initialize all fields

              public Account(int acctNumber, String name, double balance) {

                           this.acctNumber = acctNumber;

                           this.name = name;

                           this.balance = balance;

              }

              @Override

              public String toString() {

                           return acctNumber + ":" + name + ":" + balance;

              }

              // method to deposit money

              public void deposit(double amount) {

                           if (amount >= 0) {

                                         // valid amount

                                         balance += amount;

                           }

              }
             

              // method to withdraw money

              public void withdraw(double amount) {

                           if (amount >= 0 && amount <= balance) {

                                         //valid amount, enough balance

                                         balance -= amount;

                           }

              }

              public double getBalance() {

                           return balance;

              }

              public void setBalance(double balance) {

                           this.balance = balance;

              }

              public String getName() {

                           return name;

              }

              public int getAcctNumber() {

                           return acctNumber;

              }

}