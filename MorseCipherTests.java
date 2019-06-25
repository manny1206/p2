import org.junit.*;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;
import java.util.*;

public class MorseCipherTests {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("MorseCipherTests");
  }
  
  // 1 second max per method tested
  @Rule public Timeout globalTimeout = Timeout.seconds(1);
  
  /*  MorseCipher tests */
  
  MorseCipher mc = new MorseCipher();
  // @Test public void test_Morse_1(){ assertEquals(new Alphabet(MorseCipher.letters),new MorseCipher().getAlphabet()); }
  // @Test public void test_Morse_2(){
  //   try{ mc.encrypt1('a');}
  //   catch(UnsupportedOperationException e){return;}
  //   fail("should not allow encrypt1(char) to be called.");
  // }
  // @Test public void test_Morse_3(){
  //   try{ mc.encrypt1('a');}
  //   catch(UnsupportedOperationException e){return;}
  //   fail("should not allow decrypt1(char) to be called.");
  // }
  
  
  @Test public void test_Morse_4(){
    assertEquals(".-",mc.encrypt("A"));
  }
  
  @Test public void test_Morse_5() {
    assertEquals("....   .   .-..   .-..   ---", mc.encrypt("HELLO"));
  }
  
  @Test public void test_Morse_6(){
    assertEquals(".----   ..---   ...--", mc.encrypt("123"));
  }
  
  @Test public void test_Morse_7(){
    assertEquals(".-       -...   -...       -.-.   -.-.   -.-.", mc.encrypt("a bb ccc"));
  }
  
  @Test public void test_Morse_8(){
    assertEquals(".-.   ..-   -.       ..-.   ---   .-.       -   ....   .       .   -..-   ..   -   ...", mc.encrypt("run for the exits"));
  }
  
  @Test public void test_Morse_9(){
    assertEquals("A",mc.decrypt(".-"));
  }
  
  @Test public void test_Morse_10() {
    assertEquals("HELLO",mc.decrypt("....   .   .-..   .-..   ---"));
  }
  
  @Test public void test_Morse_11(){
    assertEquals("123", mc.decrypt(".----   ..---   ...--"));
  }
  
  @Test public void test_Morse_12(){
    assertEquals("A BB CCC",mc.decrypt(".-       -...   -...       -.-.   -.-.   -.-."));
  }
  
  @Test public void test_Morse_13(){
    assertEquals("RUN FOR THE EXITS", mc.decrypt(".-.   ..-   -.       ..-.   ---   .-.       -   ....   .       .   -..-   ..   -   ..."));
  }
  
  
  @Test public void test_Morse_14(){
    try {
      String s = new MorseCipher().encrypt("%^&*");
    } catch (MissingCharAlphabetException e){ return; }
    fail("shouldn't encrypt any characters not in the alphabet.");
  }
  
  
}
