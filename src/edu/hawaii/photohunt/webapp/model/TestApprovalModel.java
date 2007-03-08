package edu.hawaii.photohunt.webapp.model;

import java.io.File;
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

  /**Path name for the sample picture files.*/
  private static final String testPath = "sample-pictures/";
  
  /**Path name for the sample approved picture files.*/
  private static final String testApprovedPath = "sample-pictures/approved";
  
  /**Lists used for testing the ApprovalModel class.*/
  private List<File> testPending = new ArrayList<File>();
  private List<File> testApproved = new ArrayList<File>();

  /**
   * Test normal operation of the ApprovalModel class.
   * @throws PictureFileException if there is an error while opening the directory.
   */
  @Test
  public void testNormalOperation() throws PictureFileException {
    ApprovalModel model = new ApprovalModel(testPath, testApprovedPath);
    
    this.testPending = model.getPending();
    this.testApproved = model.getApproved();
    
    assertEquals("Testing the initial size of the pending list.", this.testPending.size(), 6);
    assertEquals("Testing the initial size of the approved list.", this.testApproved.size(), 0);
    
    //Approve a picture.
    model.approvePicture(this.testPending.get(0));
    assertEquals("Testing the new size of the approved list.", this.testApproved.size(), 1);
  }
}
