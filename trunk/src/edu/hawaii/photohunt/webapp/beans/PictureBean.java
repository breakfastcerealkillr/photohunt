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
 * The PictureBean class is the bean that backs the display of approved pictures in the webapp.
 * 
 * @author George Lee
 * 
 */
public class PictureBean {

  /** The context of the web application. */
  private final ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance()
      .getExternalContext().getContext();

  /** List containing the available tags. */
  protected final List<SelectItem> tagList = Arrays.asList(ApprovalBean.TAG_ARRAY);

  /** The current tag directory being browsed. */
  private String tag = "";
  
  /** The status message displayed on the web page. */
  private String status = "Please select a tag.";
  
  /** The style of the status message displayed on the web page. */
  private String statusStyle = "";

  /** The list of approved pictures. */
  private final List<PictureFile> pictures = new ArrayList<PictureFile>();

  /** The list of pictures to be deleted (used by photo-management.jsp).*/
  private final List<PictureFile> deletedPictures = new ArrayList<PictureFile>();

  /**
   * Constructor for PictureBean class.
   */
  public PictureBean() {
    //Needs to be left empty.
  }

  /**
   * Get the list of approved pictures.
   * 
   * @return The list of approved pictures.
   */
  public List<PictureFile> getPictures() {
    return this.pictures;
  }

  /**
   * Get the list of pictures to be deleted.
   * 
   * @return The list of pictures to be deleted.
   */
  public List<PictureFile> getDeletedPictures() {
    return this.deletedPictures;
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
   * @return The tag currently being browsed.
   */
  public String getTag() {
    return this.tag;
  }

  /**
   * Set the current tag.
   * 
   * @param tag The tag to view.
   */
  public void setTag(String tag) {
    this.tag = tag;
  }
  
  /**
   * Get the current status of the page.
   * 
   * @return The status of the web page.
   */
  public String getStatus() {
    return this.status;
  }
  
  /**
   * Get the current style of the status message.
   * 
   * @return The CSS style for the status message.
   */
  public String getStatusStyle() {
    return this.statusStyle;
  }

  /**
   * Update the set of pictures.
   * 
   * @return Returns "refresh" to refresh the current page.
   */
  public String update() {
    //Clear the list of pictures.
    this.pictures.clear();

    //Updated by the dropdown menu
    File approvedDir = new File(servletContext.getRealPath(ApprovalBean.APPROVED_DIRECTORY
        + this.tag));

    // Insert the file names into the lists.
    PictureFileFilter pictureFilter = new PictureFileFilter();
    for (File inFile : Arrays.asList(approvedDir.listFiles(pictureFilter))) {
      this.pictures.add(new PictureFile(ApprovalBean.APPROVED_DIRECTORY + this.tag, inFile));
    }
    
    //Change the status message.
    if (this.pictures.size() == 0) {
      this.status = "There are no pictures for the tag " + this.tag + ", please select another.";
      this.statusStyle = "color: darkred";
    }
    
    else {
      this.status = "Current tag: " + this.tag;
      this.statusStyle = "";
    }

    return "refresh";
  }

}
