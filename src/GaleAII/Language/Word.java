/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleAII.Language;


import java.util.ArrayList;

/**
 *
 * @author Brian Miller
 */
public class Word {

    private String word;
    private ArrayList<String> tags;
    private ArrayList<String> partsOfSpeach;

    public Word(String word) {
        this.word = word;
        tags = new ArrayList<>();
        partsOfSpeach = new ArrayList<>();
    }
    
    public boolean mentions(String checkForTag){
        boolean mentions = false;
        for (String tag : tags) {
            if (tag.equals(checkForTag)) {
                mentions = true;
            }
        }
        return mentions;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void addTag(String Tag) {
        tags.add(Tag);
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public ArrayList<String> getPartsOfSpeech() {
        return partsOfSpeach;
    }

    public void setPartsOfSpeech(ArrayList<String> partsOfSpeech) {
        this.partsOfSpeach = partsOfSpeech;
    }

}
