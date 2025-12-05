package app.src.main.java.org.example;

public class Guess {
    // returns: an array of five chars, one representing each position of the input and output words
    //      each position will be G for green (correct letter in correct position),
    //      Y for yellow (correct letter in wrong position),
    //      or R for red/gray (letter not in solved word)
    public static char[] solve(String guess, Word constant) throws IllegalArgumentException {
        if(guess.length() != 5) throw new IllegalArgumentException("Your guess does not have five letters");
        char[] result = new char[5];
        for(int i = 0; i < 5; i++) {
            if(guess.charAt(i) == constant.charAt(i)) { 
                result[i] = 'G';
            } else if(constant.toString().contains(String.valueOf(guess.charAt(i)))) { 
                result[i] = 'Y';
            } else {
                result[i] = 'R';
            }
        }
        return result;
    }

    public static boolean isSolved(String guess, Word constant) throws IllegalArgumentException {
        if(guess.length() != 5) throw new IllegalArgumentException("Your guess does not have five letters");
        char[] result = solve(guess, constant);
        if(String.valueOf(result).equals("GGGGG")) return true;
        else return false;
    }
}
