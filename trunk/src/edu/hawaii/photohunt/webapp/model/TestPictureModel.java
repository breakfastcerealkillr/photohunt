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
public class TestPictureModel extends TestCase {

  /**Path name for the sample picture files.*/
  private static final String testPath = "sample-pictures/";
  
  /**List used for testing.*/
  private List<File> pictureList = new ArrayList<File>();

  /**Tests the construction of the PictureModel class.
   * 
   * @throws PictureFileException if there is an error while opening the directory.
   */
  @Test
  public void testStartup() throws PictureFileException {
    PictureModel testModel = new PictureModel(testPath);
    
    this.pictureList = testModel.getPictureList();
    assertEquals("Testing correct number of files.", this.pictureList.size(), 6);
  }
}
