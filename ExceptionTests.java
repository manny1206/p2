import org.junit.*;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;
import java.util.*;

public class ExceptionTests {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("ExceptionTests");
  }

  // 1 second max per method tested
  @Rule public Timeout globalTimeout = Timeout.seconds(1);
  
  static Alphabet uppers     = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ ."); 
  static Alphabet lowers     = new Alphabet("abcdefghijklmnopqrstuvwxyz");
  static Alphabet lowerSpace = new Alphabet("abcdefghijklmnopqrstuvwxyz ");
  
  @Test public void test_AlphabetException_1(){ assertEquals("test message",new AlphabetException("test message").getMessage()); }
  @Test public void test_AlphabetException_2(){ assertEquals("Welcome to CS211!",new AlphabetException("Welcome to CS211!").getMessage()); }
  
  @Test public void test_missingchar_1(){ assertEquals("Not in alphabet: 'A' not found in Alphabet(abc).",new MissingCharAlphabetException('A', new Alphabet("abc")).getMessage()); }
  @Test public void test_missingchar_2(){ assertEquals("Not in alphabet: 'y' not found in Alphabet(aeiou).",new MissingCharAlphabetException('y', new Alphabet("aeiou")).getMessage()); }
  @Test public void test_missingchar_3(){ assertEquals('Q',new MissingCharAlphabetException('Q', new Alphabet("aeiou")).offender); }
  @Test public void test_missingchar_4(){ assertEquals(lowers,new MissingCharAlphabetException('Q', lowers).a); }
  @Test public void test_missingchar_5(){
    try{
      assertEquals(20,new Alphabet("ABCDEFGHIJabcdefghijk").indexOf('X'));
      fail("shouldn't get here...");
    } catch (MissingCharAlphabetException e){
      /* good. */
      assertEquals("Not in alphabet: 'X' not found in Alphabet(ABCDEFGHIJabcdefghijk).",e.getMessage());
    }
  }
  
  @Test public void test_badindex_1(){ assertEquals("Not in alphabet: no index -1 found in Alphabet(abc).",new BadIndexAlphabetException(-1, new Alphabet("abc")).getMessage()); }
  @Test public void test_badindex_2(){ assertEquals("Not in alphabet: no index 30 found in Alphabet(abcdefghijklmnopqrstuvwxyz).",new BadIndexAlphabetException(30, lowers).getMessage()); }
  @Test public void test_badindex_3(){ assertEquals(1234,new BadIndexAlphabetException(1234, lowers).index); }
  @Test public void test_badindex_4(){ assertEquals(lowers,new BadIndexAlphabetException(-13, lowers).a); }
  @Test public void test_badindex_5(){
    try {
      assertEquals(5, new Alphabet("WXYZ").get(10));
      fail("shouldn't get here...");
    } catch (BadIndexAlphabetException e){
      /* good. */
      assertEquals("Not in alphabet: no index 10 found in Alphabet(WXYZ).",e.getMessage());
    }
  }
}