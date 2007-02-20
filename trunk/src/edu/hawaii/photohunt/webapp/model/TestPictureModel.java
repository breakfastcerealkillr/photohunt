package edu.hawaii.photohunt.webapp.model;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests the functionality of the PictureModel class.
 * 
 * @author George Lee
 *
 */
public class TestPictureModel extends TestCase {

  /**Path name for the sample picture files.*/
  private static final String testPath = "sample-pictures/";

  /**Tests the construction of the PictureModel class.*/
  @Test
  public void testStartup() {
    PictureModel testModel = new PictureModel(testPath);

    assertEquals("Testing correct number of files.", testModel.getNew().size(), 6);
  }

  /**Tests that pictures are approved.*/
  @Test
  public void testApproval() {
    PictureModel testModel = new PictureModel(testPath);
    for (String filename : testModel.newPictures) {
      testModel.approvePicture(filename);
    }

    //Test that the two picture arrays are the same length and that they contain the same file.
    for (String testName : testModel.approvedPictures) {
      assertTrue("Testing approval of all pictures.", testModel.getApproved().contains(testName));
    }
  }
  
  
}
