package org.xsakon;

import java.util.ArrayList;

public class TextUtil {

    public ArrayList<String> findWords(String text) {
        ArrayList<String> words = new ArrayList<>();
        String word = "";


        for (int i = 0; i < text.length(); i++) {

            char currentChar = text.charAt(i);
            if ((currentChar >= 65 && currentChar <= 90)
                    || (currentChar >= 96 && currentChar <= 120)){

                word = word.concat(Character.toString(currentChar));


                char nextChar = text.charAt(i + 1);
                if (((nextChar < 65 || nextChar > 90)
                        && (nextChar < 96 || nextChar > 120))) {

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
                    char secondCharacter = word.charAt(j);

                    if (currentChar == secondCharacter){
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

}
