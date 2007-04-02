package edu.hawaii.photohunt.webapp.beans;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import edu.hawaii.photohunt.webapp.support.PictureFile;
import edu.hawaii.photohunt.webapp.support.PictureFileFilter;

/**
 * The ApprovalBean class is a bean that backs the approval pages in Photo Hunt. It uses
 * ApprovalModel to manipulate the pictures.
 * 
 * @author George Lee
 * 
 */
public class ApprovalBean {

  /** The path to the approved pictures directory. */
  protected static final String PENDING_DIRECTORY = "pictures/pending/";

  /** The path to the approved pictures directory. */
  protected static final String APPROVED_DIRECTORY = "pictures/approved/";

  /** Array containing the valid tags. */
  protected static final SelectItem[] TAG_ARRAY = { 
    new SelectItem("sample-pictures/","Sample Pictures"), 
    new SelectItem("antique-pictures/", "Antiques"),
    new SelectItem("hawaii-exhibit/", "Hawaiian Exhibit")};
  
  /** The list of available tags.*/
  private final List<SelectItem> tagList = Arrays.asList(TAG_ARRAY);

  /** The context of the web application. */
  private final ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance()
      .getExternalContext().getContext();

  /** The current tag being displayed. */
  private String tag = "";

  /** List of the pending pictures. */
  private List<PictureFile> pendingPictures = new ArrayList<PictureFile>();

  /** List of the selected items. */
  private List<PictureFile> approvedPictures = new ArrayList<PictureFile>();

  /** List of the unselected items. */
  private List<PictureFile> deniedPictures = new ArrayList<PictureFile>();

  /**
   * Constructor for the ApprovalBean.
   */
  public ApprovalBean() {
    // JavaBeans need an empty constructor.
  }
  
  /**
   * Get the list of tags.
   * 
   * @return The list of available tags.
   */
  public List<SelectItem> getTagList() {
    return this.tagList;
  }

  /**
   * Get the current tag.
   * 
   * @return The current tag being displayed.
   */
  public String getTag() {
    return this.tag;
  }

  /**
   * Set the current tag.
   * 
   * @param tag The new tag to display.
   */
  public void setTag(String tag) {
    this.tag = tag;
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
   * Get the denied pictures.
   * 
   * @return The list of the denied pictures.
   */
  public List<PictureFile> getDeniedPictures() {
    return this.deniedPictures;
  }

  /**
   * Change the current tag being viewed.
   * 
   * @return Returns "refresh" to refresh the current page.
   */
  public String changeTag() {
    //Update the list of pictures.
    this.update();

    return "refresh";
  }

  /**
   * Update the list of pictures being browsed.
   */
  private void update() {
    //Clear the list of pending pictures.
    this.pendingPictures.clear();
    
    //Updated by the dropdown menu
    File pendingDir = new File(servletContext.getRealPath(PENDING_DIRECTORY + this.tag));

    // Insert the file names into the lists.
    PictureFileFilter pictureFilter = new PictureFileFilter();
    for (File inFile : Arrays.asList(pendingDir.listFiles(pictureFilter))) {
      this.pendingPictures.add(new PictureFile(PENDING_DIRECTORY + this.tag, inFile));
    }
  }

  /**
   * Sort the list into selected and unselected pictures.
   * 
   * @return Returns "confirm" to continue to the confirmation page.
   */
  public String sortPictures() {
    this.approvedPictures.clear();
    this.deniedPictures.clear();

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
   * the pictures are already sorted into the approved list and the denied list. Updates the list
   * after moving the files.
   * 
   * @return Returns "approved" to return to the approval page.
   */
  public String approvePictures() {
    //Move the approved pictures to the approved directory.
    for (PictureFile approved : this.approvedPictures) {
      File approvedFile = new File(servletContext.getRealPath(approved.getPath()));

      //Move the file.
      approvedFile.renameTo(new File(servletContext.getRealPath(APPROVED_DIRECTORY + this.tag),
          approvedFile.getName()));
    }

    //Delete the unapproved pictures.
    //for (PictureFile denied : this.deniedPictures) {
    //  new File(denied.getPath()).delete();
    //}

    //Refresh the list.
    this.update();

    return "approved";
  }

}
