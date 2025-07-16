package com.mycompany.dictionaryapp;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList; 

public class AbstractStorage {

    
    public HashMap<String, String> loadDictionary() {
        return new HashMap<>();
    }

    public void saveDictionary(HashMap<String, String> dictionary) {
        
    }

    
    public String getExampleSentence(String word) {
        return "This function is not supported yet.";
    }

    
    public List<String> getSimilarWords(String word) {
        return new ArrayList<>();
    }
    
}

