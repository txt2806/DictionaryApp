package com.mycompany.dictionaryapp;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thanh
 */
public class Storage {
     private final String FILE_NAME = "dictionary.txt";


    
    public HashMap<String, String> loadDictionary() {
        HashMap<String, String> dictionary = new HashMap<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Dictionary file not found. Creating a new one.");
            return dictionary;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    dictionary.put(parts[0].toLowerCase(), parts[1]);
                }
            }
        } catch (IOException e) {        
            System.out.println("Error reading dictionary file.");
        }

        return dictionary;
    }


 
    public void saveDictionary(HashMap<String, String> dictionary) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                writer.write(entry.getKey() + ":  " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to dictionary file.");
        }
    }
    
  
    public void showDictionaryFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Dictionary file not found.");
            return;
    }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException e) {
        System.out.println("Error reading dictionary file.");
    }
    }
    
}