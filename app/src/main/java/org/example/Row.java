package app.src.main.java.org.example;

public class Row {
    private DisplayChar[] chars;

    Row() {
        chars = new DisplayChar[5];
        for(int i = 0; i < 5; i++) {
            chars[i] = new DisplayChar();
        }
    }

    public DisplayChar at(int index) {
        return chars[index];
    }

    @Override
    public String toString() {
        String returned = "";
        for(int i = 0; i < 5; i++) {
            returned += chars[i].getLetter();
        }
        return returned;
    }
}
