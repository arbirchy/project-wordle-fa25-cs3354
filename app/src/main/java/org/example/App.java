package app.src.main.java.org.example;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        JFrame fcWrapper = new JFrame();
        JFileChooser fc = new JFileChooser();
        fcWrapper.setVisible(true);
        int fileResult = fc.showOpenDialog(fcWrapper);
        fcWrapper.setVisible(false);
        File filePath = fc.getSelectedFile();
        Scanner scanner = null;

        if(fileResult == JFileChooser.CANCEL_OPTION || fileResult == JFileChooser.ERROR_OPTION) {
            System.out.println("File import failed.");
            return;
        }

        ArrayList<String> wordsToSolve = new ArrayList<String>();
        try {
            scanner = new Scanner(filePath);
            while(scanner.hasNextLine()) {
                wordsToSolve.add(scanner.nextLine().toUpperCase().trim());
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File import failed.");
        } finally {
            if(scanner != null) {
                scanner.close();
            }
        }

        Collections.shuffle(wordsToSolve);

        System.out.println(wordsToSolve.toString());
        return;
    }
}
