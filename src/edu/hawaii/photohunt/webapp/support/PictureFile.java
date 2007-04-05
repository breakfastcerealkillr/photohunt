package edu.hawaii.photohunt.webapp.support;

import java.io.File;

/**
 * The PictureFile class contains the information needed to display a picture in Photo Hunt. This
 * includes the pathname as well as the approval status.
 * 
 * @author George Lee
 * 
 */
public class PictureFile {
  /**The local directory name for this picture.*/
  private final String directory;

  /**The path name for this picture.*/
  private final String path;

  /**
   * The status of this picture. True if the picture is to be approved. False if it is to be
   * denied.
   */
  private boolean approved;

  /** Marks the picture for deletion.  Set to true to delete the picture, false otherwise.*/
  private boolean delete;

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

  /**
   * Mark the picture for deletion.
   * 
   * @param delete True if the picture is to be deleted, false otherwise.
   */
  public void setDelete(boolean delete) {
    this.delete = delete;
  }

  /**
   * Get the deletion status of the picture.
   * 
   * @return True if the picture is marked for deletion, false otherwise.
   */
  public boolean isDelete() {
    return this.delete;
  }

}
