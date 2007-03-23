package edu.hawaii.photohunt.webapp.model;

import java.io.File;

/**
 * The PictureFile class contains the information needed to display a picture in Photo Hunt. This
 * includes the pathname as well as the approval status.
 * 
 * @author George Lee
 * 
 */
public class PictureFile {
  /**The directory name for this picture.*/
  private final String directory;
  
  /**The path name for this picture.*/
  private final String path;
  
  /**
   * The status of this picture. TRUE if the picture is to be approved. False if it is to be
   * deleted.
   */
  private boolean approved;
  
  /**
   * Constructor for the PictureFile class.  The approval status defaults to false.
   * 
   * @param directory The file directory for this picture.
   * @param file The file to be added to the list.
   */
  public PictureFile(String directory, File file) {
    this.directory = directory;
    this.path = this.directory + file.getName();
    this.approved = false;
  }
  
  /**
   * Get the directory of the files.
   * 
   * @return The path to the directory containing the files.
   */
  public String getDirectory() {
    return this.directory;
  }
  
  /**
   * Get the path of this picture.
   * 
   * @return The absolute file path of this picture.
   */
  public String getPath() {
    return this.path;
  }
  
  /**
   * Set the approval status of this picture.
   * 
   * @param status The boolean value to set the status to.
   */
  public void setApproved(boolean status) {
    this.approved = status;
  }
  
  /**
   * Get the approval status of this picture.
   * 
   * @return The current approval status of this picture.
   */
  public boolean isApproved() {
    return this.approved;
  }
}
