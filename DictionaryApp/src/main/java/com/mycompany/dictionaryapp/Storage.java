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
public class Storage extends AbstractStorage {
     private final String FILE_NAME = "dictionary.txt";


     @Override
    public HashMap<String, String> loadDictionary() {
        HashMap<String, String> map = new HashMap<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Dictionary file not found. Creating a new one.");
            return map;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    map.put(parts[0].toLowerCase(), parts[1]);
                }
            }
        } catch (IOException e) { //chat gpt          
            System.out.println("Error reading dictionary file.");
        }

        return map;
    }


     @Override
    public void saveDictionary(HashMap<String, String> dictionary) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                writer.write(entry.getKey() + ":  " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {// chatgpt
            System.out.println("Error writing to dictionary file.");
        }
    }
}
