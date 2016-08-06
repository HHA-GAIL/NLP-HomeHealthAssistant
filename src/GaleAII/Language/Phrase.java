/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleAII.Language;


/**
 *
 * @author Brian
 */
public class Phrase {
    private String wordsInPhrase;
    private String tag;

    public Phrase(String words, String tag) {
        this.tag = tag;
        this.wordsInPhrase = words;
    }

    public String getWordsInPhrase() {
        return wordsInPhrase;
    }

    public String getTag() {
        return tag;
    }
    
    
}
