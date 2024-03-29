// Demonstrate the use of interchangeable ciphers. Most of the classes
// in the project will need to be complete for this code to work
// properly.
public class P2Demo {
  public static void main(String[] args){
    Alphabet alphabet = Alphabet.DEFAULT;
    String encrypted, decrypted;
    Cipher c;
    String message = "All your base are belong to us.";
    
    c = new CaesarCipher(2,alphabet);
    encrypted = c.encrypt(message);
    decrypted = c.decrypt(encrypted);
    System.out.printf("Cipher:    %s\n",c.toString());
    System.out.printf("Message:   %s\n",message);
    System.out.printf("Encrypted: %s\n",encrypted);
    System.out.printf("Decrypted: %s\n",decrypted);
    System.out.println();
    // Cipher:    Caesar Cipher (shift=2)
    // Message:   All your base are belong to us.
    // Encrypted: Cnn2 qwt2dcug2ctg2dgnqpi2vq2wu?
    // Decrypted: All your base are belong to us.
    
    c = new CaesarCipher(17,alphabet);
    encrypted = c.encrypt(message);
    decrypted = c.decrypt(encrypted);
    System.out.printf("Cipher:    %s\n",c.toString());
    System.out.printf("Message:   %s\n",message);
    System.out.printf("Encrypted: %s\n",encrypted);
    System.out.printf("Decrypted: %s\n",decrypted);
    System.out.println();
    // Cipher:    Caesar Cipher (shift=17)
    // Message:   All your base are belong to us.
    // Encrypted: R22&%5!8&sr9v&r8v&sv254x&05&!9M
    // Decrypted: All your base are belong to us.
    
    c = new VigenereCipher("Cats",alphabet);
    encrypted = c.encrypt(message);
    decrypted = c.decrypt(encrypted);
    System.out.printf("Cipher:    %s\n",c.toString());
    System.out.printf("Message:   %s\n",message);
    System.out.printf("Encrypted: %s\n",encrypted);
    System.out.printf("Decrypted: %s\n",decrypted);
    System.out.println();
    // Cipher:    Vigenere Cipher (password='Cats')
    // Message:   All your base are belong to us.
    // Encrypted: C!|D $<,21(.g](,g])+n$:=2('Dw*o
    // Decrypted: All your base are belong to us.
    
    // Comment out this section if not implementing the MorseCipher
    message = "ALL YOUR BASE";
    c = new MorseCipher();
    encrypted = c.encrypt(message);
    decrypted = c.decrypt(encrypted);
    System.out.printf("Cipher:    %s\n",c.toString());
    System.out.printf("Message:   %s\n",message);
    System.out.printf("Encrypted: %s\n",encrypted);
    System.out.printf("Decrypted: %s\n",decrypted);
    System.out.println();
    // Cipher:    Morse Cipher
    // Message:   ALL YOUR BASE
    // Encrypted: .-   .-..   .-..       -.--   ---   ..-   .-.       -...   .-   ...   .
    // Decrypted: ALL YOUR BASE
  }
}
