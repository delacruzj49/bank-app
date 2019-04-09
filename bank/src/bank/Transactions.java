/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DeLaCruz
 */
public class Transactions
{
    public static void showBalance(Account acct) {

                           System.out.printf("Your current balance is $%.2f\n", acct.getBalance());

              }
    
     public static void doDeposit(Account acct, String s) {

                           try {

                                         double amount = Double.parseDouble(s);

                                         if (amount >= 0) {

                                                       acct.deposit(amount);

                                                       showBalance(acct);

                                         } else {

                                                       System.out.println("You cannot deposit a negative amount.");

                                         }

                           } catch (Exception e) {

                                         System.out.println(s + " is not an number");

                           }

              }
     
     
       public static void doWithdrawal(Account acct, String s) {

                           try {

                                         double amount = Double.parseDouble(s);

                                         if (amount >= 0) {

                                                       if (acct.getBalance() >= amount) {

                                                                    // valid, withdrawing amount

                                                                    acct.withdraw(amount);

                                                                    // displaying balance

                                                                    showBalance(acct);

                                                       } else {

                                                                    System.out

                                                                                                .println("You cannot withdraw more than you have.");

                                                       }

                                         } else {

                                                       System.out.println("You cannot withdraw a negative amount.");

                                         }

                           } catch (NumberFormatException e) {

                                         // non numeric input

                                         System.out.println(s + " is not a number");

                           }

              }
       
           public static ArrayList<Account> readAccounts(Scanner fileInput) {

                           // creating empty array list

                           ArrayList<Account> accountList = new ArrayList<Account>();

                           // looping until end of file

                            while (fileInput.hasNext()) {

                                         // fetching line

                                         String line = fileInput.nextLine().trim();

                                         // splitting line by :

                                         String fields[] = line.split(":");

                                         // ensuring resultant array has 3 elements

                                         if (fields.length == 3) {

                                                       // trying to parse values and create an account

                                                       try {

                                                                    int accNum = Integer.parseInt(fields[0]);

                                                                    String name = fields[1];

                                                                    double balance = Double.parseDouble(fields[2]);

                                                                    // creating an Account and adding to list

                                                                    Account account = new Account(accNum, name, balance);

                                                                    accountList.add(account);

                                                       } catch (NumberFormatException e) {

                                                                    System.out

                                                                                                .println("Bad input format found in accounts.dat!");

                                                                    // bad format, returning an empty array list

                                                                    return new ArrayList<Account>();

                                                       }

                                         }

                           }

                           return accountList;

              }
           
           
            /*

              *

              * Given an accountList (an ArrayList<Account>), this method will convert

              * each

              *

              * Account to a colon-separated line of text (hint: use toString()) and

              *

              * write it to file "accounts.dat". If the process encounters any type

              *

              * of Exception,the method writes an appropriate error message.

              */

              public static void writeAccounts(ArrayList<Account> accounttList) {

                           try {

                                         // openingg PrintWriter

                                         PrintWriter writer = new PrintWriter(new File("accounts.dat"));

                                         // writing all Account objects' toString() value to the file

                                         for (Account acc : accounttList) {

                                                       writer.println(acc.toString());

                                         }

                                         writer.close();

                           } catch (FileNotFoundException e) {

                                         // file error

                                         System.out.println(e.getMessage());

                           }

              }
              
                public static int findIndex(ArrayList<Account> accountList,

                                         int accountNumber) {

                           for (int i = 0; i < accountList.size(); i++) {

                                         if (accountList.get(i).getAcctNumber() == accountNumber) {

                                                       // found

                                                       return i;

                                         }

                           }

                           // not found

                           return -1;

              }

              public static int getAccountIndex(ArrayList<Account> accountList, String s) {

                           try {

                                         int accountNum = Integer.parseInt(s);

                                         // valid integer, finding index

                                         int index = findIndex(accountList, accountNum);

                                         if (index == -1) {

                                                       // unknown account

                                                       System.out.println("Unknown account number");

                                         }

                                         return index;

                           } catch (NumberFormatException e) {

                                         // non numeric input

                                         System.out.println(s + " is not a number");

                           }

                           return -1;

              }

              public static void doTransactions(Account acct, Scanner input) {

                           String choice = "";

                           // looping until user types F or f

                           while (!choice.equalsIgnoreCase("F")) {

                                         System.out.print("D) Deposit, W) Withdraw, or F) Finish? ");

                                         choice = input.nextLine();

                                         if (choice.equalsIgnoreCase("D")) {

                                                       System.out.print("Enter amount to deposit: $");

                                                       doDeposit(acct, input.nextLine());

                                         } else if (choice.equalsIgnoreCase("W")) {

                                                       System.out.print("Enter amount to withdraw: $");

                                                      doWithdrawal(acct, input.nextLine());

                                         } else if (!choice.equalsIgnoreCase("F")) {

                                                       System.out.println("Invalid choice");

                                         }

                           }

              }


    
}
  