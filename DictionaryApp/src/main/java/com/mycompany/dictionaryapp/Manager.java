package com.mycompany.dictionaryapp;


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
public class Manager implements IManager {
    private HashMap<String, String> dictionary;
    private Storage storage;
    
    
    public Manager(){
        storage= new Storage();
        dictionary = storage.loadDictionary();
        
    }
    
    @Override
    public String lookup(String word){
       if (dictionary.containsKey(word)) {
            return dictionary.get(word);
        }


        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            if (entry.getValue().toLowerCase().contains(word)) {
                return entry.getKey();
            }
        }
        return null;
    }
    
    
    
    @Override
    public boolean addWord(String word, String meaning){
        word = word.toLowerCase();
        if(dictionary.containsKey(word)) return false;
        dictionary.put(word, meaning);
        return true;
    }

    @Override
     public void save() {
        storage.saveDictionary(dictionary);
    }
     
    @Override
     public void showDictionaryFromFile() {
        storage.showDictionaryFromFile();
    }
     


}
