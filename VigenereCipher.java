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
        int newindex = rotate(alphabet.indexOf(c),alphabet.indexOf(password.charAt(passwordPos)));//add old index & password index
        if (passwordPos + 1 == password.length()){//increment passwordPos
            passwordPos = 0;
        }else{passwordPos++;}
        return alphabet.get(newindex);
    }
    protected char decrypt1(char c) {
        int oldindex = rotate(alphabet.indexOf(c), -alphabet.indexOf(password.charAt(passwordPos)));
        if (passwordPos + 1 == password.length()){//increment passwordPos
            passwordPos = 0;
        }else{passwordPos++;}
        return alphabet.get(oldindex);
    }
    public String encrypt(String s){
        return super.encrypt(s);
    }
    public String decrypt(String s){
        return super.decrypt(s);
    }
    public String toString(){
        return ("Vigenere Cipher (password='" + password + "')");
    }
}
