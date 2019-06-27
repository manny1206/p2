public class VigenereCipher extends SymmetricCipher{
    protected String password;
    protected int passwordPos = 0;

    public VigenereCipher(String password, Alphabet alphabet){
        super(alphabet);
        this.password = password;
    }
    public VigenereCipher(String password){
        super(Alphabet.DEFAULT);
        this.password = password;
    }
    public String getPassword(){ return password; }
    protected char encrypt1(char c){
        int newchar = rotate(alphabet.indexOf(c), alphabet.indexOf(password.charAt(passwordPos)));//shift by password index in alphabet
        passwordPos = rotate(passwordPos,1);
        return alphabet.get(newchar);
    }
    protected char decrypt1(char c) {
        int oldchar = rotate(alphabet.indexOf(c), -alphabet.indexOf(password.charAt(passwordPos)));
        passwordPos = rotate(passwordPos,-1);
        return alphabet.get(oldchar);
    }
    public String encrypt(String s){
        passwordPos = 0;
        String newstring = "";
        for (int i = 0;i < s.length();i++){
            newstring += encrypt1(s.charAt(i));
        }
        return newstring;
    }
    public String decrypt(String s){
        passwordPos = password.length() - 1;
        String oldstring = "";
        for (int i = s.length() - 1;i > -1;i--){
            oldstring += decrypt1(s.charAt(i));
        }
        return oldstring;
    }
    public String toString(){
        return ("Vigenere Cipher (password='" + password + "')");
    }
}
