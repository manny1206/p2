public class CaesarCipher extends SymmetricCipher{
    protected int shift;

    public CaesarCipher(int shift, Alphabet alphabet){
        super(alphabet);
        this.shift = shift;
        this.alphabet = alphabet;
    }
    public CaesarCipher(int shift){
        super(Alphabet.DEFAULT);
        this.shift = shift;
        this.alphabet = Alphabet.DEFAULT;

    }
    protected char encrypt1(char c) {
        return alphabet.get(rotate(alphabet.indexOf(c),shift));
    }
    protected char decrypt1(char c) {
        return alphabet.get(rotate(alphabet.indexOf(c),-shift));
    }
    public String encrypt(String s){
        String newstring = "";
        for (int i = 0;i < s.length();i++){ //loop through de string
            int newindex = rotate(alphabet.indexOf(s.charAt(i)),shift);//all the nonsense b4 shift is just the index

            newstring += alphabet.get(newindex);
        }
        return newstring;
    }
    public String decrypt(String s){//same as encrypt but negative shift
        String oldstring = "";
        for (int i = 0;i < s.length();i++){ //loop through de string
            int newindex = rotate(alphabet.indexOf(s.charAt(i)),-shift);//all the nonsense b4 shift is just the index

            oldstring += alphabet.get(newindex);
        }
        return oldstring;
    }
    public String toString(){
        return ("Caesar Cipher (shift=" + shift + ")");
    }//makes a string
}
