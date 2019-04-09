/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author DeLaCruz
 */
public class DataFile {
    
    public static void FileRead(){
                      
                            Scanner fileScanner = null;

                           try {

                                         fileScanner = new Scanner(new File("accounts.dat"));

                           } catch (FileNotFoundException e) {

                                         // file not opened

                                         System.out.println("accounts.dat file not found!");

                                         System.exit(0);

                           }
                           
    }
}
