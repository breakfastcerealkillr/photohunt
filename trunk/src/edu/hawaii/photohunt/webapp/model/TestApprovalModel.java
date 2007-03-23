package edu.hawaii.photohunt.webapp.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests the functionality of the PictureModel class.
 * 
 * @author George Lee
 *
 */
public class TestApprovalModel extends TestCase {
  
  /**Lists used for testing the ApprovalModel class.*/
  private List<PictureFile> testPending = new ArrayList<PictureFile>();

  /**
   * Test normal operation of the ApprovalModel class.
   * 
   * @throws PictureFileException if there is an error while opening the directory.
   */
  @Test
  public void testNormalOperation() throws PictureFileException {
    ApprovalModel model = new ApprovalModel();
    
    this.testPending = model.getPending();
    
    assertEquals("Testing the initial size of the pending list.", 14, this.testPending.size());
  }
}
