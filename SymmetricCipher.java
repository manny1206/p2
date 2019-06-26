public abstract class SymmetricCipher extends Cipher{
    protected Alphabet alphabet;

    public SymmetricCipher(Alphabet alphabet) {
        this.alphabet = alphabet;
    }
    public int wrapInt(int i) {
        if (Math.abs(i) > (alphabet.length() - 1)) { // if index is too big (negative or positive), mod it as the answer
            return Math.abs(i % alphabet.length());
        }
        else if (i < 0 && Math.abs(i) < alphabet.length()) { //if index is negative but not too big, subtract it from alphabet length
            return  (alphabet.length() + i);
        }
        else {//if (i > 0 && i < alphabet.length()) { //if it's a valid index
            return i;
        }
    }
    public int rotate(int index, int shift) {//rotate an index shift times to its new valid index
        if (shift > 0) {//if your moving it forward
            while (shift > 0) {
                if(index + 1 < alphabet.length()){ index++;}
                else {index = 0;}
                shift--;
            }
        }
        else if (shift < 0) {//if your moving it backwards
            while (shift < 0) {
                if (index - 1 > -1) {index--;}
                else {index = alphabet.length() - 1;}
                shift++;
            }
        }
        return index;
    }
    public Alphabet getAlphabet(){
        return alphabet;
    }

    protected abstract char encrypt1(char c);
    protected abstract char decrypt1(char c);

    public String encrypt(String s) {
        char[] changestring = s.toCharArray();
        for (int i = 0;i < changestring.length;i++) {
            if (alphabet.toString().contains(String.valueOf(changestring[i])) == false){//checks if a char is in the string, throw exception if false
                throw new MissingCharAlphabetException(changestring[i],alphabet);
            }
            encrypt1(changestring[i]);//calls encrypt1 to encrypt each char
        }
        return s = String.valueOf(changestring);
    }
    public String decrypt(String s) {//same as encrypt but reversed
        char[] changestring = s.toCharArray();
        for (int i = changestring.length - 1;i > -1;i--) {
            if (alphabet.toString().contains(String.valueOf(changestring[i])) == false){//checks if a char is in the string, throw exception if false
                throw new MissingCharAlphabetException(changestring[i],alphabet);
            }
            decrypt1(changestring[i]);//calls decrypt1 to revert each char
        }
        return s = String.valueOf(changestring);
    }
}
