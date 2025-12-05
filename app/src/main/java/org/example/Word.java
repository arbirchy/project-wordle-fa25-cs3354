package app.src.main.java.org.example;
//import java.util.*;
//import java.lang.*;

public class Word {
    private char[] contents;

    public Word(String newWord) throws IllegalArgumentException {
        if(newWord.length() != 5) throw new IllegalArgumentException("A word in your input does not have five letters");
        contents = new char[5];
        for(int i = 0; i < 5; i++) {
            contents[i] = newWord.charAt(i);
        }
    }

    public String toString() {
        return String.valueOf(contents);
    }

    public char[] getWordAsCharArray() {
        return contents;
    }

    public char charAt(int index) {
        return contents[index];
    }
}
