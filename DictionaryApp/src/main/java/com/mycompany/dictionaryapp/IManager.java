/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dictionaryapp;
/**
 *
 * @author thanh
 */
public interface IManager {
    String lookup(String word);
    boolean addWord(String word, String meaning);
    void save();
    void showDictionaryFromFile();
}
