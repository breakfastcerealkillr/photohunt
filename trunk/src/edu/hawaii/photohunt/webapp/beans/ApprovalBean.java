package edu.hawaii.photohunt.webapp.beans;

import java.io.File;
import java.util.List;

import edu.hawaii.photohunt.webapp.model.ApprovalModel;

/**
 * The ApprovalBean class is a bean that backs the approval pages in Photo Hunt. It uses
 * ApprovalModel to manipulate the pictures.
 * 
 * @author George Lee
 * 
 */
public class ApprovalBean {

  /** The model supporting the ApprovalBean. */
  private final ApprovalModel model = new ApprovalModel();

  /** Track the current picture in the list. */
  private int counter = 0;

  /** List of the pending pictures. */
  private final List<File> pendingPictures = this.model.getPending();

  /** The file name of the currently displayed picture. */
  private String currentPicture = this.model.getPendingDirectory()
      + this.pendingPictures.get(0).getName();

  /**
   * Constructor for the ApprovalBean.
   */
  public ApprovalBean() {
    // JavaBeans need an empty constructor.
  }

  /**
   * Get the current picture.
   * 
   * @return The current picture to be displayed.
   */
  public String getCurrentPicture() {
    return this.currentPicture;
  }

  /**
   * Set the current picture.
   * 
   * @return null if there is another picture, "end" otherwise.
   */
  public String setCurrentPicture() {
    this.counter++;
    this.currentPicture = this.model.getPendingDirectory()
        + this.pendingPictures.get(this.counter).getName();
    return null;
  }

  /**
   * Approve the current picture.
   * 
   * @return null if there are more pictures (refreshes current page). Returns end if there are no
   *         pictures left.
   */
  public String approvePicture() {
    this.model.approvePicture(this.pendingPictures.get(this.counter));
    try {
      return this.setCurrentPicture();
    }

    //If an index out of bounds error occurs, there are no pictures left to display.
    catch (IndexOutOfBoundsException e) {
      return "end";
    }
  }

  /**
   * Deny the current picture.
   * 
   * @return null if there are more pictures (refreshes current page). Returns end if there are no
   *         pictures left.
   */
  public String denyPicture() {
    this.model.denyPicture(this.pendingPictures.get(this.counter));
    try {
      return this.setCurrentPicture();
    }

    //If an index out of bounds error occurs, there are no pictures left to display.
    catch (IndexOutOfBoundsException e) {
      return "end";
    }
  }
}
