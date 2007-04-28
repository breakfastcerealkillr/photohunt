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
 * The ApprovalBean class is a bean that backs the approval pages in Photo Hunt. The approved
 * pictures are placed onto a stack before being submitted. The trash also uses a stack to keep
 * track of what pictures need to be deleted.
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
      new SelectItem("sample-pictures/", "Sample Pictures"),
      new SelectItem("antique-pictures/", "Antiques"),
      new SelectItem("hawaii-exhibit/", "Hawaiian Exhibit") };

  /** The list of available tags. */
  private final List<SelectItem> tagList = Arrays.asList(TAG_ARRAY);

  /** The context of the web application. */
  private final ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance()
      .getExternalContext().getContext();

  /** List of pictures pending action (approve or delete). */
  protected List<PictureFile> pendingPictures = new ArrayList<PictureFile>();

  /** List of pictures to be approved and displayed on the visitor's page. */
  protected List<PictureFile> approvedPictures = new ArrayList<PictureFile>();

  /** List of pictures to be deleted. */
  protected List<PictureFile> deletedPictures = new ArrayList<PictureFile>();

  /** ApprovalBean constructor. Populates the pending pictures list with pictures from every tag. */
  public ApprovalBean() {
    // Iterate through the list of tags.
    for (SelectItem tag : this.tagList) {
      // Get the real path to the directory.
      File pendingDir = new File(this.servletContext
          .getRealPath(PENDING_DIRECTORY + tag.getValue()));

      // Find the picture files and add them to the list.
      PictureFileFilter pictureFilter = new PictureFileFilter();
      for (File inFile : Arrays.asList(pendingDir.listFiles(pictureFilter))) {
        this.pendingPictures.add(new PictureFile(tag.getLabel(),
            PENDING_DIRECTORY + tag.getValue(), inFile));
      }
    }
  }

  /**
   * Get the list of pending pictures.
   * 
   * @return The list of pictures pending approval.
   */
  public List<PictureFile> getPendingPictures() {
    return this.pendingPictures;
  }

  /**
   * Get the list of approved pictures.
   * 
   * @return The list of pictures that are approved.
   */
  public List<PictureFile> getApprovedPictures() {
    return this.approvedPictures;
  }

  /**
   * Get the list of deleted pictures.
   * 
   * @return The list of pictures that are to be deleted.
   */
  public List<PictureFile> getDeletedPictures() {
    return this.deletedPictures;
  }

  /**
   * Listener for pictures being added to the approved list.
   * 
   * @param file The picture file to be moved.
   * @param target The destination list for the picture file.
   */
  public void movePicture(PictureFile file, String target) {
    //Get the destination list.
    List<PictureFile> destination = null;

    if ("approve".equals(target)) {
      destination = this.approvedPictures;
    }

    else if ("delete".equals(target)) {
      destination = this.deletedPictures;
    }

    else if ("pending".equals(target)) {
      destination = this.pendingPictures;
    }

    //Find the origin of the file.
    if (destination != null) {
      List<PictureFile> origin = null;
      if (this.pendingPictures.contains(file)) {
        origin = this.pendingPictures;
      }

      else if (this.approvedPictures.contains(file)) {
        origin = this.approvedPictures;
      }

      else if (this.deletedPictures.contains(file)) {
        origin = this.deletedPictures;
      }

      //Move the file from the origin to the destination.
      if (origin != null) {
        PictureFile picture = origin.get(origin.indexOf(file));
        destination.add(picture);
        origin.remove(picture);
        return;
      }

    }
    //Present error message.
  }

  /**
   * Approve the pictures in the approved pictures list and refresh the current page.
   * 
   * @return Returns "refresh" to refresh the current page.
   */
  public String approve() {
    for (PictureFile file : this.approvedPictures) {
      // Get the tag the file belongs to and find the path to that directory.
      File approvedFile = new File(this.servletContext.getRealPath(file.getPath()));
      
      // Destination directory.
      File destDir = new File(this.servletContext.getRealPath(APPROVED_DIRECTORY
          + file.getDirectory()));

      // Move the file.
      approvedFile.renameTo(new File(destDir, approvedFile.getName()));
    }

    //Clear the approved list.
    this.approvedPictures.clear();
    
    return "refresh";
  }

}
