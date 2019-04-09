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

public class Customer {

    public static void main(String[] args) {
        
                           Transactions first = new Transactions();
                           
                            Scanner fileScanner = null;

                           try {

                                         fileScanner = new Scanner(new File("accounts.dat"));

                           } catch (FileNotFoundException e) {

                                         // file not opened

                                         System.out.println("accounts.dat file not found!");

                                         System.exit(0);

                           }

                           // reading accounts list from file

                           ArrayList<Account> accountsList = first.readAccounts(fileScanner);

                           if (accountsList.size() > 0) {

                                         //atleast one account info is read

                                         //creating Scanner

                                         Scanner keyboard = new Scanner(System.in);

                                         //looping infinitely

                                         while (true) {

                                                       //reading account number

                                                       System.out.print("Enter your account number: ");

                                                       String accountNum = keyboard.nextLine();

                                                       if (accountNum.equals("")) {

                                                                    //end of loop

                                                                    break;

                                                       }

                                                       //finding index of account

                                                       int index = first.getAccountIndex(accountsList, accountNum);

                                                       if (index != -1) {

                                                                    //account exist

                                                                    Account account = accountsList.get(index);

                                                                    //displaying a greeting message

                                                                    System.out.println("Hello, " + account.getName() + "!");

                                                                    //showing balance

                                                                    first.showBalance(account);

                                                                    //doing transactions

                                                                    first.doTransactions(account, keyboard);

                                                                    //saving updated info

                                                                    first.writeAccounts(accountsList);

                                                                     System.out.println("Goodbye, " + account.getName() + "!");

                                                       }

                                         }

                                         System.out.println("ATM program concludes.");

                           }

              }

}