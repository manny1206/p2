public class Alphabet {

  public static final Alphabet DEFAULT = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz 1234567890!@#$%^&*()_+-=[]{}\\|;:'\",./?<>");

  private String symbols;

  public Alphabet(String symbols) {
    this.symbols = symbols;
  }

  public int indexOf(char c) { //returns index in alphabet of a char
    if (symbols.indexOf(c) == -1) {
      throw new MissingCharAlphabetException(c, this);
    } else {
      return symbols.indexOf(c);
    }
  }

  public char get(int i) { //return char at index i in alphabet
    if (symbols.charAt(i) < 0 || symbols.charAt(i) > symbols.length()) {
      throw new BadIndexAlphabetException(i,this);
    } else {
      return symbols.charAt(i);
    }
  }

  public int length() {
    return symbols.length();
  }

  public String getSymbols() {
    return symbols;
  }

  public String toString() {
    return ("Alphabet(" + symbols + ")");
  }

  public boolean equals(Object other) {
    if (this.equals(other)) {
      return true;
    } else {
      return false;
    }
  }
}