package edu.hawaii.photohunt.webapp.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The PictureModel class performs the operations needed for the picture review process in Photo
 * Hunt.  Supports only .jpg and .gif file types for now.
 * 
 * @author George Lee
 * 
 */
public class PictureModel {

  /** Default path to the pictures directory. */
  public static final String DEFAULT_PATH = "approved/";

  /** List of the filenames for the pictures. */
  protected List<File> pictures = new ArrayList<File>();

  /**
   * Create a new PictureModel instance. Places jpg and gif files into the folder. Uses the default
   * file path.
   */
  public PictureModel() {
    File directory = new File(DEFAULT_PATH);
    //Assume default directory is correct.
    
    this.pictures = Arrays.asList(directory.listFiles(new PictureFileFilter()));
  }
  
  /**
   * Create a new PictureModel instance.  Places jpg and gif files into the folder.
   * 
   * @param pathname The file path of the directory containing the pictures.
   * @throws PictureFileException if there is an error opening the directory.
   */
  public PictureModel(String pathname) throws PictureFileException {
    File directory = new File(pathname);
    if (!directory.isDirectory()) {
      throw new PictureFileException("The path does not point to a directory.");
    }
    
    this.pictures = Arrays.asList(directory.listFiles(new PictureFileFilter()));
  }

  /**
   * Get the list of available pictures.
   * 
   * @return The list of pictures.
   */
  public List<File> getPictureList() {
    return this.pictures;
  }
  
  /**
   * Gets the picture at the specified index.
   * 
   * @param index The index of the picture to be retrieved.
   * @return The file path to the picture.
   */
  public File getPicture(int index) {
    return this.pictures.get(index);
  }
}
