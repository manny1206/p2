public class MissingCharAlphabetException extends AlphabetException {
    public final char offender;
    public final Alphabet a;

    MissingCharAlphabetException(char offender, Alphabet a) {//formatting for chars not being in the alphabet
        super("Not in alphabet: '" + offender + "' not found in " + a.toString() + ".");
        this.offender = offender;
        this.a = a;

    }
}
