public class BadIndexAlphabetException extends AlphabetException {
    public final int index;
    public final Alphabet a;

    BadIndexAlphabetException(int index, Alphabet a) {//formatting for bad index exceptions
        super("Not in alphabet: no index " + index + " found in " + a.toString() + ".");
        this.index = index;
        this.a = a;
    }
}
