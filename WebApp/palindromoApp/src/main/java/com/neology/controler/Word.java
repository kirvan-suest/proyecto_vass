/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neology.controler;

/**
 *
 * @author suek087
 */
public class Word {
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
    
    public boolean isValid(String textWord){
       return textWord== null || textWord.isEmpty() || textWord.isBlank();
    }
    
    public boolean isPalindrome(String textWord){
        String wordInverted = new StringBuilder(textWord).reverse().toString();
        return textWord.equalsIgnoreCase(wordInverted);
    }
}
