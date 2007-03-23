package edu.hawaii.photohunt.webapp.beans;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * The PictureBean class is the bean that backs the display of approved pictures in the webapp.
 * 
 * @author George Lee
 * 
 */
public class PictureBean {

  /** The picture model controlling the currently displayed pictures. */
  protected String[] directory = new File(TempApprovalBean.DEFAULT_APPROVED).list();
  
  /** The current picture being displayed on the webapp. */
  String currentPicture = "approved/samplepic5.jpg";

  /** The list of approved pictures. */
  private final List<String> approvedPictures = new ArrayList<String>();

  /**
   * Constructor for PictureBean class.
   */
  public PictureBean() {
    //May need to leave empty.
  }

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
      return null;
    }

    else {
      // To be implemented.
      return "end";
    }
  }
}
