/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleAII.Language;


import com.aliasi.dict.DictionaryEntry;
import com.aliasi.dict.MapDictionary;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Brian Miller
 */
public class ExactDictionary {

    static final double CHUNK_SCORE = 1.0;
    String dictionaryType;
    private MapDictionary<String> dictionary;

    /**
     * This will create an exact dictionary to be used by the language processor
     *
     * @param dictionaryType the type of dictionary. the words in the string
     * will be tagged with this word in all capitals
     * @param fileName the name of the text file in the Resource Folder
     */
    public ExactDictionary(String dictionaryType, String fileName) throws Exception{
        dictionary = new MapDictionary<>();
        this.dictionaryType = dictionaryType;
        createDictionary(fileName, dictionary, dictionaryType);
    }
    
    /**
     * Adds to a created dictionary with the text from the file provided.
     *
     * @param nameOfFile name of file in the /Gale/Resources directory you want
     * parsed into the dictionary.
     * @param dictionary the current dictionary you are creating
     * @param TypeOfDictionary the entity name of the items in the new
     * dictionary such as immunization. this is converted to all uppercase for
     * later reference by the CHUNCKER.
     * @throws Exception on file IO.
     */
    private void createDictionary(String nameOfFile, MapDictionary<String> dictionary, String TypeOfDictionary) throws Exception {
        try {
            ArrayList<String> dictionaryEntriesArrayList = readFile(nameOfFile);
            for (String dictionaryEntryString : dictionaryEntriesArrayList) {
//                if (dictionaryEntryString != null) {
//                    
//                }
                //System.err.println(dictionaryEntryString);
                DictionaryEntry<String> dictionaryEntry;
                dictionaryEntry = new DictionaryEntry<>(dictionaryEntryString, TypeOfDictionary.toUpperCase(), CHUNK_SCORE);
                dictionary.addEntry(dictionaryEntry);
            }
            //System.err.println(dictionary.toString());
            System.out.println("There are " + dictionary.size() + " Entries in the " + TypeOfDictionary + " Dictionary.");
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * Returns an array list of each line of text in the given file. The idea is
     * it will only return one word per like that is a specific type of word
     * such as Immunization or Illness
     *
     * @param textFileName the name of the text file stored in gale/resources/
     * @return an array list of strings each with one line of the file
     * @throws Exception on File IO
     */
    private ArrayList<String> readFile(String textFileName) throws Exception {
        try {
            File fileToRead = new File("Resources/" + textFileName);
//            String[] paths = fileToRead.list();
//            for(String path:paths)
//         {
//            // prints filename and directory name
//            System.out.println(path);
//         }
            Scanner scanner = new Scanner(fileToRead);
            ArrayList<String> lines = new ArrayList<>();
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
            return lines;
        } catch (Exception e) {
            throw e;
        }
    }

    public MapDictionary<String> getDictionary() {
        return dictionary;
    }

    
}
