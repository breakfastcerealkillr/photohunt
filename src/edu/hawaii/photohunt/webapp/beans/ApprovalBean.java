package edu.hawaii.photohunt.webapp.beans;

import java.util.List;

import edu.hawaii.photohunt.webapp.model.PictureModel;

/**
 * The ApprovalBean class is the backing bean that manages the picture review process.
 * 
 * @author George Lee
 */
public class ApprovalBean {
  /** Default location of the picture files. */
  public static final String DEFAULT_LOCATION = "pictures/";

  /** The current picture being displayed on the webapp. */
  String currentPicture;

  /** The picture model controlling the currently displayed pictures. */
  private final PictureModel model = new PictureModel(DEFAULT_LOCATION);

  /** The pictures awaiting approval. */
  private final List<String> newPictures = model.getNew();

  /**
   * Retrieve the current picture.
   * 
   * @return The file name of the current picture.
   */
  public String getCurrentPicture() {
    return this.currentPicture;
  }

  /**
   * Approve the current picture and move to the next picture.
   * 
   * @return Success if there are pictures available for display. Returns null if there are none.
   */
  public String approvePicture() {
    this.model.approvePicture(currentPicture);

    if (this.newPictures.iterator().hasNext()) {
      this.currentPicture = this.newPictures.iterator().next();
      return "success";
    }

    else {
      // To be implemented later.
      return null;
    }
  }

  /**
   * Deny the current picture and move to the next picture.
   * 
   * @return Success if there are pictures available for display. Returns null if there are none.
   */
  public String denyPicture() {
    this.model.denyPicture(currentPicture);

    if (this.newPictures.iterator().hasNext()) {
      this.currentPicture = this.newPictures.iterator().next();
      return "success";
    }

    else {
      // To be implemented later.
      return null;
    }
  }
}
