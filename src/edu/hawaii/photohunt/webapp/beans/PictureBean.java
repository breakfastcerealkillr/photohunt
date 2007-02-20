package edu.hawaii.photohunt.webapp.beans;

import java.util.List;

import edu.hawaii.photohunt.webapp.model.PictureModel;

/**
 * The PictureBean class is the bean that backs the display of approved pictures in the webapp.
 * 
 * @author George Lee
 * 
 */
public class PictureBean {
  /** Default location of the picture files. */
  public static final String DEFAULT_LOCATION = "pictures/";

  /** The current picture being displayed on the webapp. */
  String currentPicture;

  /** The picture model controlling the currently displayed pictures. */
  private final PictureModel model = new PictureModel(DEFAULT_LOCATION);

  /** The list of approved pictures. */
  private final List<String> approvedPictures = model.getApproved();

  /**
   * Get the current approved picture.
   * 
   * @return The next approved picture.
   */
  public String getCurrentPicture() {
    return this.currentPicture;
  }

  /**
   * Set the current approved picture.
   * 
   * @return Success if there are pictures available for display. Returns null if there are none.
   */
  public String setCurrentPicture() {
    // Determine if there are any more pictures to show.
    if (this.approvedPictures.iterator().hasNext()) {
      this.currentPicture = approvedPictures.iterator().next();
      return "success";
    }

    else {
      // To be implemented.
      return null;
    }
  }
}
