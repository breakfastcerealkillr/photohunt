package edu.hawaii.photohunt.mail;

import org.junit.Test;
import junit.framework.TestCase;

/**
 * JUnit testing for Receiver class.
 * 
 * @author Elayne Man
 *
 */
public class TestReceiver extends TestCase {

  /**
   * Tests the receiving capabilities of Receiver.
   *
   */
  @Test
  public void testMail() {
    Receiver inbox = new Receiver();
    boolean result = inbox.receive();
    
    assertTrue("Testing for successful execution of receive()", result);
    
  }
  
}
