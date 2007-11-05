package edu.hawaii.photohunt.webapp.support;

import java.io.File;
import java.io.FileFilter;

/**
 * The PictureFileFilter class checks to see if the file is a valid picture. Currently, it only
 * supports JPEG and GIF files.
 * 
 * @author George Lee
 */
public class PictureFileFilter implements FileFilter {

  /**
   * Check if the pathname points to a valid picture file.
   * 
   * @param pathname The pathname to check.
   * @return True if the picture satisfies the conditions, false otherwise.
   */
  public boolean accept(File pathname) {
    String filename = pathname.getName();
    if (filename.endsWith(".jpg") || filename.endsWith(".gif")) {
      return true;
    }
    
    //If the above test fails, return false.
    return false;
  }
}
