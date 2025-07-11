package com.mycompany.dictionaryapp;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thanh
 */
public class DictionaryApp {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
         Manager manager = new Manager();

        while(true){
             System.out.println("------Menu-----");
            System.out.println("1. Add a new word");
            System.out.println("2.Look up a word");
            System.out.println("3. Exit");
            System.out.println("\n Choose function:");
            String choice = sc.nextLine();
            
            switch (choice) {
                case "1":
                    System.out.print("Enter new word: ");
                    String word = sc.nextLine();
                    System.out.print("Enter meaning: ");
                    String meaning = sc.nextLine();
                    boolean added = manager.addWord(word, meaning);
                    if (added) {
                        System.out.println("Word added successfully.");
                    } else {
                        System.out.println("Word already exists.");
                    }
                  
                    break;
                case "2":
                    System.out.print("Enter the word to look up: ");
                    String lookup = sc.nextLine();
                    String result = manager.lookup(lookup);
                    if (result != null) {
                        System.out.println("Meaning: " + result);
                    } else {
                        System.out.println("Word not found.");
                    }
                   
                    break;
                case "3":
                    manager.save();
                    System.out.println("Dictionary saved successfully.");
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Enter number from 1 to 3 :");
            }
        }
       
    }
}
