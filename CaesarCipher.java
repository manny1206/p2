public class CaesarCipher extends SymmetricCipher{
    protected int shift;

    public CaesarCipher(int shift, Alphabet alphabet){
        this.shift = shift;
        this.alphabet = alphabet;
    }
    public CaesarCipher(int shift){
        this.shift = shift;
        this.alphabet = Alphabet.DEFAULT;
    }
    protected char encrypt1(char c) {
        return 0;
    }
    protected char decrypt1(char c) {
        return 0;
    }
    public String encrypt(String s){
        String enstring = "";
        for (int i = 0;i < s.length();i++){ //loop through de string
            int newindex = rotate(alphabet.indexOf(s.charAt(i)),shift);//all the nonsense b4 shift is just the index

            enstring += alphabet.get(newindex);
        }
        return enstring;
    }
    public String decrypt(String s){
        String enstring = "";
        for (int i = 0;i < s.length();i++){ //loop through de string
            int newindex = rotate(alphabet.indexOf(s.charAt(i)),-shift);//all the nonsense b4 shift is just the index

            enstring += alphabet.get(newindex);
        }
        return enstring;
    }
    public String toString(){

    }
}
