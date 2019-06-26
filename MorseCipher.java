import java.lang.*;
class MorseCipher extends Cipher{
  
  public static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
  public static final String[] codes = {
    ".-",    /* A */    "-...",  /* B */    "-.-.",  /* C */    "-..",   /* D */
    ".",     /* E */    "..-.",  /* F */    "--.",   /* G */    "....",  /* H */
    "..",    /* I */    ".---",  /* J */    "-.-",   /* K */    ".-..",  /* L */
    "--",    /* M */    "-.",    /* N */    "---",   /* O */    ".--.",  /* P */
    "--.-",  /* Q */    ".-.",   /* R */    "...",   /* S */    "-",     /* T */
    "..-",   /* U */    "...-",  /* V */    ".--",   /* W */    "-..-",  /* X */
    "-.--",  /* Y */    "--..",  /* Z */    ".----", /* 1 */    "..---", /* 2 */
    "...--", /* 3 */    "....-", /* 4 */    ".....", /* 5 */    "-....", /* 6 */
    "--...", /* 7 */    "---..", /* 8 */    "----.", /* 9 */    "-----", /* 0 */
  };
  private Alphabet alphabet = new Alphabet(letters);
 public MorseCipher(){
 }
  public String encrypt(String plaintext){
   plaintext.toUpperCase();
   String cryptText = "";
   int count = 0;
   for (int i = 0; i < plaintext.length(); i++){
     if (Character.isWhitespace(plaintext.charAt(i))){// check if plaintext at i is a space
      cryptText += "       "; // add 7 spaces cuz new word

     }else{
       int de_index = alphabet.indexOf(plaintext.charAt(i));//find the index in codes that corresponds to the one in letters;
       cryptText += codes[de_index] + "   "; //add it to newtext with 3 spaces
     }
   }
   return cryptText;
 }

  public String decrypt(String cryptText) {
    for (int i = 0;i < cryptText.length();i++)
    return null;
  }
}