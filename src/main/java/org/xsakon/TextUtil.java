package org.xsakon;

import java.util.ArrayList;
import java.util.HashSet;

public class TextUtil {

    public ArrayList<String> findWords(String text) {
        ArrayList<String> words = new ArrayList<>();
        String word = "";


        for (int i = 0; i < text.length() - 1; i++) {

            char currentChar = text.charAt(i);
            if ((currentChar >= 65 && currentChar <= 90)
                    || (currentChar >= 96 && currentChar <= 122)){

                word = word.concat(Character.toString(currentChar));


                char nextChar = text.charAt(i + 1);
                if (((nextChar < 65 || nextChar > 90)
                        && (nextChar < 96 || nextChar > 122))) {

                    words.add(word);
                }
            }
            else{
                word = "";
            }
        }

        return words;
    }

    public ArrayList<Character> findUniqueCharForEachWord(ArrayList<String> words){
        ArrayList<Character> uniqueChars = new ArrayList<>();

        for (String word: words){
            char currentChar = word.charAt(0);

            for (int i = 0; i < word.length(); i++) {
                for (int j = i + 1; j < word.length(); j++) {

                    if (currentChar == word.charAt(j)){
                        i++;
                        currentChar = word.charAt(i);
                        break;
                    }
                }
            }
            uniqueChars.add(currentChar);
        }

        return uniqueChars;
    }

    public Character findFirstUniqueChar(String text){
        ArrayList<String> words = findWords(text);
        ArrayList<Character> uniqueChars = findUniqueCharForEachWord(words);

        Character currentChar = uniqueChars.get(0);
        boolean foundFirstUnique = false;
        HashSet<Character> seenChars = new HashSet<>();

        for (int i = 0; i < uniqueChars.size(); i++) {
            for (int j = i + 1; j < uniqueChars.size(); j++) {
                if (currentChar == uniqueChars.get(j) || seenChars.contains(currentChar)){

                    seenChars.add(currentChar);

                    currentChar = uniqueChars.get(i + 1);
                    foundFirstUnique = false;
                    break;
                }
                else {
                    foundFirstUnique = true;
                }
            }

            if (foundFirstUnique) {
                return currentChar;
            }
        }

        return currentChar;
    }

}
