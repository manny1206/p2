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
   for (int i = 0; i < plaintext.length(); i++){
     if (Character.isWhitespace(plaintext.charAt(i))){// check if plaintext at i is a space
      cryptText += "       "; // add 7 spaces cuz new word

     }else{
       int de_index = alphabet.indexOf(plaintext.charAt(i));//find the index in codes that corresponds to the one in letters;
       cryptText += (codes[de_index] + "   "); //add it to newtext with 3 spaces
     }
   }
   return cryptText;
 }

  public String decrypt(String cryptText) {
      String plainText = "";
      String letterCheck = "";
      int count = 0;
      for (int i = 0; i < cryptText.length(); i++){
          if (Character.isWhitespace(cryptText.charAt(i))){// check if plaintext at i is a space
              //loop through codes to find the corresponding match in letters
              if (letterCheck != ""){
                  for (int j = 0;j < codes.length;j++){

                  }
                  letterCheck = "";//revert letterCheck back to normal
              }
              //removing the spaces
              if (cryptText.substring(i,i + 6) == "       ") {// if it's a new word

              }
              else if (cryptText.substring(i,i + 2) == "   ") {// if it's normal space between letters

              }

          }else{
              letterCheck += cryptText.charAt(i);
          }
      }
    return null;
  }
}