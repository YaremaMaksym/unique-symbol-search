package org.xsakon;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String text1 = "The Tao gave birth to machine language.  Machine language gave birth\n" +
                "to the assembler.\n" +
                "The assembler gave birth to the compiler.  Now there are ten thousand\n" +
                "languages.\n" +
                "Each language has its purpose, however humble.  Each language\n" +
                "expresses the Yin and Yang of software.  Each language has its place within\n" +
                "the Tao.\n" +
                "But do not program in COBOL if you can avoid it.\n" +
                "        -- Geoffrey James, \"The Tao of Programming\"";
        String text2 = "C makes it easy for you to shoot yourself in the foot. C++ makes that harder, but when you do, it blows away your whole leg. (с) Bjarne Stroustrup";

        TextUtil textUtil = new TextUtil();
        ArrayList<String> words = textUtil.findWords(text2);
        ArrayList<Character> uniqueChars = textUtil.findUniqueCharForEachWord(words);
        Character uniqueChar = textUtil.findFirstUniqueChar(text2);

        System.out.println(words);
        System.out.println(uniqueChars);
        System.out.println(uniqueChar);
    }
}