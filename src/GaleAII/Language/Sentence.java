/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleAII.Language;

import GaleAII.Core.Listen;
import java.util.ArrayList;

/**
 *
 * @author Brian Miller
 */
public class Sentence {

    ArrayList<Word> words = new ArrayList<>();
    String fullSentence;
    ArrayList<Phrase> phrases = new ArrayList<>();

    public Sentence(String sentanceString) {        
        this.fullSentence = sentanceString;
        breakStringIntoWords(sentanceString);        
    }

    private void breakStringIntoWords(String sentanceString) {
        String[] wordsInString = sentanceString.split("\\W+");
        for (String word : wordsInString) {
            words.add(new Word(word));
        }
    }  
    
    public ArrayList<String> mentions(String tag) {
        tag = tag.toUpperCase();
        ArrayList<String> mentionsOfTag = new ArrayList<>();
        for (Phrase phrase : phrases) {
            if (phrase.getTag().equals(tag)) {
                mentionsOfTag.add(phrase.getWordsInPhrase());
            }
        }

        for (Word word : words) {
            if (word.mentions(tag)) {
                mentionsOfTag.add(word.getWord());
            }
        }
        return mentionsOfTag;
    }

    public String getFullSentence() {
        return fullSentence;
    }

    public void addPhrase(Phrase newPhrase) {
        phrases.add(newPhrase);
    }

    public ArrayList<Word> getWords() {
        return words;
    }

}
