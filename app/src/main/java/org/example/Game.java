package app.src.main.java.org.example;
import java.awt.*;
import javax.swing.*;

public class Game {
    public static int run(String word) {
        JFrame wordleWindow = new JFrame("WORDLE");
        wordleWindow.setSize(300, 400);
        wordleWindow.setResizable(true);
        wordleWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout wordleLayout = new GridLayout(6, 5);
        Row[] wordleGame = new Row[6];
        wordleWindow.setLayout(wordleLayout);
        for(int i = 0; i < 6; i++) {
            wordleGame[i] = new Row();
            for(int j = 0; j < 5; j++) {
                wordleWindow.add(wordleGame[i].at(j));
            }
        }
        wordleWindow.setBackground(Color.BLACK);
        wordleWindow.setVisible(true);
        
        // defining word
        Word answer = new Word(word);
        int guessTracker = -1;
        boolean hasWon = false;
        do {
            guessTracker++;
            for(int i = 0; i < 5; i++) {
                wordleGame[guessTracker].at(i).setBlankFocused();
            }
            for(int i = 0; i < 5; i++) {
                while(wordleGame[guessTracker].at(i).getLetter() == 0) {
                    wordleGame[guessTracker].at(i).requestFocusInWindow();
                }
            }
            char[] result = Guess.solve(wordleGame[guessTracker].toString(), answer);
            for(int i = 0; i < 5; i++) {
                switch(result[i]) {
                    case 'G':
                        wordleGame[guessTracker].at(i).setFullySolved();
                        break;
                    case 'Y':
                        wordleGame[guessTracker].at(i).setPartiallySolved();
                        break;
                    default:
                        wordleGame[guessTracker].at(i).setBlankUnfocused();
                }
            }
            System.out.println("Guess: " + wordleGame[guessTracker].toString());
            System.out.println("Compared to: " + word);
            System.out.println("Check value result: " + String.valueOf((Guess.solve(wordleGame[guessTracker].toString(), answer))));
            if(Guess.isSolved(wordleGame[guessTracker].toString(), answer)) {
                hasWon = true;
            }
        } while(guessTracker < 5 && hasWon == false);
        
        if(hasWon) {
            JOptionPane.showMessageDialog(wordleWindow, "You won! You got the correct answer,\n" + answer + ", in " + (guessTracker+1) + " tries.");
        } else {
            JOptionPane.showMessageDialog(wordleWindow, "You lost. You did not get the correct word, " + answer + ",\nin six tries.");
        }

        int returned = JOptionPane.showConfirmDialog(wordleWindow, "Play again?", "WORDLE", JOptionPane.YES_NO_OPTION);
        wordleWindow.setVisible(false);
        return returned;
    }
}
