package edu.hawaii.photohunt.webapp.support;

import java.io.File;

import javax.faces.model.SelectItem;

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
  
  /**The tag description of this picture.*/
  private final String tagLabel;
  
  /**The tag value of this picture.*/
  private final String tagValue;

  /**
   * Constructor for the PictureFile class.  The approval status defaults to false.
   * 
   * @param directory The file directory for this picture.
   * @param file The file representing the picture.
   */
  public PictureFile(String directory, File file) {
    this.tagValue = directory;
    this.directory = directory;
    this.tagLabel = directory;
    this.path = this.directory + file.getName();
  }
  
  /**
   * Constructor for the PictureFile class.  The approval status defaults to false.
   * 
   * @param tag The tag for this picture.
   * @param directory The file directory for this picture.
   * @param file The file representing the picture.
   */
  public PictureFile(SelectItem tag, String directory, File file) {
    this.tagValue = tag.getValue().toString();
    this.tagLabel = tag.getLabel();
    this.directory = directory;
    this.path = this.directory + file.getName();
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
   * Get the tag of the picture.
   * 
   * @return The tag description for this picture.
   */
  public String getTagLabel() {
    return this.tagLabel;
  }

  /**
   * Get the tag value of the picture.
   * 
   * @return The tag value for this picture.
   */
  public String getTagValue() {
    return this.tagValue;
  }
}
