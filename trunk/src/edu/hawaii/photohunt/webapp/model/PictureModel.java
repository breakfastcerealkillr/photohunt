package edu.hawaii.photohunt.webapp.model;

import java.io.File;
import java.util.ArrayList;
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
  public static final String DEFAULT_PATH = "pictures/";

  /** List of the filenames for the pictures. */
  protected List<String> newPictures = new ArrayList<String>();

  /** List of the approved pictures. */
  protected List<String> approvedPictures = new ArrayList<String>();

  /**
   * Create a new PictureModel instance.  Places jpg and gif files into the folder.
   * 
   * @param pathname The file path of the directory containing the pictures.
   */
  public PictureModel(String pathname) {
    File directory = new File(pathname);
    String[] pictures = directory.list();
    for (int i = 0; i < pictures.length; i++) {
      //Take only jpg and gif files.
      if (pictures[i].contains(".jpg") || pictures[i].contains(".gif")) {
        this.newPictures.add(pictures[i]);
      }
    }

  }

  /**
   * Add picture to the list of approved pictures.
   * 
   * @param filename The file path of the picture to be approved.
   */
  public void approvePicture(String filename) {
    this.approvedPictures.add(filename);
  }

  /**
   * Deny picture and remove it from the list of available pictures and delete it from the disk.
   * 
   * @param filename The file path of the picture to remove.
   */
  public void denyPicture(String filename) {
    //To be implemented later.
  }

  /**
   * Get the list of approved pictures.
   * 
   * @return The file names of the approved pictures.
   */
  public List<String> getApproved() {
    return this.approvedPictures;
  }

  /**
   * Get the list of new pictures.
   * 
   * @return The file names of the new pictures.
   */
  public List<String> getNew() {
    return this.newPictures;
  }
}
