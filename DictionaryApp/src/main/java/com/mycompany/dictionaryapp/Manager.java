package com.mycompany.dictionaryapp;


import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thanh
 */
public class Manager {
    private HashMap<String, String> dictionary;
    private Storage storage;
    
    
    public Manager(){
        storage= new Storage();
        dictionary = storage.loadDictionary();
        
    }
    
    public String lookup(String word){
        return dictionary.get(word.toLowerCase());
        
    }
    
    public boolean addWord(String word, String meaning){
        word = word.toLowerCase();
        if(dictionary.containsKey(word)) return false;
        dictionary.put(word, meaning);
        return true;
    }

     public void save() {
        storage.saveDictionary(dictionary);
    }
}
