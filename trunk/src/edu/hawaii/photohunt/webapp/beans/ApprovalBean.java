package edu.hawaii.photohunt.webapp.beans;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.hawaii.photohunt.webapp.model.ApprovalModel;
import edu.hawaii.photohunt.webapp.model.PictureFile;

/**
 * The ApprovalBean class is a bean that backs the approval pages in Photo Hunt. It uses
 * ApprovalModel to manipulate the pictures.
 * 
 * @author George Lee
 * 
 */
public class ApprovalBean {

  /** The model supporting the ApprovalBean. */
  private ApprovalModel model = new ApprovalModel();

  /** List of the pending pictures. */
  private List<PictureFile> pendingPictures = this.model.getPending();
  
  /** The directory containing the approved pictures. */
  private final String approvedDirectory = this.model.getApprovedDirectory();
  
  /** List of the selected items. */
  private List<PictureFile> approvedPictures;
  
  /** List of the unselected items. */
  private List<PictureFile> deniedPictures;

  /**
   * Constructor for the ApprovalBean.
   */
  public ApprovalBean() {
    // JavaBeans need an empty constructor.
  }
  
  /**
   * Get the pictures pending approval.
   * 
   * @return The list of the pending pictures.
   */
  public List<PictureFile> getPendingPictures() {
    return this.pendingPictures;
  }
  
  /**
   * Get the approved pictures.
   * 
   * @return The list of the approved pictures.
   */
  public List<PictureFile> getApprovedPictures() {
    return this.approvedPictures;
  }
  
  /**
   * get the denied pictures.
   * 
   * @return The list of the denied pictures.
   */
  public List<PictureFile> getDeniedPictures() {
    return this.deniedPictures;
  }
  
  /**
   * Sort the list into selected and unselected pictures.
   * 
   * @return Returns "confirm" to continue to the confirmation page.
   */
  public String sortPictures() {
    this.approvedPictures = new ArrayList<PictureFile>();
    this.deniedPictures = new ArrayList<PictureFile>();
    
    for (PictureFile pendingFile : this.pendingPictures) {
      if (pendingFile.isApproved()) {
        this.approvedPictures.add(pendingFile);
      }
      
      else {
        this.deniedPictures.add(pendingFile);
      }
    }
    
    //Navigation case.  Go to confirmation page.
    return "confirm";
  }
  
  /**
   * Approve and deny the pictures in Photo Hunt. This should occur after the confirmation page, so
   * the pictures are sorted into the approved list and the denied list. Updates the list after
   * moving the files.
   * 
   * @return Returns "approved" to return to the approval page.
   */
  public String approvePictures() {
    //Move the approved pictures to the approved directory.
    for (PictureFile approved : this.approvedPictures) {
      File approvedFile = new File(approved.getPath());
      
      //Move the file.
      approvedFile.renameTo(new File(this.approvedDirectory, approved.getPath()));
      
      //Delete original file.
      approvedFile.delete();
    }
    
    //Delete the unapproved pictures.
    for (PictureFile denied : this.deniedPictures) {
      new File(denied.getPath()).delete();
    }
    
    //Update the ApprovalModel.
    this.model = new ApprovalModel();
    this.pendingPictures = this.model.getPending();
    
    return "approved";
  }
  
}
