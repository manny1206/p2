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
   plaintext = plaintext.toUpperCase();
   String cryptText = "";
   boolean did3space = false;
   for (int i = 0; i < plaintext.length(); i++){
       if (Character.isWhitespace(plaintext.charAt(i))){// check if plaintext at i is a space
           if (did3space != true) {cryptText += "       ";} // add 7 spaces cuz new word
           else{cryptText += "    ";} // if you already did 3 spaces, only add 4 more
           did3space = false;
       }
       else if (i + 1 == plaintext.length()){
           int de_index = alphabet.indexOf(plaintext.charAt(i));//find the index in codes that corresponds to the one in letters;
           cryptText += codes[de_index];} // if you reach the end, stop adding spaces
       else{
           int de_index = alphabet.indexOf(plaintext.charAt(i));//find the index in codes that corresponds to the one in letters; lol i put this in twice
           cryptText += (codes[de_index] + "   "); //add it to newtext with 3 spaces
           did3space = true;
       }
   }
   return cryptText;
 }

  public String decrypt(String cryptText) {
      String plainText = "";
      String letterCheck = "";
      for (int i = 0; i < cryptText.length(); i++){
          if (Character.isWhitespace(cryptText.charAt(i))){// check if cryptText at i is a space
              //removing the spaces
              if (i + 6 < cryptText.length()) {// if it's a new word
                  if (cryptText.substring(i,i + 7).equals("       ")){
                      plainText += " ";
                      i += 6;
                  }
              }
              else if (i + 2 < cryptText.length()) {// skip normal space between letters
                  if (cryptText.substring(i,i + 3).equals("   ")){
                      i += 2;
                  }
              }

          }
          else{
              letterCheck += cryptText.charAt(i);//add non-spaces to letterChecks
          }
          if (letterCheck != "" && (i + 1 == cryptText.length() || Character.isWhitespace(cryptText.charAt(i + 1)))){
              for (int j = 0;j < codes.length;j++){
                  if (letterCheck.equals(codes[j])){
                      plainText += letters.charAt(j);
                      letterCheck = "";//revert letterCheck back to normal, if used
                  }
              }
          }
      }
    return plainText;
  }
}