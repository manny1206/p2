public class P2 {
  
  public static void main(String[] args){
    String recovered = "HELLOTHERE";
    if (args.length>0){ recovered = args[0];}
    
    String hidden = null;
    System.out.println(recovered);
    Cipher c;
    
    Alphabet alphabet = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwyz .,;:/?'\"[]{}=+-_)(*&^%$#@!1234567890~`");
    try {
      System.out.println("============\n   Caesar   \n============");
      c = new CaesarCipher(12,alphabet);
      hidden    = c.encrypt(recovered);
      recovered = c.decrypt(hidden   );
      System.out.println(String.format("Caesar:   '%s' --> '%s'",hidden, recovered));
    } catch (Exception e){System.err.println(e);}
    
    try{
      System.out.println("============\n  Vigenere  \n============");
      c = new VigenereCipher("GREENSLIME",alphabet);
      hidden    = c.encrypt(recovered);
      recovered = c.decrypt(hidden   );
      System.out.println(String.format("Vigenere: '%s' --> '%s'",hidden, recovered));
    } catch (Exception e){System.err.println(e);}
    
    try {
      System.out.println("============\n   Morse    \n============");
      c = new MorseCipher();
      hidden    = c.encrypt(recovered);
      recovered = c.decrypt(hidden   );
      System.out.println(String.format("Morse:    '%s' --> '%s'",hidden, recovered));
    } catch (Exception e){System.err.println(e);}
    
  }
}