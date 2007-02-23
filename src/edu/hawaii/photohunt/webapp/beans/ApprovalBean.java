package edu.hawaii.photohunt.webapp.beans;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * The ApprovalBean class is the backing bean that manages the picture review process.
 * 
 * @author George Lee
 */
public class ApprovalBean {
  /** Default location of the picture files pending approval. */
  public static final String DEFAULT_PENDING = "pictures/";

  /** Default location of the approved pictures. */
  public static final String DEFAULT_APPROVED = "approved/";

  /** The file directory containing the pictures pending approval. */
  private final File pendingDirectory = new File(DEFAULT_PENDING);

  /** The pictures awaiting approval. */
  protected List<String> pendingList = Arrays.asList(this.pendingDirectory.list());

  /** The current picture being displayed on the webapp. */
  String currentPicture = "approved/samplepic1.jpg";

  /**
   * Default constructor for the ApprovalBean class.
   *
   */  
  public ApprovalBean() {
    super();
    //May need to leave empty.
  }
  
  /**
   * Retrieve the current picture.
   * 
   * @return The file name of the current picture.
   */
  public String getCurrentPicture() {
    return currentPicture;
  }

  /**
   * Displays the next picture in the pendingList.
   * 
   * @return Returns null if there are pictures to display (forces JSF to redisplay page). Returns
   *         end if there are no pictures left.
   */
  public String setCurrentPicture() {
    // Determine if there are more pictures to display.
    if (this.pendingList.iterator().hasNext()) {
      currentPicture = this.pendingList.iterator().next();
      return null;
    }

    else {
      // Needs to be redone.
      return "end";
    }
  }

  /**
   * Approve the current picture and move to the next picture.
   * 
   * @return Success if there are pictures available for display. Returns null if there are none.
   */
  public String approvePicture() {
    // Approve the current picture by moving it to the approved directory.
    File approved = new File(this.currentPicture);
    File destination = new File(DEFAULT_APPROVED);

    // Move file to new directory
    boolean success = approved.renameTo(new File(destination, approved.getName()));
    if (!success) {
      // Move operation was unsuccessful.
      return "error";
    }

    // Display the next picture.
    return this.setCurrentPicture();
  }

  /**
   * Deny the current picture and move to the next picture.
   * 
   * @return Success if there are pictures available for display. Returns null if there are none.
   */
  public String denyPicture() {
    // Deny the picture by removing the file.
    File denied = new File(this.currentPicture);
    boolean success = denied.delete();
    if (!success) {
      // Deletion operation was unsuccessful.
      return "error";
    }

    // Display the next picture.
    return this.getCurrentPicture();
  }
}
